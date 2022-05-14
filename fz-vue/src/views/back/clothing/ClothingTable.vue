<template>
  <div>
    <!-- 2.卡片视图 -->
    <el-card>
      <!-- 1.导航条 -->
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: '/backHome/clothingTable' }"
          >服装管理</el-breadcrumb-item
        >
        <el-breadcrumb-item>服装列表</el-breadcrumb-item>
      </el-breadcrumb>
      <!-- 2.1 顶部操作 -->
      <br />

      <div>
        <i class="el-icon-search"></i>
        <span>筛选搜索</span>
        <el-button
          style="float: right"
          @click="handleSearchList()"
          type="primary"
          size="small"
        >
          查询结果
        </el-button>
        <el-button
          style="float: right; margin-right: 15px"
          @click="handleResetSearch()"
          size="small"
        >
          重置
        </el-button>
      </div>
      <div style="margin-top: 15px">
        <el-form
          :inline="true"
          :model="listQuery"
          size="small"
          label-width="140px"
        >
          <el-form-item label="输入搜索：">
            <el-input
              style="width: 203px"
              v-model="listQuery.keyword"
              placeholder="商品名称"
            ></el-input>
          </el-form-item>
          <el-form-item label="商品货号：">
            <el-input
              style="width: 203px"
              v-model="listQuery.clothingSn"
              placeholder="商品货号"
            ></el-input>
          </el-form-item>
          <el-form-item label="商品分类：">
            <el-cascader
              clearable
              v-model="selectGoodsCateValue"
              :options="clothingCateOptions"
              style="width: 203px"
            >
            </el-cascader>
          </el-form-item>
          <el-form-item label="商品品牌：">
            <el-select
              style="width: 203px"
              v-model="listQuery.brandId"
              placeholder="请选择品牌"
              clearable
            >
              <el-option
                v-for="item in brandOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              >
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="上架状态：">
            <el-select
              style="width: 203px"
              v-model="listQuery.publishStatus"
              placeholder="全部"
              clearable
            >
              <el-option
                v-for="item in publishStatusOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              >
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="审核状态：">
            <el-select
              style="width: 203px"
              v-model="listQuery.verifyStatus"
              placeholder="全部"
              clearable
            >
              <el-option
                v-for="item in verifyStatusOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              >
              </el-option>
            </el-select>
          </el-form-item>
        </el-form>
      </div>
      <el-card class="operate-container" shadow="never">
        <i class="el-icon-tickets"></i>
        <span>数据列表</span>
        <el-button
          class="btn-add"
          @click="handleAddGoods()"
          size="mini"
          type="primary"
        >
          添加
        </el-button>
        <span style="margin-left: 40px">批量操作：</span>
        <el-button @click="updatePublishStatusOn()" size="mini" type="danger">
          商品上架
        </el-button>
        <el-button
          class="btn-add"
          @click="updatePublishStatusOff()"
          size="mini"
          type="warning"
        >
          商品下架
        </el-button>
        <el-button
          class="btn-add"
          @click="updateRecommendStatusOn()"
          size="mini"
          type="success"
        >
          设为推荐
        </el-button>
        <el-button
          class="btn-add"
          @click="updateRecommendStatusOff()"
          size="mini"
          type="info"
        >
          取消推荐
        </el-button>
      </el-card>
      <div class="table-container">
        <el-table
          ref="clothingTable"
          :data="list"
          style="width: 100%"
          @selection-change="handleSelectionChange"
          border
        >
          <el-table-column
            type="selection"
            width="60"
            align="center"
          ></el-table-column>
          <el-table-column label="编号" width="90" align="center">
            <template slot-scope="scope">{{ scope.row.id }}</template>
          </el-table-column>
          <el-table-column label="商品图片" width="120" align="center">
            <template slot-scope="scope"
              ><img style="height: 80px" :src="scope.row.pic"
            /></template>
          </el-table-column>
          <el-table-column label="商品名称" align="center">
            <template slot-scope="scope">
              <p>{{ scope.row.name }}</p>
              <p>品牌：{{ scope.row.brandName }}</p>
            </template>
          </el-table-column>
          <el-table-column label="价格/货号" width="130" align="center">
            <template slot-scope="scope">
              <p>价格：￥{{ scope.row.price }}</p>
              <p>货号：{{ scope.row.clothingSn }}</p>
            </template>
          </el-table-column>
          <el-table-column label="标签" width="140" align="center">
            <template slot-scope="scope">
              <p>
                上架：
                <el-switch
                  @change="handlePublishStatusChange(scope.$index, scope.row)"
                  :active-value="1"
                  :inactive-value="0"
                  v-model="scope.row.publishStatus"
                >
                </el-switch>
              </p>
              <p>
                推荐：
                <el-switch
                  @change="handleRecommendStatusChange(scope.$index, scope.row)"
                  :active-value="1"
                  :inactive-value="0"
                  v-model="scope.row.recommandStatus"
                >
                </el-switch>
              </p>
            </template>
          </el-table-column>
          <el-table-column label="排序" width="100" align="center">
            <template slot-scope="scope">{{ scope.row.sort }}</template>
          </el-table-column>
          <!-- <el-table-column label="SKU库存" width="100" align="center">
            <template slot-scope="scope">
              <el-button
                type="primary"
                icon="el-icon-edit"
                @click="handleShowSkuEditDialog(scope.$index, scope.row)"
                circle
              ></el-button>
            </template>
          </el-table-column> -->
          <el-table-column label="销量" width="100" align="center">
            <template slot-scope="scope">{{ scope.row.sale }}</template>
          </el-table-column>
          <el-table-column label="审核状态" width="100" align="center">
            <template slot-scope="scope">
              <p>{{ scope.row.verifyStatus | verifyStatusFilter }}</p>
              <p>
                <el-button
                  type="text"
                  @click="handleShowVerifyDetail(scope.$index, scope.row)"
                  >审核详情
                </el-button>
              </p>
            </template>
          </el-table-column>
          <el-table-column label="操作" width="160" align="center">
            <template slot-scope="scope">
              <p>
                <el-button
                  size="mini"
                  @click="handleUpdateGoods(scope.$index, scope.row)"
                  type="warning"
                  >编辑
                </el-button>
                <el-button
                  size="mini"
                  type="danger"
                  @click="handleDelete(scope.$index, scope.row)"
                  >删除
                </el-button>
              </p>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <div class="pagination-container">
        <el-pagination
          background
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          layout="total, sizes,prev, pager, next,jumper"
          :page-size="listQuery.pageSize"
          :page-sizes="[5, 10, 15]"
          :current-page.sync="listQuery.pageNum"
          :total="total"
        >
        </el-pagination>
      </div>
    </el-card>
    <el-dialog
      title="编辑货品信息"
      :visible.sync="editSkuInfo.dialogVisible"
      width="40%"
    >
      <span>商品货号：</span>
      <span>{{ editSkuInfo.clothingSn }}</span>
      <el-input
        placeholder="按sku编号搜索"
        v-model="editSkuInfo.keyword"
        size="small"
        style="width: 50%; margin-left: 20px"
      >
        <el-button
          slot="append"
          icon="el-icon-search"
          @click="handleSearchEditSku"
        ></el-button>
      </el-input>
      <el-table
        style="width: 100%; margin-top: 20px"
        :data="editSkuInfo.stockList"
        border
      >
        <el-table-column label="SKU编号" align="center">
          <template slot-scope="scope">
            <el-input v-model="scope.row.skuCode"></el-input>
          </template>
        </el-table-column>
        <el-table-column
          v-for="(item, index) in editSkuInfo.clothingAttr"
          :label="item.name"
          :key="item.id"
          align="center"
        >
          <template slot-scope="scope">
            {{ getGoodsSkuSp(scope.row, index) }}
          </template>
        </el-table-column>
        <el-table-column label="销售价格" width="80" align="center">
          <template slot-scope="scope">
            <el-input v-model="scope.row.price"></el-input>
          </template>
        </el-table-column>
        <el-table-column label="商品库存" width="80" align="center">
          <template slot-scope="scope">
            <el-input v-model="scope.row.stock"></el-input>
          </template>
        </el-table-column>
        <el-table-column label="库存预警值" width="100" align="center">
          <template slot-scope="scope">
            <el-input v-model="scope.row.lowStock"></el-input>
          </template>
        </el-table-column>
      </el-table>
      <span slot="footer" class="dialog-footer">
        <el-button @click="editSkuInfo.dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="handleEditSkuConfirm"
          >确 定</el-button
        >
      </span>
    </el-dialog>
  </div>
</template>

<!-- 行为，业务逻辑 -->
<script>
import {
  fetchList,
  updateDeleteStatus,
  updateNewStatus,
  updateRecommendStatus,
  updatePublishStatus,
} from "@/api/clothing";
import {
  fetchList as fetchSkuStockList,
  update as updateSkuStockList,
} from "@/api/skuStock";
import { fetchList as fetchGoodsAttrList } from "@/api/clothingAttr";
import { fetchList as fetchBrandList } from "@/api/brand";
import { fetchListWithChildren } from "@/api/clothingCate";

const defaultListQuery = {
  keyword: null,
  pageNum: 1,
  pageSize: 5,
  publishStatus: null,
  verifyStatus: null,
  clothingSn: null,
  clothingCategoryId: null,
  brandId: null,
};
export default {
  name: "clothingList",
  data() {
    return {
      editSkuInfo: {
        dialogVisible: false,
        clothingId: null,
        clothingSn: "",
        clothingAttributeCategoryId: null,
        stockList: [],
        clothingAttr: [],
        keyword: null,
      },
      operates: [
        {
          label: "商品上架",
          value: "publishOn",
        },
        {
          label: "商品下架",
          value: "publishOff",
        },
        {
          label: "设为推荐",
          value: "recommendOn",
        },
        {
          label: "取消推荐",
          value: "recommendOff",
        },
        // {
        //   label: "设为新品",
        //   value: "newOn",
        // },
        // {
        //   label: "取消新品",
        //   value: "newOff",
        // },
        {
          label: "转移到分类",
          value: "transferCategory",
        },
        {
          label: "移入回收站",
          value: "recycle",
        },
      ],
      operateType: null,
      listQuery: Object.assign({}, defaultListQuery),
      list: null,
      total: null,
      // listLoading: true,
      selectGoodsCateValue: null,
      multipleSelection: [],
      clothingCateOptions: [],
      brandOptions: [],
      publishStatusOptions: [
        {
          value: 1,
          label: "上架",
        },
        {
          value: 0,
          label: "下架",
        },
      ],
      verifyStatusOptions: [
        {
          value: 1,
          label: "审核通过",
        },
        {
          value: 0,
          label: "未审核",
        },
      ],
    };
  },
  created() {
    this.getList();
    this.getBrandList();
    this.getGoodsCateList();
  },
  watch: {
    selectGoodsCateValue: function (newValue) {
      if (newValue != null && newValue.length == 2) {
        this.listQuery.clothingCategoryId = newValue[1];
      } else {
        this.listQuery.clothingCategoryId = null;
      }
    },
  },
  filters: {
    verifyStatusFilter(value) {
      if (value === 1) {
        return "审核通过";
      } else {
        return "未审核";
      }
    },
  },
  methods: {
    getGoodsSkuSp(row, index) {
      let spData = JSON.parse(row.spData);
      if (spData != null && index < spData.length) {
        return spData[index].value;
      } else {
        return null;
      }
    },
    getList() {
      fetchList(this.listQuery).then((response) => {
        this.list = response.data.list;
        this.total = response.data.total;
        console.log("response", response);
      });
    },
    getBrandList() {
      fetchBrandList({ pageNum: 1, pageSize: 100 }).then((response) => {
        this.brandOptions = [];
        let brandList = response.data.list;
        for (let i = 0; i < brandList.length; i++) {
          this.brandOptions.push({
            label: brandList[i].name,
            value: brandList[i].id,
          });
        }
      });
    },
    getGoodsCateList() {
      fetchListWithChildren().then((response) => {
        let list = response.data;
        this.clothingCateOptions = [];
        for (let i = 0; i < list.length; i++) {
          let children = [];
          if (list[i].children != null && list[i].children.length > 0) {
            for (let j = 0; j < list[i].children.length; j++) {
              children.push({
                label: list[i].children[j].name,
                value: list[i].children[j].id,
              });
            }
          }
          this.clothingCateOptions.push({
            label: list[i].name,
            value: list[i].id,
            children: children,
          });
        }
      });
    },
    handleShowSkuEditDialog(index, row) {
      this.editSkuInfo.clothingId = row.id;
      this.editSkuInfo.clothingSn = row.clothingSn;
      this.editSkuInfo.clothingAttributeCategoryId =
        row.clothingAttributeCategoryId;
      this.editSkuInfo.keyword = null;
      fetchSkuStockList(row.id, { keyword: this.editSkuInfo.keyword }).then(
        (response) => {
          this.editSkuInfo.stockList = response.data;
        }
      );
      if (row.clothingAttributeCategoryId != null) {
        fetchGoodsAttrList(row.clothingAttributeCategoryId, { type: 0 }).then(
          (response) => {
            this.editSkuInfo.clothingAttr = response.data.list;
          }
        );
      }
      this.editSkuInfo.dialogVisible = true;
    },
    handleSearchEditSku() {
      fetchSkuStockList(this.editSkuInfo.clothingId, {
        keyword: this.editSkuInfo.keyword,
      }).then((response) => {
        this.editSkuInfo.stockList = response.data;
      });
    },
    handleEditSkuConfirm() {
      if (
        this.editSkuInfo.stockList == null ||
        this.editSkuInfo.stockList.length <= 0
      ) {
        this.$message({
          message: "暂无sku信息",
          type: "warning",
          duration: 1000,
        });
        return;
      }
      this.$confirm("是否要进行修改", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        updateSkuStockList(
          this.editSkuInfo.clothingId,
          this.editSkuInfo.stockList
        ).then((response) => {
          this.$message({
            message: "修改成功",
            type: "success",
            duration: 1000,
          });
          this.editSkuInfo.dialogVisible = false;
        });
      });
    },
    handleSearchList() {
      this.listQuery.pageNum = 1;
      console.log("listQuery", this.listQuery);
      this.getList();
    },
    handleAddGoods() {
      this.$router.push({ path: "/backHome/clothingAdd" });
    },
    updatePublishStatusOn() {
      this.$confirm("是否要进行批量上架?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        let ids = [];
        for (let i = 0; i < this.multipleSelection.length; i++) {
          ids.push(this.multipleSelection[i].id);
        }
        this.updatePublishStatus(1, ids);
        this.getList();
      });
    },
    updatePublishStatusOff() {
      this.$confirm("是否要进行批量下架?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        let ids = [];
        for (let i = 0; i < this.multipleSelection.length; i++) {
          ids.push(this.multipleSelection[i].id);
        }
        this.updatePublishStatus(0, ids);
        this.getList();
      });
    },
    updateRecommendStatusOn() {
      this.$confirm("是否要进行批量推荐?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        let ids = [];
        for (let i = 0; i < this.multipleSelection.length; i++) {
          ids.push(this.multipleSelection[i].id);
        }
        this.updateRecommendStatus(1, ids);
        this.getList();
      });
    },
    updateRecommendStatusOff() {
      console.log("this.multipleSelection", this.multipleSelection);
      this.$confirm("是否要进行批量取消推荐?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        let ids = [];
        for (let i = 0; i < this.multipleSelection.length; i++) {
          ids.push(this.multipleSelection[i].id);
        }
        this.updateRecommendStatus(0, ids);
        this.getList();
      });
    },
    handleSizeChange(val) {
      this.listQuery.pageNum = 1;
      this.listQuery.pageSize = val;
      this.getList();
    },
    handleCurrentChange(val) {
      this.listQuery.pageNum = val;
      this.getList();
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    handlePublishStatusChange(index, row) {
      let ids = [];
      ids.push(row.id);
      console.log("ids", ids);
      this.updatePublishStatus(row.publishStatus, ids);
    },
    handleRecommendStatusChange(index, row) {
      let ids = [];
      ids.push(row.id);
      this.updateRecommendStatus(row.recommandStatus, ids);
    },
    handleResetSearch() {
      this.selectGoodsCateValue = [];
      this.listQuery = Object.assign({}, defaultListQuery);
    },
    handleDelete(index, row) {
      this.$confirm("是否要进行删除操作?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        let ids = [];
        ids.push(row.id);
        this.updateDeleteStatus(1, ids);
      });
      // this.getList();
    },
    handleUpdateGoods(index, row) {
      this.$router.push({
        path: "/backHome/clothingUpdate",
        query: { id: row.id },
      });
    },
    handleShowGoods(index, row) {
      console.log("handleShowGoods", row);
    },
    handleShowVerifyDetail(index, row) {
      console.log("handleShowVerifyDetail", row);
    },
    handleShowLog(index, row) {
      console.log("handleShowLog", row);
    },
    updatePublishStatus(publishStatus, ids) {
      console.log("publishStatus", publishStatus);
      console.log("ids", ids);
      let params = new URLSearchParams();
      params.append("ids", ids);
      params.append("publishStatus", publishStatus);
      updatePublishStatus(params).then((response) => {
        this.$message({
          message: "修改成功",
          type: "success",
          duration: 1000,
        });
      });
    },
    updateRecommendStatus(recommendStatus, ids) {
      let params = new URLSearchParams();
      params.append("ids", ids);
      params.append("recommendStatus", recommendStatus);
      updateRecommendStatus(params).then((response) => {
        this.$message({
          message: "修改成功",
          type: "success",
          duration: 1000,
        });
      });
    },
    updateDeleteStatus(deleteStatus, ids) {
      let params = new URLSearchParams();
      params.append("ids", ids);
      params.append("deleteStatus", deleteStatus);
      updateDeleteStatus(params).then((response) => {
        this.$message({
          message: "删除成功",
          type: "success",
          duration: 1000,
        });
        this.getList();
      });
    },
  },
};
</script>
<style>
.app-container {
  margin-left: 200px;
}

.operate-container {
  margin: 20px 0;
}

.operate-container .btn-add {
  margin-left: 20px;
}

.batch-operate-container {
  display: inline-block;
  margin-top: 20px;
}

.pagination-container {
  /* display: inline-block; */
  float: right;
  margin-top: 20px;
}
</style>
