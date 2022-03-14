<template>
   
  <div>
    <!-- 2.卡片视图 -->
    <el-card>
      <!-- 1.导航条 -->
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: '/backHome/clothingTable' }"
          >品牌管理</el-breadcrumb-item
        >
        <el-breadcrumb-item>品牌列表</el-breadcrumb-item>
      </el-breadcrumb>
      <!-- 2.1 顶部操作 -->
      <br />
      <div>
        <i class="el-icon-search"></i>
        <span>筛选搜索</span>
        <el-button
          style="float: right"
          @click="searchBrandList()"
          type="primary"
          size="small"
        >
          查询结果
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
              placeholder="品牌名称/关键字"
            ></el-input>
          </el-form-item>
        </el-form>
      </div>
      <el-card class="operate-container" shadow="never">
        <i class="el-icon-tickets"></i>
        <span>数据列表</span>
        <el-button class="btn-add" @click="addBrand()" size="mini" type="primary">
          添加
        </el-button>
        <span style="margin-left: 40px">批量操作：</span>
        <el-button @click="showBrandStatusOn()" size="mini" type="success">
          显示品牌
        </el-button>
        <el-button
          class="btn-add"
          @click="showBrandStatusOff()"
          size="mini"
          type="warning"
        >
          隐藏品牌
        </el-button>
      </el-card>
      <div class="table-container">
        <el-table
          ref="brandTable"
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
          <el-table-column label="编号" width="100" align="center">
            <template slot-scope="scope">{{ scope.row.id }}</template>
          </el-table-column>
          <el-table-column label="品牌名称" align="center">
            <template slot-scope="scope">{{ scope.row.name }}</template>
          </el-table-column>
          <el-table-column label="品牌首字母" width="100" align="center">
            <template slot-scope="scope">{{ scope.row.firstLetter }}</template>
          </el-table-column>
          <el-table-column label="排序" width="100" align="center">
            <template slot-scope="scope">{{ scope.row.sort }}</template>
          </el-table-column>
          <el-table-column label="品牌制造商" width="100" align="center">
            <template slot-scope="scope">
              <el-switch
                @change="handleFactoryStatusChange(scope.$index, scope.row)"
                :active-value="1"
                :inactive-value="0"
                v-model="scope.row.factoryStatus"
              >
              </el-switch>
            </template>
          </el-table-column>
          <el-table-column label="是否显示" width="100" align="center">
            <template slot-scope="scope">
              <el-switch
                @change="handleShowStatusChange(scope.$index, scope.row)"
                :active-value="1"
                :inactive-value="0"
                v-model="scope.row.showStatus"
              >
              </el-switch>
            </template>
          </el-table-column>
          <el-table-column label="相关" width="220" align="center">
            <template slot-scope="scope">
              <span>商品：</span>
              <el-button
                size="mini"
                type="text"
                @click="getProductList(scope.$index, scope.row)"
                >100
              </el-button>
              <span>评价：</span>
              <el-button
                size="mini"
                type="text"
                @click="getProductCommentList(scope.$index, scope.row)"
                >1000
              </el-button>
            </template>
          </el-table-column>
          <el-table-column label="操作" width="200" align="center">
            <template slot-scope="scope">
              <el-button
                size="mini"
                @click="handleUpdate(scope.$index, scope.row)"
                >编辑
              </el-button>
              <el-button
                size="mini"
                type="danger"
                @click="handleDelete(scope.$index, scope.row)"
                >删除
              </el-button>
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
  </div>
</template>
<script>
import {
  fetchList,
  updateShowStatus,
  updateFactoryStatus,
  deleteBrand,
} from "@/api/brand";

export default {
  name: "brandList",
  data() {
    return {
      operates: [
        {
          label: "显示品牌",
          value: "showBrand",
        },
        {
          label: "隐藏品牌",
          value: "hideBrand",
        },
      ],
      operateType: null,
      listQuery: {
        keyword: null,
        pageNum: 1,
        pageSize: 10,
      },
      list: null,
      total: null,
      multipleSelection: [],
    };
  },
  created() {
    this.getList();
  },
  methods: {
    getList() {
      fetchList(this.listQuery).then((response) => {
        this.list = response.data.list;
        this.total = response.data.total;
        this.totalPage = response.data.totalPage;
        this.pageSize = response.data.pageSize;
      });
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    handleUpdate(index, row) {
      this.$router.push({ path: "/backHome/brandUpdate", query: { id: row.id } });
    },
    handleDelete(index, row) {
      this.$confirm("是否要删除该品牌", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        deleteBrand(row.id).then((response) => {
          this.$message({
            message: "删除成功",
            type: "success",
            duration: 1000,
          });
          this.getList();
        });
      });
    },
    getProductList(index, row) {
      console.log(index, row);
    },
    getProductCommentList(index, row) {
      console.log(index, row);
    },
    handleFactoryStatusChange(index, row) {
      var data = new URLSearchParams();
      data.append("ids", row.id);
      data.append("factoryStatus", row.factoryStatus);
      updateFactoryStatus(data)
        .then((response) => {
          this.$message({
            message: "修改成功",
            type: "success",
            duration: 1000,
          });
        })
        .catch((error) => {
          if (row.factoryStatus === 0) {
            row.factoryStatus = 1;
          } else {
            row.factoryStatus = 0;
          }
        });
    },
    handleShowStatusChange(index, row) {
      let data = new URLSearchParams();
      data.append("ids", row.id);
      data.append("showStatus", row.showStatus);
      updateShowStatus(data)
        .then((response) => {
          this.$message({
            message: "修改成功",
            type: "success",
            duration: 1000,
          });
        })
        .catch((error) => {
          if (row.showStatus === 0) {
            row.showStatus = 1;
          } else {
            row.showStatus = 0;
          }
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
    searchBrandList() {
      this.listQuery.pageNum = 1;
      this.getList();
    },
    showBrandStatusOn() {
      if (this.multipleSelection < 1) {
        this.$message({
          message: "请选择一条记录",
          type: "warning",
          duration: 1000,
        });
        return;
      }
      let showStatus = 1;
      let ids = [];
      for (let i = 0; i < this.multipleSelection.length; i++) {
        ids.push(this.multipleSelection[i].id);
      }
      let data = new URLSearchParams();
      data.append("ids", ids);
      data.append("showStatus", showStatus);
      updateShowStatus(data).then((response) => {
        this.getList();
        this.$message({
          message: "修改成功",
          type: "success",
          duration: 1000,
        });
      });
    },
    showBrandStatusOff() {
      if (this.multipleSelection < 1) {
        this.$message({
          message: "请选择一条记录",
          type: "warning",
          duration: 1000,
        });
        return;
      }
      let showStatus = 0;
      let ids = [];
      for (let i = 0; i < this.multipleSelection.length; i++) {
        ids.push(this.multipleSelection[i].id);
      }
      let data = new URLSearchParams();
      data.append("ids", ids);
      data.append("showStatus", showStatus);
      updateShowStatus(data).then((response) => {
        this.getList();
        this.$message({
          message: "修改成功",
          type: "success",
          duration: 1000,
        });
      });
    },
    addBrand() {
      this.$router.push({ path: "/backHome/brandAdd" });
    },
  },
};
</script>
<style rel="stylesheet/scss" lang="scss" scoped>
.operate-container .btn-add {
  margin-left: 20px;
}
.pagination-container {
  float: right;
  margin-top: 20px;
  margin-bottom: 20px;
}
</style>
