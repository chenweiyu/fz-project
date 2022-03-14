<!-- 模板，div ，el ui元素布局-->
<template>
  <!-- 一个根DIV -->
  <div>
    <!-- 2.卡片视图 -->
    <el-card>
      <!-- 1.导航条 -->
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>角色管理</el-breadcrumb-item>
        <el-breadcrumb-item>角色列表</el-breadcrumb-item>
      </el-breadcrumb>

      <br />
      <!-- 2.1 顶部操作  el-row/el-col-->
      <el-row :gutter="20">
        <el-col :span="8">
          <!-- 使用clearable属性即可得到一个可清空的输入框   clear	在点击由 clearable 属性生成的清空按钮时触发-->
          <el-input
            placeholder="请输入角色名称"
            v-model="queryInfo.query"
            class="input-with-select"
            clearable
            @clear="getList"
          >
            <template #append>
              <el-button icon="el-icon-search" @click="getList"></el-button>
            </template>
          </el-input>
        </el-col>
        <el-col :span="5">
          <el-button
            type="primary"
            @click="showAddDialog"
            icon="el-icon-edit"
            plain
            >添加</el-button
          >
          <el-button
            type="danger"
            @click="removeById(multipleSelection)"
            icon="el-icon-delete"
            plain
            >批量删除</el-button
          >
        </el-col>
      </el-row>
      <br />

      <!-- 2.2 列表区域 -->
      <el-table
        :data="list"
        border
        stripe
        @selection-change="handleSelectionChange"
      >
        <el-table-column type="selection" width="60"></el-table-column>
        <el-table-column type="index" label="序号" width="60"></el-table-column>
        <el-table-column label="角色名" prop="roleName"></el-table-column>

        <el-table-column label="权限码" prop="rolePerms"></el-table-column>

        <el-table-column label="备注" prop="remark"></el-table-column>
        <!-- 自定义列 -->
        <el-table-column label="操作" width="270px">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="primary"
              icon="el-icon-edit"
              @click="showEditDialog(scope.row.id)"
              >编辑
            </el-button>

            <el-button
              size="mini"
              type="primary"
              icon="el-icon-delete"
              @click="showAuthDialog(scope.row.id)"
              >授权
            </el-button>

            <el-button
              size="mini"
              type="primary"
              icon="el-icon-delete"
              @click="showDisDialog(scope.row.id)"
              >分配
            </el-button>
          </template>
        </el-table-column>
      </el-table>

      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="queryInfo.pagenum"
        :page-size="queryInfo.pagesize"
        :page-sizes="[5, 10, 20, 40]"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
      >
      </el-pagination>
    </el-card>

    <!-- 3.弹框区域 -->

    <!-- 添加框 -->
    <el-dialog
      title="添加"
      :visible.sync="addDialogVisible"
      width="50%"
      @close="addDialogClosed"
    >
      <el-form
        :model="addForm"
        ref="addFormRef"
        :rules="addFormRules"
        label-width="100px"
      >
        <el-form-item label="角色名" prop="roleName">
          <el-input v-model="addForm.roleName"></el-input>
        </el-form-item>
        <!-- <el-form-item label="权限码" prop="rolePerms">
          <el-input v-model="addForm.rolePerms"></el-input>
        </el-form-item> -->
        <el-form-item label="备注" prop="remark">
          <el-input v-model="addForm.remark"></el-input>
        </el-form-item>
      </el-form>
      <!-- 底部 -->
      <span slot="footer" class="dialog-footer">
        <el-button @click="addDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="add">确 定</el-button>
      </span>
    </el-dialog>

    <!-- 编辑框 -->
    <el-dialog
      title="编辑角色"
      :visible.sync="editDialogVisible"
      width="50%"
      @close="editDialogClosed"
    >
      <el-form
        :model="editForm"
        ref="editFormRef"
        :rules="editFormRules"
        label-width="100px"
      >
        <el-form-item label="角色名" prop="roleName">
          <el-input v-model="editForm.roleName"></el-input>
        </el-form-item>
        <!-- <el-form-item label="权限码" prop="rolePerms">
          <el-input v-model="editForm.rolePerms"></el-input>
        </el-form-item> -->
        <el-form-item label="备注" prop="remark">
          <el-input v-model="editForm.remark"></el-input>
        </el-form-item>
      </el-form>
      <!-- 底部 -->
      <span slot="footer" class="dialog-footer">
        <el-button @click="editDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="update">确 定</el-button>
      </span>
    </el-dialog>

    <!-- 分配框 -->
    <el-dialog title="分配角色" :visible.sync="disDialogVisible" width="50%">
      <!-- 穿梭框， v-model="yesDis" 已选中数组，:data="noDis" 全部数据-->
      <el-transfer
        filterable
        filter-placeholder="请输入搜索信息"
        v-model="yesDis"
        :data="noDis"
        :titles="['未分配给用户', '已分配给用户']"
        style="width: 80%; margin: 0px auto"
      >
      </el-transfer>

      <!-- 底部 -->
      <span slot="footer" class="dialog-footer">
        <el-button @click="disDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="distribute">确 定</el-button>
      </span>
    </el-dialog>

    <!-- 授权框 -->
    <el-dialog title="角色授权" :visible.sync="authDialogVisible" width="50%">
      <vue-json-editor
        v-model="editForm.rolePerms"
        :showBtns="false"
        :mode="'code'"
        lang="zh"
      />

      <!-- 底部 -->
      <span slot="footer" class="dialog-footer">
        <el-button @click="authDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="authorize">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<!-- 行为，业务逻辑 -->
<script>
export default {
  //变量，配合ElementUI使用
  data() {
    return {
      total: 0,
      queryInfo: {
        roleName: "", //查询参数
        auNum: "", //角色ID
        pagenum: 1, // 当前的页数
        pagesize: 10, // 当前每页显示多少条数据
      },
      /// ////////////////////列表 el-table
      list: [],

      multipleSelection: [], //多选  id

      /// ////////////////////添加框  form，验证
      addDialogVisible: false,
      addForm: {
        roleName: "",
        rolePerms: "",
        remark: "",
      },
      addFormRules: {
        roleName: [{ required: true, message: "请输入", trigger: "blur" }],
        // rolePerms: [
        //   { required: true, message: "请输入", trigger: "blur" },
        // ],
      },

      /// ////////////////////修改框  form，验证
      editForm: {
        roleName: "",
        rolePerms: "",
        remark: "",
      },
      editDialogVisible: false,
      editFormRules: {
        roleName: [{ required: true, message: "请输入", trigger: "blur" }],
        // rolePerms: [
        //   { required: true, message: "请输入", trigger: "blur" },
        // ],
      },

      ////////////////////////////分配角色
      disDialogVisible: false,
      //全部
      noDis: [],
      //已选
      yesDis: [],
      rid: "", //角色id

      authDialogVisible: false,
    };
  },
  //页面初始化加载，生命周期函数
  created() {
    this.getList();
  },
  //自定义函数，操作变量
  methods: {
    /// //////////////////// 获取所有角色的列表
    async getList() {
      //query=abc&pagenum=1&pagesize=5
      console.log(this.$qs.stringify(this.queryInfo));
      const { data: res } = await this.$http.post("/role/list");
      console.log(res);
      if (res.code !== 200) {
        return this.$message.error("获取列表失败！");
      }
      this.list = res.data;
    },

    ////////////////////添加
    add() {
      this.$refs.addFormRef.validate(async (valid) => {
        if (!valid) return;
        // 可以发起添加用户的网络请求
        const { data: res } = await this.$http.post("/role/save", this.addForm);

        if (res.code !== 200) {
          return this.$message.error("添加信息失败！");
        }

        this.$message.success("添加信息成功！");
        this.addDialogVisible = false;
        this.getList();
      });
    },

    /// ////////////////////编辑功能
    async showEditDialog(id) {
      console.log(id);
      const { data: res } = await this.$http.get("/role/info/" + id);
      if (res.code !== 200) {
        return this.$message.error("查询信息失败！");
      }
      console.log(res.data);
      this.editForm = res.data; // 对象复制
      this.editDialogVisible = true;
    },

    ////////////////////更新
    update() {
      this.$refs.editFormRef.validate(async (valid) => {
        if (!valid) return;
        //
        const { data: res } = await this.$http.post(
          "/role/update",
          this.editForm
        );
        if (res.code !== 200) {
          return this.$message.error("更新信息失败！");
        }

        // 提示修改成功
        this.$message.success("更新信息成功！");
        // 关闭对话框
        this.editDialogVisible = false;
        // 刷新数据列表
        this.getList();
      });
    },

    /// ////////////////////删除功能   ，实现批量删除
    removeById(ids) {
      console.log("-----", ids);
      if (ids.length == 0) return this.$message.error("请先选择至少一条");

      // 弹框
      this.$confirm("此操作将永久删除数据, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(async () => {
          // 删除逻辑
          const { data: res } = await this.$http.post("/role/delete", ids);

          if (res.code !== 200) {
            return this.$message.error("删除信息失败！");
          }

          this.$message.success("删除信息成功！");

          this.getList();
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },

    async showAuthDialog(id) {
      console.log(id);
      const { data: res } = await this.$http.get("/role/info/" + id);
      if (res.code !== 200) {
        return this.$message.error("查询信息失败！");
      }

      this.editForm = res.data;

      this.authDialogVisible = true;
    },

    async authorize() {
      this.editForm.rolePerms = JSON.stringify(this.editForm.rolePerms);
      console.log(this.editForm);

      const { data: res } = await this.$http.post(
        "/role/update",
        this.editForm
      );
      if (res.code !== 200) {
        return this.$message.error("更新信息失败！");
      }

      // 提示修改成功
      this.$message.success("更新信息成功！");
      // 关闭对话框
      this.authDialogVisible = false;
      // 刷新数据列表
      this.getList();
    },

    /// ////////////////////分配功能
    async showDisDialog(id) {
      const { data: res } = await this.$http.get("/role/transfer/" + id);
      if (res.code !== 200) {
        return this.$message.error("查询信息失败！");
      }

      //已分配
      this.yesDis = res.data.yesdis.map((x) => {
        return x.id;
      });
      //全部[{key,label},{}]
      this.noDis = res.data.all.map((x) => {
        return {
          key: x.id,
          label: x.name,
        };
      });

      this.rid = id; //角色id

      console.log(this.noDis, this.yesDis);

      this.disDialogVisible = true;
    },

    ////////////保存分配
    async distribute() {
      console.log("this.yesDis:", this.yesDis);
      //将角色id加到数组最后
      this.yesDis.push(this.rid);
      console.log("this.yesDis:", this.yesDis);
      const { data: res } = await this.$http.post(
        "/role/savetransfer",
        this.yesDis
      );
      if (res.code !== 200) {
        return this.$message.error("查询信息失败！");
      }

      this.$message.success("分配成功！");

      this.disDialogVisible = false;
    },

    ///////////////////////////////////
    // 多选,组成id数组
    handleSelectionChange(val) {
      console.log(val);
      //复制id到multipleSelection   map  [3,2,5,6,7]
      this.multipleSelection = val.map((x) => {
        return x.id;
      });
      console.log("选择的id：", this.multipleSelection);
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

<!-- css 样式 scoped 本页CSS有效 -->
<style  scoped>
.jsoneditor-poweredBy {
  display: none;
}
.jsoneditor-vue {
  min-height: 400px;
}
</style>
