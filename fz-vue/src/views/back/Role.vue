<template>
  <div>
    <el-card>
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>角色管理</el-breadcrumb-item>
        <el-breadcrumb-item>角色列表</el-breadcrumb-item>
      </el-breadcrumb>

      <br />
      <div>
        <i class="el-icon-search"></i>
        <span>筛选搜索</span>
        <el-button
          style="float: right"
          type="primary"
          @click="handleSearchList()"
          size="small"
        >
          查询搜索
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
              v-model="listQuery.keyword"
              class="input-width"
              placeholder="角色名称"
              clearable
            ></el-input>
          </el-form-item>
        </el-form>
      </div>
      <el-card class="operate-container" shadow="never">
        <i class="el-icon-tickets"></i>
        <span>数据列表</span>
        <el-button
          size="mini"
          class="btn-add"
          type="primary"
          @click="handleAdd()"
          style="margin-left: 20px"
          >添加</el-button
        >
      </el-card>
      <br />

      <el-table ref="roleTable" :data="list" style="width: 100%" border>
        <el-table-column label="编号" width="100" align="center">
          <template slot-scope="scope">{{ scope.row.id }}</template>
        </el-table-column>
        <el-table-column label="角色名称" align="center">
          <template slot-scope="scope">{{ scope.row.name }}</template>
        </el-table-column>
        <el-table-column label="描述" align="center">
          <template slot-scope="scope">{{ scope.row.description }}</template>
        </el-table-column>
        <el-table-column label="创建时间" width="160" align="center">
          <template slot-scope="scope">{{
            scope.row.createTime | formatDateTime
          }}</template>
        </el-table-column>
        <el-table-column label="是否启用" width="140" align="center">
          <template slot-scope="scope">
            <el-switch
              @change="handleStatusChange(scope.$index, scope.row)"
              :active-value="1"
              :inactive-value="0"
              v-model="scope.row.status"
            >
            </el-switch>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center">
          <template slot-scope="scope">
            <el-row>
              <el-button
                size="mini"
                type="info"
                @click="handleUpdate(scope.$index, scope.row)"
              >
                <i class="el-icon-edit"></i>编辑
              </el-button>
              <el-button
                size="mini"
                type="warning"
                @click="handleDelete(scope.$index, scope.row)"
                ><i class="el-icon-delete"></i>删除
              </el-button>
            </el-row>
          </template>
        </el-table-column>
      </el-table>

      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="listQuery.pageNum"
        :page-size="listQuery.pageSize"
        :page-sizes="[5, 10, 20, 40]"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
        style="margin-top: 20px"
      >
      </el-pagination>
    </el-card>

    <!-- 3.弹框区域 -->

    <!-- 添加/编辑框 -->
    <el-dialog
      :title="isEdit ? '编辑角色' : '添加角色'"
      :visible.sync="dialogVisible"
      width="40%"
    >
      <el-form
        :model="role"
        :rules="roleRules"
        ref="roleRef"
        label-width="150px"
        size="small"
      >
        <el-form-item label="角色名称：" prop="name">
          <el-input v-model="role.name" style="width: 250px"></el-input>
        </el-form-item>
        <el-form-item label="描述：">
          <el-input
            v-model="role.description"
            type="textarea"
            :rows="5"
            style="width: 250px"
          ></el-input>
        </el-form-item>
        <el-form-item label="是否启用：">
          <el-radio-group v-model="role.status">
            <el-radio :label="1">是</el-radio>
            <el-radio :label="0">否</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false" size="small">取 消</el-button>
        <el-button type="primary" @click="handleDialogConfirm()" size="small"
          >确 定</el-button
        >
      </span>
    </el-dialog>
  </div>
</template>

<script>
import {
  fetchList,
  createRole,
  updateRole,
  updateStatus,
  deleteRole,
} from "@/api/role";
import { formatDate } from "@/utils/date";

const defaultListQuery = {
  pageNum: 1,
  pageSize: 5,
  keyword: null,
};
const defaultRole = {
  id: null,
  name: null,
  description: null,
  status: 1,
};
export default {
  //变量，配合ElementUI使用
  data() {
    return {
      total: 0,
      listQuery: Object.assign({}, defaultListQuery),
      dialogVisible: false,
      role: {},
      isEdit: null,

      queryInfo: {
        roleName: "",
        auNum: "",
        pagenum: 1,
        pagesize: 10,
      },
      list: [],

      multipleSelection: [],
      addDialogVisible: false,
      addForm: {
        roleName: "",
        rolePerms: "",
        remark: "",
      },

      roleRules: {
        name: [{ required: true, message: "角色名不能为空", trigger: "blur" }],
      },
    };
  },
  created() {
    this.getList();
  },
  filters: {
    formatDateTime(time) {
      if (time == null || time === "") {
        return "N/A";
      }
      let date = new Date(time);
      return formatDate(date, "yyyy-MM-dd hh:mm:ss");
    },
  },
  methods: {
    getList() {
      fetchList(this.listQuery).then((response) => {
        this.list = response.data.list;
        this.total = response.data.total;
      });
    },
    handleSearchList() {
      this.listQuery.pageNum = 1;
      this.getList();
    },
    handleAdd() {
      this.dialogVisible = true;
      this.isEdit = false;
      this.role = Object.assign({}, defaultRole);
    },
    handleUpdate(index, row) {
      this.dialogVisible = true;
      this.isEdit = true;
      this.role = Object.assign({}, row);
    },
    handleDialogConfirm() {
      this.$refs.roleRef.validate((valid) => {
        if (!valid) {
          return;
        }
        this.$confirm("是否要确认?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        }).then(() => {
          if (this.isEdit) {
            updateRole(this.role.id, this.role).then((response) => {
              this.$message({
                message: "修改成功！",
                type: "success",
              });
              this.dialogVisible = false;
              this.getList();
            });
          } else {
            createRole(this.role).then((response) => {
              this.$message({
                message: "添加成功！",
                type: "success",
              });
              this.dialogVisible = false;
              this.getList();
            });
          }
        });
      });
    },
    handleStatusChange(index, row) {
      this.$confirm("是否要修改该状态?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          updateStatus(row.id, { status: row.status }).then((response) => {
            this.$message({
              type: "success",
              message: "修改成功!",
            });
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "取消修改",
          });
          this.getList();
        });
    },
    handleDelete(index, row) {
      this.$confirm("是否要删除该角色?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        let ids = [];
        ids.push(row.id);
        let params = new URLSearchParams();
        params.append("ids", ids);
        deleteRole(params).then((response) => {
          this.$message({
            type: "success",
            message: "删除成功!",
          });
          this.getList();
        });
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
  },
};
</script>

<!-- css 样式 scoped 本页CSS有效 -->
<style  scoped>
.operate-container {
  margin-top: 20px;
  margin-bottom: 20px;
}
.jsoneditor-poweredBy {
  display: none;
}
.jsoneditor-vue {
  min-height: 400px;
}
</style>
