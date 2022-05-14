<template>
  <section id="portfolio-details" class="portfolio-details">
    <div class="container">
      <el-page-header @back="goBack" content="个人信息"> </el-page-header>
      <div class="row">
        <div class="col-lg-1 user-img-user">
          <img :src="userForm.userface" alt="用户头像" class="userImg" v-if="userForm.userface != null" />
          <img src="../../assets/img/defaultman.png" alt="默认头像" class="userImg" v-if="userForm.userface == null && userForm.sex == '男'" />
          <img src="../../assets/img/defaultwomen.jpg" alt="默认头像" class="userImg" v-if="userForm.userface == null && userForm.sex == '女'" />
          <img src="../../assets/img/defaultman.png" alt="默认头像" class="userImg" v-if="userForm.userface == null && userForm.sex == ''" />
        </div>
        <div class="col-lg-10">
          <p class="username">{{ userForm.username }}</p>
          <a href="#" class="username-edit" @click="usernameEditShow()"
            ><i class="el-icon-edit"></i><span>修改</span></a
          >
        </div>
      </div>
      <el-form ref="form" :model="userForm" label-width="85px">
        <el-form-item label="用户名" v-show="showUsernameEdit">
          <el-col :span="6">
            <el-input v-model="userForm.username"></el-input>
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
              <el-input v-model="userForm.phone"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="5">
            <el-form-item label="性别">
              <el-select v-model="userForm.sex" placeholder="请选择性别">
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
            <el-input v-model="userForm.email"></el-input>
          </el-col>
        </el-form-item>
        <div>
          <span class="base-message">配送地址信息</span>
          <el-divider></el-divider>
        </div>
        <el-row>
          <el-col :span="7" class="address-spacing">
            <el-form-item label="收货人">
              <el-input v-model="receiver.receiverName"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="收货人电话">
              <el-input v-model="receiver.receiverPhone"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="所在区域">
          <v-distpicker
            :province="receiver.receiverProvince"
            :city="receiver.receiverCity"
            :area="receiver.receiverRegion"
            @selected="onSelectRegion"
          ></v-distpicker>
        </el-form-item>
        <el-form-item label="详细地址">
          <el-input
            type="textarea"
            v-model="receiver.receiverDetailAddress"
            placeholder="请输入内容"
            style="width: 60%"
          ></el-input>
        </el-form-item>
      </el-form>
      <a href="#" class="btn-get-started" @click="saveUserDetail">保存信息</a>
    </div>
  </section>
</template>

<script>
import { mapActions } from "vuex";
import VDistpicker from "v-distpicker";
export default {
  name: "GoodCart",
  data() {
    return {
      showUsernameEdit: false,
      sexList: ["男", "女", "其他"],
      goodsSum: 0,
      receiver: {
        receiverName: "",
        receiverPhone: "",
        receiverProvince: "",
        receiverCity: "",
        receiverRegion: "",
        receiverDetailAddress: "",
      },
      userForm: {},
    };
  },
  components: {
    VDistpicker,
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
    this.getUserDetail();
  },

  methods: {
    ...mapActions(["saveUserInfo", "updateReceiverList"]),

    getUserDetail() {
      this.userForm = JSON.parse(localStorage.getItem("userInfo"));
      console.log(this.userForm.userface);
      if (this.$store.state.receiver.receiverList.length != 0) {
        this.receiver = this.$store.state.receiver.receiverList[0];
      }
    },

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

    onSelectRegion(data) {
      this.receiver.receiverProvince = data.province.value;
      this.receiver.receiverCity = data.city.value;
      this.receiver.receiverRegion = data.area.value;
    },

    saveUserDetail() {
      this.showUsernameEdit = false;
      this.saveUserInfo(this.userForm);
      this.updateReceiverList(this.receiver).then(() => {
        this.$message({
          type: "success",
          message: "保存成功",
          duration: 1000,
        });
      });
      this.getUserDetail();
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

.distpicker-address-wrapper .select {
  width: 100px;
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
