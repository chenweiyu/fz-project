<template>
  <el-container>
    <el-header>
      <el-row style="height: 100%" type="flex" align="middle">
        <el-col :span="12">
          <!-- <img src="../assets/images/logo2.png" /> -->
          <span class="title">F&C Clothing后台管理系统</span>
        </el-col>

        <el-col :span="12" style="text-align: right">
          <!-- <img :src="$store.state.baseURL + user.avatar" style="border-radius: 25px;width:48px;height:48px" /> -->
          <span class="name">欢迎：<!-- {{user.name}} --></span>
          <span class="logout" @click="logout">退出</span>
        </el-col>
      </el-row>
    </el-header>
    <el-container>
      <el-aside width="200px">
        <el-menu
          default-active="/backHome/index"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
          router
          unique-opened
          background-color="#182946"
          text-color="#fff"
          active-text-color="#c4afbb"
        >
          <el-menu-item index="/backHome/index">
            <i class="el-icon-s-home"></i>
            <span slot="title">首页</span>
          </el-menu-item>
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-shopping-bag-2"></i>
              <span slot="title">服装管理</span>
            </template>
            <!-- <el-menu-item index="/welcome">
              <template slot="title">
                <i class="el-icon-menu"></i>
                <span>欢迎页</span>
              </template>
            </el-menu-item> -->

            <el-menu-item index="/backHome/clothingTable">
              <template slot="title">
                <i class="el-icon-shopping-bag-2"></i>
                <span>服装列表</span>
              </template>
            </el-menu-item>
            <el-menu-item index="/backHome/clothingAdd">
              <template slot="title">
                <i class="el-icon-notebook-1"></i>
                <span>添加服装</span>
              </template>
            </el-menu-item>
            <el-menu-item index="/backHome/clothingCategory">
              <template slot="title">
                <i class="el-icon-notebook-1"></i>
                <span>服装类别管理</span>
              </template>
            </el-menu-item>
            <el-menu-item index="/backHome/brand">
              <template slot="title">
                <i class="el-icon-discount"></i>
                <span>品牌管理</span>
              </template>
            </el-menu-item>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-s-order"></i>
              <span slot="title">订单管理</span>
            </template>
            <el-menu-item index="/backHome/orderTable">
              <template slot="title">
                <i class="el-icon-s-order"></i>
                <span>订单列表</span>
              </template>
            </el-menu-item>
            <el-menu-item index="/backHome/orderReturn">
              <template slot="title">
                <i class="el-icon-caret-left"></i>
                <span>退货申请处理</span>
              </template>
            </el-menu-item>
            <el-menu-item index="/backHome/reasonSetting">
              <template slot="title">
                <i class="el-icon-s-tools"></i>
                <span>退货原因设置</span>
              </template>
            </el-menu-item>
          </el-submenu>

          <el-submenu index="3">
            <template slot="title">
              <i class="el-icon-s-tools"></i>
              <span slot="title">系统菜单</span>
            </template>

            <el-menu-item index="/user">
              <template slot="title">
                <i class="el-icon-user-solid"></i>
                <span>用户管理</span>
              </template>
            </el-menu-item>

            <el-menu-item index="/role">
              <template slot="title">
                <i class="el-icon-s-check"></i>
                <span>角色管理</span>
              </template>
            </el-menu-item>

            <!-- <el-menu-item index="/dict">
              <template slot="title">
                <i class="el-icon-menu"></i>
                <span>字典管理</span>
              </template>
            </el-menu-item> -->
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  data() {
    return {
      // 左侧菜单数据
      menuList: [],

      user: {},
    };
  },

  // 生命周期函数
  created() {
    this.getCurrentUser();
  },
  methods: {
    async getCurrentUser() {
      // const { data: res } = await this.$http.post("/user/getCurrentUser");
      // if (res.code !== 200)
      //   return this.$message.error("获取失败,原因：" + res.msg);
      // console.log(res.data);
      // this.user = res.data;
      // this.$store.commit("setUser", res.data);
      // console.log("setuser", this.$store.state.user);
    },

    getMenusList() {},

    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    logout() {
      window.sessionStorage.clear(); // 清空
      this.$router.push("/login"); //跳转
    },
  },
};
</script>

<style>
.el-container {
  height: 100%;
}

.el-header {
  background-color: #1c2431;
  width: 100%;
  color: #fff;
  position: fixed;
  left: 0;
  top: 0;
  bottom: 0;
  z-index: 10;
}

.el-header .title {
  font-size: 20px;
  font-weight: bold;
  padding-left: 15px;
}
.el-header img {
  font-size: 0;
  vertical-align: middle;
}
.el-header .logout,
.el-header .name {
  vertical-align: middle;
  font-size: 15px;
  padding-left: 15px;
}

.el-aside {
  background-color: #182946;
  position: fixed;
  left: 0;
  top: 60px;
  bottom: 0;
  overflow: hidden;
}

.el-aside .el-menu {
  border-right: none;
}
.el-main {
  background-color: #eaedf1;
  margin-top: 60px;
  margin-left: 200px;
  z-index: 1;
}
</style>
