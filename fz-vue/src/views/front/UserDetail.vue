<template>
  <section id="portfolio-details" class="portfolio-details">
    <div class="container">
      <el-page-header @back="goBack" content="个人信息"> </el-page-header>
      <div class="row">
        <div class="col-lg-1 user-img-user">
          <img src="../../assets/img/wx-xhm.jpg" alt="" class="userImg" />
        </div>
        <div class="col-lg-10">
          <p class="username">小哈猫<!--{{user.name}}--></p>
          <a href="#" class="username-edit" @click="usernameEditShow()"
            ><i class="el-icon-edit"></i><span>修改</span></a
          >
        </div>
      </div>
      <el-form ref="form" :model="user" label-width="85px">
        <el-form-item label="用户名" v-show="showUsernameEdit">
          <el-col :span="6">
            <el-input v-model="user.name"></el-input>
            <a href="#" class="username-edit" @click="usernameEditHide()"
              >取消</a
            >
          </el-col>
        </el-form-item>
        <div>
          <span class="base-message">基本信息</span>
          <el-divider></el-divider>
        </div>
        <el-row>
          <el-col :span="7">
            <el-form-item label="电话号码">
              <el-input v-model="user.phone"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="5">
            <el-form-item label="性别">
              <el-select v-model="user.sex" placeholder="请选择性别">
                <el-option
                  v-for="(item, index) in sexList"
                  :key="index"
                  :label="item"
                  :value="item"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="邮箱账号">
          <el-col :span="6">
            <el-input v-model="user.mail"></el-input>
          </el-col>
        </el-form-item>
        <div>
          <span class="base-message">配送地址信息</span>
          <el-divider></el-divider>
        </div>
        <el-row>
          <el-col :span="7" class="address-spacing">
            <el-form-item label="收货人">
              <el-input v-model="address.receiver"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="收货人电话">
              <el-input v-model="user.receiverPhone"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="所在地区">
          <el-row>
            <el-col :span="6" class="address-spacing">
              <el-input
                v-model="address.province"
                placeholder="省份"
              ></el-input>
            </el-col>
            <el-col :span="6" class="address-spacing">
              <el-input v-model="address.city" placeholder="城市"></el-input>
            </el-col>
            <el-col :span="6">
              <el-input
                v-model="address.street"
                placeholder="区/县/乡"
              ></el-input>
            </el-col>
          </el-row>
        </el-form-item>
        <el-form-item label="详细地址">
          <el-col :span="11">
            <el-input v-model="address.addrDetail"></el-input>
          </el-col>
        </el-form-item>
      </el-form>
      <a href="#" class="btn-get-started">保存信息</a>
    </div>
  </section>
</template>

<script>
export default {
  name: "GoodCart",
  data() {
    return {
      showUsernameEdit: false,
      sexList: ["男", "女", "其他"],
      orders: [
        {
          goodImg: require("../../assets/img/portfolio/portfolio-1.jpg"),
          goodName: "潮流破洞牛仔裤",
          goodPrice: 88.88,
          goodNum: "x" + "1",
          payment: 88.88,
        },
        {
          goodImg: require("../../assets/img/portfolio/portfolio-2.jpg"),
          goodName: "简约舒适上衣",
          goodPrice: 188.88,
          goodNum: "x" + "1",
          payment: 188.88,
        },
      ],

      goodsSum: 0,

      user: {
        name: "小哈猫",
      },

      address: {},
    };
  },
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
    goBack() {
      window.history.back();
    },

    handleChange(id) {
      this.goodsCart[id].payment =
        this.goodsCart[id].goodPrice * this.goodsCart[id].goodNum;
    },

    usernameEditShow() {
      this.showUsernameEdit = true;
    },

    usernameEditHide() {
      this.showUsernameEdit = false;
    },
  },
};
</script>

<style scoped>
@import url(https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i);
@import "../../assets/vendor/icofont/icofont.min.css";
@import "../../assets/vendor/boxicons/css/boxicons.min.css";
@import "../../assets/vendor/owl.carousel/assets/owl.carousel.min.css";
@import "../../assets/vendor/venobox/venobox.css";
@import "../../assets/css/style";

.portfolio-details .container {
  margin-top: 60px;
}

.user-img-user {
  margin-top: 30px;
  margin-left: 20px;
  height: 130px;
}

.userImg {
  border-radius: 50%;
  width: 80px;
  height: 80px;
}

.username {
  font-size: 18px;
  font-weight: 700;
  margin-top: 60px;
  margin-bottom: 5px;
  color: #444444;
}

.username-edit {
  font-size: 12px;
  color: #6c6d6c;
}

.base-message {
  font-size: 16px;
  font-weight: 600;
  color: #6c6d6c;
}

.address-spacing {
  margin-right: 10px;
}

.btn-get-started {
  font-family: "Raleway", sans-serif;
  font-weight: 500;
  font-size: 15px;
  margin-left: 45%;
  letter-spacing: 1px;
  display: inline-block;
  padding: 9px 35px;
  border-radius: 50px;
  transition: 0.5s;
  margin-top: 10px;
  border: 2px solid #ffc107;
  color: #444444;
}

.btn-get-started:hover {
  background: #ffc107;
  color: #ffffff;
}
</style>
