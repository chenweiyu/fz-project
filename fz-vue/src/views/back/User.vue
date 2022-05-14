<template>
  <div>
    <!-- 2.卡片视图 -->
    <el-card>
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>系统管理</el-breadcrumb-item>
        <el-breadcrumb-item>用户列表</el-breadcrumb-item>
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
              placeholder="帐号/姓名"
              clearable
            ></el-input>
          </el-form-item>
        </el-form>
      </div>
      <el-card class="operate-container" shadow="never">
        <i class="el-icon-tickets"></i>
        <span>用户列表</span>
        <el-button
          size="mini"
          type="primary"
          @click="handleAdd()"
          style="margin-left: 20px"
          >添加</el-button
        >
        <span style="margin: 0 20px 0 40px">批量操作</span>
        <el-button size="mini" type="danger" @click="handleDelete(-1)"
          >批量删除</el-button
        >
      </el-card>
      <el-table
        :data="list"
        border
        stripe
        @selection-change="handleSelectionChange"
      >
        <el-table-column type="selection" width="60"></el-table-column>
        <el-table-column type="index" label="序号" width="60"></el-table-column>
        <el-table-column label="帐号" align="center" width="120">
          <template slot-scope="scope">{{ scope.row.username }}</template>
        </el-table-column>
        <el-table-column label="姓名" align="center" width="120">
          <template slot-scope="scope">{{ scope.row.nickname }}</template>
        </el-table-column>
        <el-table-column
          label="联系方式"
          prop="phone"
          align="center"
        ></el-table-column>
        <el-table-column
          label="邮箱"
          prop="email"
          align="center"
        ></el-table-column>
        <el-table-column
          label="性别"
          prop="sex"
          align="center"
          width="80"
        ></el-table-column>
        <el-table-column label="注册时间" width="160" align="center">
          <template slot-scope="scope">{{
            scope.row.regTime | formatDateTime
          }}</template>
        </el-table-column>
        <el-table-column label="是否启用" width="120" align="center">
          <template slot-scope="scope">
            <el-switch
              @change="handleStatusChange(scope.$index, scope.row)"
              :active-value="1"
              :inactive-value="0"
              v-model="scope.row.state"
            >
            </el-switch>
          </template>
        </el-table-column>
        <!-- 自定义列 -->
        <el-table-column label="操作" width="180">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="text"
              @click="handleSelectRole(scope.$index, scope.row)"
              >分配角色
            </el-button>
            <el-button
              size="mini"
              type="text"
              @click="handleUpdate(scope.$index, scope.row)"
            >
              编辑
            </el-button>
            <el-button
              size="mini"
              type="text"
              @click="handleDelete(scope.$index, scope.row)"
              >删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>

      <br />
      <!-- 2.3 分页区域 -->
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="listQuery.pageNum"
        :page-size="listQuery.pageSize"
        :page-sizes="[5, 10, 20, 40]"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
      >
      </el-pagination>

      <!-- 添加/编辑用户 -->
      <el-dialog
        :title="isEdit ? '编辑用户' : '添加用户'"
        :visible.sync="dialogVisible"
        width="40%"
      >
        <el-form
          :model="user"
          :rules="userRules"
          ref="userRef"
          label-width="150px"
          size="small"
        >
          <el-form-item label="帐号：" prop="username">
            <el-input v-model="user.username" style="width: 250px"></el-input>
          </el-form-item>
          <el-form-item label="姓名：">
            <el-input v-model="user.nickname" style="width: 250px"></el-input>
          </el-form-item>
          <el-form-item label="密码：" prop="password">
            <el-input
              v-model="user.password"
              type="password"
              style="width: 250px"
            ></el-input>
          </el-form-item>
          <el-form-item label="电话：">
            <el-input v-model="user.phone" style="width: 250px"></el-input>
          </el-form-item>
          <el-form-item label="邮箱：">
            <el-input v-model="user.email" style="width: 250px"></el-input>
          </el-form-item>
          <el-form-item label="性别：">
            <el-select
              v-model="user.sex"
              placeholder="请选择性别"
              style="width: 250px"
            >
              <el-option label="男" value="男"></el-option>
              <el-option label="女" value="女"></el-option>
              <el-option label="其他" value="其他"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="是否启用：">
            <el-radio-group v-model="user.state">
              <el-radio :label="1">是</el-radio>
              <el-radio :label="0">否</el-radio>
            </el-radio-group>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false" size="small"
            >取 消</el-button
          >
          <el-button type="primary" @click="handleDialogConfirm()" size="small"
            >确 定</el-button
          >
        </span>
      </el-dialog>

      <!-- 分配角色弹出框 -->
      <el-dialog
        title="分配角色"
        :visible.sync="allocDialogVisible"
        width="30%"
      >
        <el-select
          v-model="allocRoleIds"
          multiple
          placeholder="请选择"
          size="small"
          style="width: 80%"
        >
          <el-option
            v-for="item in allRoleList"
            :key="item.id"
            :label="item.name"
            :value="item.id"
          >
          </el-option>
        </el-select>
        <span slot="footer" class="dialog-footer">
          <el-button @click="allocDialogVisible = false" size="small"
            >取 消</el-button
          >
          <el-button
            type="primary"
            @click="handleAllocDialogConfirm()"
            size="small"
            >确 定</el-button
          >
        </span>
      </el-dialog>
    </el-card>
  </div>
</template>

<script>
import {
  fetchList,
  updateStatus,
  getRoleByUser,
  allocRole,
  updateUser,
  createUser,
  deleteUser,
} from "@/api/user";
import { fetchAllRoleList } from "@/api/role";
import { formatDate } from "@/utils/date";
const defaultListQuery = {
  pageNum: 1,
  pageSize: 10,
  keyword: null,
};
const defaultUser = {
  id: null,
  username: null,
  password: null,
  nickname: null,
  enabled: 0,
  phone: null,
  email: null,
  sex: null,
  state: 1,
};
export default {
  name: "User",
  data() {
    return {
      file: "",
      list: [],
      listQuery: Object.assign({}, defaultListQuery),
      multipleSelection: [],
      total: 0,
      allCheckList: [],
      addDialogVisible: false,
      dialogVisible: false,
      allocDialogVisible: false,
      user: Object.assign({}, defaultUser),
      isEdit: false,
      allocRoleIds: [],
      allRoleList: [],
      allocUserId: null,

      userRules: {
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          {
            min: 1,
            max: 100,
            message: "长度在 1 到 100 个字符",
            trigger: "blur",
          },
        ],
        password: [
          { required: true, message: "请输入密码", trigger: "blur" },
          {
            min: 3,
            message: "长度不少与3个字符",
            trigger: "blur",
          },
        ],
      },
      editDialogVisible: false,
    };
  },
  //生命函数
  created() {
    this.getList();
    this.getAllRoleList();
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
    handleSearchList() {
      this.listQuery.pageNum = 1;
      this.getList();
    },
    getList() {
      fetchList(this.listQuery).then((response) => {
        if (response.code === 200) {
          this.list = response.data.list;
          this.total = response.data.total;
        }
      });
    },
    getAllRoleList() {
      fetchAllRoleList().then((response) => {
        this.allRoleList = response.data;
      });
    },

    handleAdd() {
      this.dialogVisible = true;
      this.isEdit = false;
      this.user = Object.assign({}, defaultUser);
    },

    handleStatusChange(index, row) {
      this.$confirm("是否要修改该状态?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          console.log(row.state);
          updateStatus(row.id, { status: row.state }).then((response) => {
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

    handleSelectRole(index, row) {
      this.allocUserId = row.id;
      this.allocDialogVisible = true;
      this.getRoleListByUser(row.id);
    },
    // 提交用户id与角色数组ids给服务端
    handleAllocDialogConfirm() {
      this.$confirm("是否要确认?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        let params = new URLSearchParams();
        params.append("userId", this.allocUserId);
        params.append("roleIds", this.allocRoleIds);
        allocRole(params).then((response) => {
          this.$message({
            message: "分配成功！",
            type: "success",
          });
          this.allocDialogVisible = false;
        });
      });
    },
    getRoleListByUser(userId) {
      getRoleByUser(userId).then((response) => {
        let allocRoleList = response.data;
        this.allocRoleIds = [];
        if (allocRoleList != null && allocRoleList.length > 0) {
          for (let i = 0; i < allocRoleList.length; i++) {
            this.allocRoleIds.push(allocRoleList[i].id);
          }
        }
      });
    },
    handleUpdate(index, row) {
      this.dialogVisible = true;
      this.isEdit = true;
      this.user = Object.assign({}, row);
    },
    handleDelete(index, row) {
      this.$confirm("是否要删除该用户?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        let ids = [];
        let params = new URLSearchParams();
        if (index === -1) {
          if (this.multipleSelection < 1) {
            this.$message({
              message: "请选择一条记录",
              type: "warning",
              duration: 1000,
            });
            return;
          }
          for (let i = 0; i < this.multipleSelection.length; i++) {
            ids.push(this.multipleSelection[i]);
          }
        } else {
          ids.push(row.id);
        }
        params.append("ids", ids);
        deleteUser(params).then((response) => {
          if (response.code === 200) {
            this.$message({
              type: "success",
              message: "删除成功!",
            });
            this.getList();
          }
        });
      });
    },
    handleDialogConfirm() {
      this.$refs.userRef.validate((valid) => {
        if (!valid) {
          return;
        }
        this.$confirm("是否要确认?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        }).then(() => {
          console.log("this.user", this.user);
          if (this.isEdit) {
            updateUser(this.user.id, this.user).then((response) => {
              if (response.code === 200) {
                this.$message({
                  message: "修改成功！",
                  type: "success",
                });
                this.dialogVisible = false;
                this.getList();
              }
            });
          } else {
            createUser(this.user).then((response) => {
              console.log("response", response);
              if (response.code === 200) {
                this.$message({
                  message: "添加成功！",
                  type: "success",
                });
                this.dialogVisible = false;
                this.getList();
              } else {
                this.$message({
                  message: res.message,
                  type: "success",
                });
              }
            });
          }
        });
      });
    },
    handleSelectionChange(val) {
      console.log(val);
      //复制id到multipleSelection   map  [3,2,5,6,7]
      this.multipleSelection = val.map((x) => {
        return x.id;
      });
      console.log("选择的id：", this.multipleSelection);
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.listQuery.pageSize = val;
      this.getList();
    },

    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.listQuery.pageNum = val; // 获取新页码
      this.getList();
    },

    /// ////////////////////添加功能
    showAddDialog() {
      this.addDialogVisible = true;
    },
    addDialogClosed() {
      this.$refs.addFormRef.resetFields();
    },
    editDialogClosed() {
      this.$refs.editFormRef.resetFields();
    },
  },
};
</script>

<style scoped>
.home {
  width: 1250px;
  margin-left: auto;
  margin-right: auto;
  margin-top: 20px;
}
#header-div {
  padding-bottom: 20px;
  padding-left: 5px;
  background-color: white;
}
#side-menu {
  position: fixed;
  margin-left: 50%;
  left: -680px;
  top: 100px;
}

.operate-container {
  margin-top: 20px;
  margin-bottom: 20px;
}
</style>
