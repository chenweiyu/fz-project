<template>
  <header id="header" class="fixed-top">
    <div class="container d-flex align-items-center">
      <h1 class="logo mr-auto"><a href="index.html">F&C Clothing</a></h1>
      <span>
        <el-input
          placeholder="请输入服装名称"
          v-model="keyword"
          size="small"
        >
          <el-button
            slot="append"
            icon="el-icon-search"
            style="width: 46px"
            size="small"
            @click="searchClothing()"
          ></el-button>
        </el-input>
      </span>
      <nav class="nav-menu d-none d-lg-block">
        <ul>
          <li :class="{ active: shows == 'index' }">
            <a href="#" @click="makeActive('index')">首页</a>
          </li>
          <li :class="{ active: shows == 'goodsCart' }">
            <a href="#" @click="makeActive('goodsCart')"
              ><i class="el-icon-shopping-cart-1"></i> 购物车</a
            >
          </li>
          <li :class="{ active: shows == 'myOrder' }">
            <a href="#" @click="makeActive('myOrder')"
              ><i class="el-icon-s-order"></i> 我的订单</a
            >
          </li>
          <li :class="{ active: shows == 'userDetail' }">
            <a href="#" @click="makeActive('userDetail')"
              ><i class="el-icon-user-solid"></i> 个人信息</a
            >
          </li>
          <li class="drop-down">
            <!-- <img :src="user.userface" style="border-radius: 25px;width:40px;height:40px;"/> -->
            <a href="#"
              ><img
                :src="user.userface"
                style="
                  border-radius: 25px;
                  width: 30px;
                  height: 30px;
                  margin-top: -5px;
                "
                v-if="user.userface != null"
              />
              <img
                src="../assets/img/defaultman.png"
                style="
                  border-radius: 25px;
                  width: 30px;
                  height: 30px;
                  margin-top: -5px;
                "
                v-if="user.userface == null && user.sex == '男'"
              />
              <img
                src="../assets/img/defaultwomen.jpg"
                style="
                  border-radius: 25px;
                  width: 30px;
                  height: 30px;
                  margin-top: -5px;
                "
                v-if="user.userface == null && user.sex == '女'"
              />
              <img
                src="../assets/img/defaultman.png"
                style="
                  border-radius: 25px;
                  width: 30px;
                  height: 30px;
                  margin-top: -5px;
                "
                v-if="user.userface == null && user.sex == ''"
              />
              欢迎:
              {{ user.username }}</a
            >
            <ul>
              <li>
                <a href="javascript: void(0);" @click="register()">注 册</a>
              </li>
              <li>
                <a href="javascript: void(0);" @click="logout()">退 出</a>
              </li>
            </ul>
          </li>
        </ul>
      </nav>
    </div>
  </header>
</template>

<script>
import { logout } from "@/api/user";
export default {
  data() {
    return {
      shows: "index",
      user: {},
      keyword: ""
    };
  },

  name: "Header",
  components: {
    "remote-js": {
      render(createElement) {
        return createElement("script", {
          attrs: {
            type: "text/JavaScript",
            src: "../../assets/js/main.js",
          },
        });
      },
    },
    "remote-js": {
      render(createElement) {
        return createElement("script", {
          attrs: {
            type: "text/JavaScript",
            src: "../../assets/vendor/jquery/jquery.min.js",
          },
        });
      },
    },
    "remote-js": {
      render(createElement) {
        return createElement("script", {
          attrs: {
            type: "text/JavaScript",
            src: "../../assets/vendor/bootstrap/js/bootstrap.bundle.min.js",
          },
        });
      },
    },
  },

  created() {
    this.user = this.$store.state.user.user;
  },

  methods: {
    searchClothing() {
      this.$emit('updateKeyword', this.keyword);
    },

    register() {
      this.$router.push({ path: "/register" });
    },

    logout() {
      logout().then((res) => {
        if (res.code === 200) {
          this.$router.push({ path: "/login" });
          this.$message({
            message: "登出成功！",
            type: "success",
          });
        }
      });
    },

    makeActive: function (item) {
      this.$router.push("/" + item);
      this.shows = item;
    },
  },
};
</script>

<style>
@import url(https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i);
@import "../assets/vendor/icofont/icofont.min.css";
@import "../assets/vendor/boxicons/css/boxicons.min.css";
@import "../assets/vendor/owl.carousel/assets/owl.carousel.min.css";
@import "../assets/vendor/venobox/venobox.css";
@import "../assets/css/style";
</style>
