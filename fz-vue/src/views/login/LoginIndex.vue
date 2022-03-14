<template>
  <body id="poster">
    <el-form
      class="login-container"
      label-position="left"
      label-width="0px"
      :model="loginForm"
      ref="loginForm"
      :rules="loginRules"
    >
      <h2 class="login_title">网上服装购物</h2>
      <el-form-item>
        <el-input
          type="text"
          v-model="loginForm.username"
          auto-complete="off"
          placeholder="账号"
          style="border-bottom-left-radius: 0px; border-top-left-radius: 0px"
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-input
          type="password"
          v-model="loginForm.password"
          auto-complete="off"
          placeholder="密码"
        ></el-input>
      </el-form-item>
      <el-form-item style="width: 100%">
        <el-button
          type="primary"
          style="width: 100%; background: #505458; border: none"
          @click="login"
          >登录</el-button
        >
      </el-form-item>
    </el-form>
  </body>
</template>

<script>
import { isvalidUsername } from "@/utils/validate";
import { setSupport, getSupport, setCookie, getCookie } from "@/utils/support";
import {login} from "@/api/login";
export default {
  name: "LoginIndex",
  data() {
    const validateUsername = (rule, value, callback) => {
      if (!isvalidUsername(value)) {
        callback(new Error("请输入正确的用户名"));
      } else {
        callback();
      }
    };
    const validatePass = (rule, value, callback) => {
      if (value.length < 3) {
        callback(new Error("密码不能小于3位"));
      } else {
        callback();
      }
    };
    return {
      loginForm: {
        username: "linghu",
        password: "123",
      },
      // responseResult: [],
      loginRules: {
        username: [
          { required: true, trigger: "blur", validator: validateUsername },
        ],
        password: [
          { required: true, trigger: "blur", validator: validatePass },
        ],
      },
      loading: false,
      // pwdType: "password",
      // login_center_bg,
      // dialogVisible: false,
      // supportDialogVisible: false,
    };
  },
  created() {},
  methods: {
    login() {
      this.$refs.loginForm.validate((valid) => {
        if (valid) {
          // let isSupport = getSupport();
          // if(isSupport===undefined||isSupport==null){
          //   this.dialogVisible =true;
          //   return;
          // }
          this.$store.dispatch('Login', this.loginForm).then(() => {
            // setCookie("username", this.loginForm.username, 15);
            // setCookie("password", this.loginForm.password, 15);
            // this.$router.push({ path: "/index" });
            // console.log("auth", this.$store.state.user.auth);
            var myAuth = this.$store.state.user.auth;
            if (myAuth[0].authority == "ROLE_普通用户") {
              this.$router.push({ path: "/index" });
            } else if (myAuth[0].authority == "ROLE_超级管理员") {
              this.$router.push({ path: "/backHome" });
            } else {
              this.$router.push({ path: "/" });
            }
          });
        } else {
          console.log("参数验证不合法！");
          return false;
        }
      });
    },
  },
};
</script>
<style>
.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
.login_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}
#poster {
  background: url("../../assets/img/login.jpg") no-repeat;
  background-position: center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}
body {
  margin: 0px;
}
</style>
