<template>
  <div>
    <el-card>
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: '/backHome/clothingTable' }"
          >服装管理</el-breadcrumb-item
        >
        <el-breadcrumb-item>服装类别管理</el-breadcrumb-item>
      </el-breadcrumb>
      <!-- 2.1 顶部操作 -->
      <br />

      <el-card class="operate-container" shadow="never">
        <i class="el-icon-tickets" style="margin-top: 5px"></i>
        <span style="margin-top: 5px">数据列表</span>
        <el-button class="btn-add" @click="handleAddClothingCate()" size="mini" type="primary">
          添加
        </el-button>
      </el-card>
      <div class="table-container">
        <el-table
          ref="clothingCateTable"
          style="width: 100%"
          :data="list"
          border
        >
          <el-table-column label="编号" width="100" align="center">
            <template slot-scope="scope">{{ scope.row.id }}</template>
          </el-table-column>
          <el-table-column label="分类名称" align="center">
            <template slot-scope="scope">{{ scope.row.name }}</template>
          </el-table-column>
          <el-table-column label="级别" width="100" align="center">
            <template slot-scope="scope">{{
              scope.row.level | levelFilter
            }}</template>
          </el-table-column>
          <el-table-column label="商品数量" width="100" align="center">
            <template slot-scope="scope">{{ scope.row.clothingCount }}</template>
          </el-table-column>
          <el-table-column label="数量单位" width="100" align="center">
            <template slot-scope="scope">{{ scope.row.clothingUnit }}</template>
          </el-table-column>
          <el-table-column label="导航栏" width="100" align="center">
            <template slot-scope="scope">
              <el-switch
                @change="handleNavStatusChange(scope.$index, scope.row)"
                :active-value="1"
                :inactive-value="0"
                v-model="scope.row.navStatus"
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
          <el-table-column label="排序" width="100" align="center">
            <template slot-scope="scope">{{ scope.row.sort }}</template>
          </el-table-column>
          <el-table-column label="设置" width="200" align="center">
            <template slot-scope="scope">
              <el-button
                size="mini"
                :disabled="scope.row.level | disableNextLevel"
                @click="handleShowNextLevel(scope.$index, scope.row)"
                >查看下级
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
  deleteClothingCate,
  updateShowStatus,
  updateNavStatus,
} from "@/api/clothingCate";

export default {
  name: "clothingCateList",
  data() {
    return {
      list: null,
      total: null,
      listQuery: {
        pageNum: 1,
        pageSize: 5,
      },
      parentId: 0,
    };
  },
  created() {
    this.resetParentId();
    this.getList();
  },
  watch: {
    $route(route) {
      this.resetParentId();
      this.getList();
    },
  },
  methods: {
    // 重置parentId的值
    resetParentId() {
      this.listQuery.pageNum = 1;
      if (this.$route.query.parentId != null) {
        this.parentId = this.$route.query.parentId;
      } else {
        this.parentId = 0;
      }
    },
    handleAddClothingCate() {
      this.$router.push("/backHome/addClothingCate");
    },
    // 通过parentId获取所有的类别信息
    getList() {
      fetchList(this.parentId, this.listQuery).then((response) => {
        this.list = response.data.list;
        this.total = response.data.total;
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
    handleNavStatusChange(index, row) {
      let data = new URLSearchParams();
      let ids = [];
      ids.push(row.id);
      data.append("ids", ids);
      data.append("navStatus", row.navStatus);
      updateNavStatus(data).then((response) => {
        this.$message({
          message: "修改成功",
          type: "success",
          duration: 1000,
        });
      });
    },
    handleShowStatusChange(index, row) {
      let data = new URLSearchParams();
      let ids = [];
      ids.push(row.id);
      data.append("ids", ids);
      data.append("showStatus", row.showStatus);
      updateShowStatus(data).then((response) => {
        this.$message({
          message: "修改成功",
          type: "success",
          duration: 1000,
        });
      });
    },
    // 携带一级类别的row.id传给路由页面/backHome/clothingCategory
    handleShowNextLevel(index, row) {
      this.$router.push({
        path: "/backHome/clothingCategory",
        query: { parentId: row.id },
      });
    },
    handleUpdate(index, row) {
      this.$router.push({
        path: "/backHome/updateClothingCate",
        query: { id: row.id },
      });
    },
    handleDelete(index, row) {
      this.$confirm("是否要删除该品牌", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        deleteClothingCate(row.id).then((response) => {
          this.$message({
            message: "删除成功",
            type: "success",
            duration: 1000,
          });
          this.getList();
        });
      });
    },
  },
  filters: {
    levelFilter(value) {
      if (value === 0) {
        return "一级";
      } else if (value === 1) {
        return "二级";
      }
    },
    disableNextLevel(value) {
      if (value === 0) {
        return false;
      } else {
        return true;
      }
    },
  },
};
</script>

<style scoped>
.operate-container .btn-add {
  float: right;
}

.pagination-container {
  float: right;
  margin: 20px 0;
}
</style>
