<template>
  <header id="header" class="fixed-top">
      <div class="container d-flex align-items-center">
        <h1 class="logo mr-auto"><a href="index.html">F&C Clothing</a></h1>
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
              <!-- <img :src="$store.state.baseURL + user.avatar" style="border-radius: 25px;width:48px;height:48px" /> -->
              <a href="#"
                >欢迎:
                <!--{{user.name}}--></a
              >
              <ul>
                <li><a href="#">注 册</a></li>
                <li><a href="#">退 出</a></li>
              </ul>
            </li>
          </ul>
        </nav>
      </div>
    </header>
</template>

<script>
export default {
  data() {
    return {
      shows: "index",
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

  methods: {
    makeActive: function (item) {
      this.$router.push('/' + item);
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
