<template>
  <body id="poster">
    <el-form
      class="register-container"
      label-position="center"
      label-width="80px"
      :model="registerFrom"
      ref="registerFrom"
      :rules="registerRules"
    >
      <h2 class="register_title">用户注册</h2>
      <el-form-item label="账号" style="margin: 12px 0" prop="username">
        <el-input
          v-model="registerFrom.username"
          size="small"
          placeholder="请输入账号"
          @keyup.enter.native="register"
        ></el-input>
      </el-form-item>
      <el-form-item label="姓名" style="margin: 12px 0">
        <el-input
          v-model="registerFrom.nickname"
          size="small"
          placeholder="请输入姓名"
          @keyup.enter.native="register"
        ></el-input>
      </el-form-item>
      <el-form-item label="密码" style="margin: 12px 0" prop="password">
        <el-input
          v-model="registerFrom.password"
          size="small"
          placeholder="请输入密码"
          type="password"
          @keyup.enter.native="register"
        ></el-input>
      </el-form-item>
      <el-form-item label="确认密码" style="margin: 12px 0" prop="checkPass">
        <el-input
          v-model="registerFrom.checkPass"
          size="small"
          placeholder="请重新输入密码"
          type="password"
          @keyup.enter.native="register"
        ></el-input>
      </el-form-item>
      <el-form-item label="性别" style="margin: 12x 0" placeholder="请选择性别">
        <el-select
          v-model="registerFrom.sex"
          placeholder="请选择性别"
          size="small"
        >
          <el-option label="男" value="男"></el-option>
          <el-option label="女" value="女"></el-option>
          <el-option label="其他" value="其他"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="电话" style="margin: 12px 0">
        <el-input
          v-model="registerFrom.phone"
          size="small"
          placeholder="请输入电话"
          @keyup.enter.native="register"
        ></el-input>
      </el-form-item>
      <el-form-item label="邮箱" style="margin: 12px 0 20px 0">
        <el-input
          v-model="registerFrom.email"
          size="small"
          placeholder="请输入邮箱"
          type="email"
          @keyup.enter.native="register"
        ></el-input>
      </el-form-item>
      <el-form-item style="width: 100%">
        <el-button
          type="primary"
          style="width: 40%; border: none; margin-left: -5%"
          @click="cancel()"
          >取 消</el-button
        >
        <el-button
          type="primary"
          style="width: 40%; background: #505458; border: none"
          @click="register()"
          >注 册</el-button
        >
      </el-form-item>
    </el-form>
  </body>
</template>

<script>
import { isvalidUsername } from "@/utils/validate";
import { mapActions } from "vuex";
// import { setSupport, getSupport, setCookie, getCookie } from "@/utils/support";
import { createUser } from "@/api/user";
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
      registerFrom: {
        username: null,
        nickname: null,
        password: null,
        checkPass: null,
        enabled: 0,
        phone: null,
        email: null,
        sex: null,
        state: 1,
      },
      registerRules: {
        username: [{ required: true, message: "请输入账号", trigger: "blur" }],
        password: [
          { required: true, message: "请输入密码", trigger: "blur" },
          {
            min: 3,
            message: "长度不少与3个字符",
            trigger: "blur",
          },
        ],
        checkPass: [
          { required: true, message: "请输入确认密码", trigger: "blur" },
          {
            min: 3,
            message: "长度不少与3个字符",
            trigger: "blur",
          },
        ],
      },
      loading: false,
      cartQueryInfo: {},
    };
  },
  created() {},
  methods: {
    ...mapActions(["getClothingCart", "getUserReceiverList"]),

    register() {
      // 对需要的字段进行验证
      this.$refs.registerFrom.validate((valid) => {
        if (!valid) {
          return;
        }
        if (this.registerFrom.password !== this.registerFrom.checkPass) {
          this.$message({
            message: "密码和确认密码不一致！",
            type: "info",
          });
          return;
        }
        this.registerFrom.username = this.registerFrom.username.trim();
        // 封装好的createUser方法发送axios请求
        createUser(this.registerFrom).then((res) => {
          if (res.code === 200) {
            this.$router.push({
              path: "/login",
            });
            this.$message({
              message: "注册成功！",
              type: "success",
            });
          }
        });
      });
    },
    cancel() {
      this.$router.push({
        path: "/login",
      });
    },

    getInitClothingCart() {
      this.cartQueryInfo.userId = this.$store.state.user.user.userId;
      this.cartQueryInfo.pagenum = 1;
      this.cartQueryInfo.pagesize = 10;
      this.getClothingCart(this.cartQueryInfo);
    },

    getInitUserReceiverList() {
      this.getUserReceiverList(this.$store.state.user.user.userId);
    },
  },
};
</script>
<style>
.register-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 50px auto;
  width: 400px;
  padding: 20px 35px 15px 20px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
.register_title {
  margin: 0px auto 20px auto;
  text-align: center;
  color: #505458;
}
#poster {
  background: url("../../assets/img/login.png") no-repeat;
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
