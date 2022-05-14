<template>
  <div>
    <main id="main" style="margin-top: 40px">
      <section id="team" class="team section-bg">
        <div class="container">
          <h5 style="margin-bottom: 20px" v-if="simpleGoods.length != 0">
            以下是“<span>{{ listQuery.keyword }}</span
            >”的搜索结果
          </h5>
          <h3
            v-else
            style="
              height: 200px;
              width: 100%;
              line-height: 200px;
              font-weight: bold;
              margin-left: 35%;
            "
          >
            抱歉！您搜索的服装不存在...
          </h3>

          <div class="row">
            <div
              class="col-lg-3 col-md-6 d-flex align-items-stretch"
              v-for="simpleGood in simpleGoods"
              :key="simpleGood.id"
            >
              <div class="member">
                <div class="member-img simpleImg-size">
                  <img :src="simpleGood.pic" class="img-fluid" alt="" />
                  <div class="social">
                    <a href="#"><i class="el-icon-share"></i></a>
                    <a
                      href="javascript: void(0);"
                      @click="handleGoodsInfo(simpleGood.id)"
                      ><i class="el-icon-s-goods"></i
                    ></a>
                    <a
                      href="javascript: void(0);"
                      @click="submitCartDialogVisible(simpleGood.id)"
                      ><i class="el-icon-shopping-cart-2"></i
                    ></a>
                  </div>
                </div>
                <div class="member-info row">
                  <h5
                    style="
                      height: 20px;
                      width: 100%;
                      overflow: hidden;
                      margin-left: 15px;
                    "
                  >
                    {{ simpleGood.name }}
                  </h5>
                  <div class="col-lg-8 col-md-8 col-12">
                    <span style="margin-top: 15px"
                      >￥{{ simpleGood.price }}元</span
                    >
                  </div>
                  <div class="col-lg-4 col-md-4 col-12">
                    <button
                      class="simple-button"
                      @click="buyDialogVisible(simpleGood.id)"
                    >
                      购买
                    </button>
                  </div>
                  <el-tag
                    type="warning"
                    size="mini"
                    style="margin-left: 15px; margin-top: -5px"
                    >{{ simpleGood.brandName }}</el-tag
                  >
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>

      <footer id="footer">
        <div class="container d-md-flex py-4">
          <div class="mr-md-auto text-center text-md-left">
            <div class="copyright">
              Copyright &copy; 2021.School name Sun Yat Sen college, University
              of Electronic Science and technology
            </div>
            <div class="credits"></div>
          </div>
          <div class="social-links text-center text-md-right pt-3 pt-md-0">
            <el-button type="info" icon="el-icon-share" circle></el-button>
            <el-button type="info" icon="el-icon-s-goods" circle></el-button>
            <el-button type="info" icon="el-icon-s-custom" circle></el-button>
            <el-button
              type="info"
              icon="el-icon-shopping-cart-full"
              circle
            ></el-button>
            <el-button type="info" icon="el-icon-message" circle></el-button>
          </div>
        </div>
      </footer>

      <!-- 加入购物车模态框 -->
      <el-dialog
        title="确认加入购物车"
        :visible.sync="addCartDialogVisible"
        width="30%"
      >
        <hr class="line" />
        <div class="row">
          <div class="col-lg-3">
            <img class="buy-img" :src="clothing.pic" alt="服装图片" />
          </div>
          <div class="col-lg-9">
            <span class="buy-clothingname">{{ clothing.name }}</span>
            <span class="buy-clothingPrice">￥{{ clothing.price }}</span>
            <div class="buy-clothingSize">
              <el-tag type="success" size="small"
                >品牌：{{ clothing.brandName }}</el-tag
              >
            </div>
          </div>
        </div>
        <el-divider content-position="left">商品详情</el-divider>
        <div class="other-mess">
          <span class="other-mess-1">配送服务</span>
          <span v-for="(item, index) in serviceId" :key="index"
            ><span
              >{{ ServiceList[item - 1] }}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span
            ></span
          >
        </div>
        <div class="clothing-size">
          <div v-for="(clothingAttr, idx) in selectClothingAttr" :key="idx">
            <span class="clothing-size-1"> {{ clothingAttr.name }}： </span>
            <el-radio-group
              v-if="clothingAttr.handAddStatus === 0"
              v-model="selectClothingAttr[idx].values"
              class="radio-1"
            >
              <el-radio
                v-for="item in clothingAttr.options"
                :label="item"
                :key="item"
              ></el-radio>
            </el-radio-group>
            <el-radio-group
              v-else
              v-model="selectClothingAttr[idx].values"
              class="radio-1"
            >
              <el-radio
                v-for="item in clothingAttr.options"
                :label="item"
                :key="item"
              ></el-radio>
            </el-radio-group>
          </div>
        </div>
        <div style="margin-left: 5px">
          <span class="other-mess-2">数&nbsp;&nbsp;量</span
          >共&nbsp;<el-input-number
            v-model="cartClothingNum"
            size="mini"
            @change="handleChange(0)"
            :min="1"
            :max="10"
            label="购物服装数量"
          ></el-input-number
          >&nbsp;件
        </div>
        <span class="sumPrice">合计：</span>￥<span class="sumPrice-1">{{
          cartClothingSum
        }}</span>
        <span slot="footer" class="dialog-footer">
          <el-button @click="addCartDialogVisible = false">取 消</el-button>
          <el-button type="warning" @click="addCart">确定</el-button>
        </span>
      </el-dialog>

      <!-- 提交订单模态框 -->
      <el-dialog
        title="确认订单"
        :visible.sync="submitOrderDialogVisible"
        width="30%"
      >
        <hr class="line" />
        <div class="row">
          <div class="col-lg-3">
            <img class="buy-img" :src="clothing.pic" alt="" />
          </div>
          <div class="col-lg-9">
            <span class="buy-clothingname">{{ clothing.name }}</span>
            <span class="buy-clothingPrice">￥{{ clothing.price }}</span>
            <div class="buy-clothingSize" v-if="selectClothingAttr.length">
              颜色：{{
                selectClothingAttr[0].values
              }}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;尺码：{{
                selectClothingAttr[1].values
              }}码
            </div>
          </div>
        </div>
        <div class="row receive-location">
          <div class="col-lg-1">
            <i class="el-icon-map-location icon-locate"></i>
          </div>
          <div class="col-lg-10">
            <span class="location-span">{{ receiverAddress }}</span>
            <div>
              <span class="username-span"
                >{{ receiver.receiverName }}&nbsp;&nbsp;{{
                  receiver.receiverPhone
                }}</span
              >
            </div>
          </div>
          <div class="col-lg-1 icon-css">
            <a href="#" @click="alterAddr()"
              ><i class="el-icon-arrow-right"></i
            ></a>
          </div>
        </div>
        <div class="other-mess">
          <span class="other-mess-1">配送服务</span>快递&nbsp;免邮
        </div>
        <div class="other-mess">
          <span class="other-mess-1">配送方式</span>{{ deliveryCompany }}
        </div>
        <div class="clothing-size">
          <div v-for="(clothingAttr, idx) in selectClothingAttr" :key="idx">
            <span class="clothing-size-1"> {{ clothingAttr.name }}： </span>
            <el-radio-group
              v-if="clothingAttr.handAddStatus === 0"
              v-model="selectClothingAttr[idx].values"
              class="radio-1"
            >
              <el-radio
                v-for="item in clothingAttr.options"
                :label="item"
                :key="item"
              ></el-radio>
            </el-radio-group>
            <el-radio-group
              v-else
              v-model="selectClothingAttr[idx].values"
              class="radio-1"
            >
              <el-radio
                v-for="item in clothingAttr.options"
                :label="item"
                :key="item"
              ></el-radio>
            </el-radio-group>
          </div>
        </div>
        <div style="margin-left: 5px">
          <span class="other-mess-2">数量</span>共&nbsp;<el-input-number
            v-model="orderClothingNum"
            size="mini"
            @change="handleChange(1)"
            :min="1"
            :max="10"
            label="描述文字"
          ></el-input-number
          >&nbsp;件
        </div>
        <div class="order-remark">
          <div>订单备注</div>
          <br />
          <div>
            <el-input type="textarea" v-model="orderRemark"></el-input>
          </div>
        </div>
        <span class="sumPrice">合计：</span>￥<span class="sumPrice-1">{{
          orderClothingSum
        }}</span>
        <span slot="footer" class="dialog-footer">
          <el-button @click="submitOrderDialogVisible = false">取 消</el-button>
          <el-button type="warning" @click="submitOrder">提交订单</el-button>
        </span>

        <el-dialog
          width="50%"
          title="收货人信息"
          :visible.sync="innerAlterAddrVisible"
          append-to-body
        >
          <el-form ref="form" :model="alterAddrForm" label-width="90px">
            <el-row>
              <el-col :span="10">
                <el-form-item label="收货人">
                  <el-input v-model="alterAddrForm.receiver"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="10">
                <el-form-item label="收货人电话">
                  <el-input v-model="alterAddrForm.receiverPhone"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-form-item label="所在区域">
              <v-distpicker
                :province="alterAddrForm.receiverAddrProvince"
                :city="alterAddrForm.receiverAddrCity"
                :area="alterAddrForm.receiverAddrStreet"
                @selected="onSelectRegion"
              ></v-distpicker>
            </el-form-item>
            <el-form-item label="详细地址">
              <el-input
                type="textarea"
                v-model="alterAddrForm.receiverAddrDetail"
              ></el-input>
            </el-form-item>
          </el-form>

          <span slot="footer" class="dialog-footer">
            <el-button @click="innerAlterAddrVisible = false">取 消</el-button>
            <el-button type="warning" @click="accurateAddr">确定</el-button>
          </span>
        </el-dialog>
      </el-dialog>

      <!-- 支付模态框 -->
      <el-dialog title="支付界面" :visible.sync="paydialogVisible" width="30%">
        <span>应付金额：</span
        ><span style="font-size: 18px; font-weight: bold; color: #293a29"
          >￥&nbsp;{{ orderClothingSum }}元</span
        >
        <br />
        <br />
        <span>支付方式：</span
        ><el-radio-group v-model="payType">
          <el-radio label="1"
            ><img
              src="../../assets/img/zhifubao.png"
              alt="支付宝支付"
              style="width: 40px; height: 40px"
            />支付宝</el-radio
          >
          <el-radio label="2"
            ><img
              src="../../assets/img/weixinzhifu.png"
              alt="微信支付"
              style="width: 40px; height: 40px"
            />微信支付</el-radio
          >
        </el-radio-group>
        <div>
          <img
            src="../../assets/img/zhifubaoerweima.png"
            alt="支付宝二维码"
            v-show="payType == 1"
            style="width: 150px; height: 150px; margin: 20px 30%"
          />
          <img
            src="../../assets/img/weixinerweima.png"
            alt="微信二维码"
            v-show="payType == 2"
            style="width: 150px; height: 150px; margin: 20px 30%"
          />
        </div>
        <span slot="footer" class="dialog-footer">
          <el-button @click="paydialogVisible = false">取 消</el-button>
          <el-button type="warning" @click="paydialog">确 定 支 付</el-button>
        </span>
      </el-dialog>
    </main>
  </div>
</template>

<script>
import { mapActions } from "vuex";
import { fetchList, getClothing } from "@/api/clothing";
import { fetchList as fetchClothingAttrList } from "@/api/clothingAttr";
import { createOrder, updatepayInfo } from "@/api/order";
import VDistpicker from "v-distpicker";
export default {
  name: "Index",
  props: ["keyword"],
  data() {
    return {
      addCartDialogVisible: false,
      clothing: {},
      cartClothingSum: 0,
      cartClothingNum: 1,
      serviceId: [],
      ServiceList: ["无忧退货", "快速退款", "免费包邮"],
      selectClothingAttr: [],
      cartQuery: {},

      order: {},
      submitOrderDialogVisible: false,
      innerAlterAddrVisible: false,
      orderClothingNum: 1,
      orderClothingSum: 0,
      receiver: {},
      receiverAddress: "",
      orderRemark: "",
      alterAddrForm: {
        receiver: "",
        receiverPhone: "",
        receiverAddrProvince: "",
        receiverAddrCity: "",
        receiverAddrStreet: "",
        receiverAddrDetail: "",
      },
      deliveryCompany: "顺丰快递  |  圆通快递  |  中通快递  |  韵达快递",

      listKeyword: "",

      paydialogVisible: false,
      payType: 0,
      simpleGoods: [],
      listQuery: {
        keyword: "",
        pageNum: 1,
        pageSize: 20,
      },
      listSimpleQuery: {
        keyword: null,
        pageNum: 1,
        pageSize: 4,
      },
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
  watch: {
    keyword: function (val) {
      this.listQuery.keyword = val.trim();
      this.getSimpleGoodsList();
    },
  },
  created() {
    console.log(this.listQuery.keyword);
    if (this.listQuery.keyword == "") {
      this.listQuery.keyword = this.$route.params.keyword.trim();
      this.getSimpleGoodsList();
    }
  },

  methods: {
    ...mapActions(["create", "getClothingCart"]),
    getSimpleGoodsList() {
      fetchList(this.listQuery).then((response) => {
        this.simpleGoods = response.data.list;
      });
    },

    handleGoodsInfo(id) {
      this.$router.push({
        path: "/goodsDetail",
        query: { id: id },
      });
    },

    handleChange(index) {
      if (index === 0) {
        this.cartClothingSum = this.cartClothingNum * this.clothing.price;
        this.cartClothingSum = this.cartClothingSum.toFixed(1);
      } else {
        this.orderClothingSum = this.orderClothingNum * this.clothing.price;
        this.orderClothingSum = this.orderClothingSum.toFixed(1);
      }
    },

    getGoodsInfo(clothingId) {
      getClothing(clothingId).then((response) => {
        if (response.code === 200) {
          this.clothing = response.data;
          console.log("this.clothing", this.clothing);
          this.getClothingAttrList(
            0,
            this.clothing.clothingAttributeCategoryId
          );
          this.serviceId = this.getServiceList();
          this.handleChange(0);
          this.handleChange(1);
        }
      });
    },
    getClothingAttrList(type, cid) {
      let param = { pageNum: 1, pageSize: 100, type: type };
      fetchClothingAttrList(cid, param).then((response) => {
        if (response.code === 200) {
          let list = response.data.list;
          this.selectClothingAttr = [];
          for (let i = 0; i < list.length; i++) {
            let options = [];
            if (list[i].handAddStatus === 1 || list[i].handAddStatus === 0) {
              //编辑状态下获取手动添加编辑属性
              options = this.getEditAttrOptions(list[i].id);
            }
            //编辑状态下获取选中属性
            this.selectClothingAttr.push({
              id: list[i].id,
              name: list[i].name,
              handAddStatus: list[i].handAddStatus,
              inputList: list[i].inputList,
              options: options,
              values: "",
            });
          }
        }
      });
    },
    getEditAttrOptions(id) {
      let options = [];
      for (
        let i = 0;
        i < this.clothing.clothingAttributeValueList.length;
        i++
      ) {
        let attrValue = this.clothing.clothingAttributeValueList[i];
        if (attrValue.clothingAttributeId === id) {
          if (attrValue.value == "") {
            break;
          }
          let strArr = attrValue.value.split(",");
          for (let j = 0; j < strArr.length; j++) {
            options.push(strArr[j]);
          }
          break;
        }
      }
      return options;
    },
    getServiceList() {
      let list = [];
      if (
        this.clothing.serviceIds === undefined ||
        this.clothing.serviceIds == null ||
        this.clothing.serviceIds === ""
      )
        return list;
      let ids = this.clothing.serviceIds.split(",");
      for (let i = 0; i < ids.length; i++) {
        list.push(Number(ids[i]));
      }
      return list;
    },

    submitCartDialogVisible(id) {
      this.getGoodsInfo(id);
      // this.addCartClothingColor = this.selectClothingAttr[0].values;
      // this.addCartClothingSize = this.selectClothingAttr[1].values;
      this.addCartDialogVisible = true;
    },

    addCart() {
      let cart = JSON.parse(
        JSON.stringify(this.$store.state.cart.clothingCart)
      );
      let cartList = cart.list;
      let cartListLen = cartList.length;
      for (let i = 0; i < cartListLen; i++) {
        if (
          cartList[i].clothingCartList.clothingId == this.clothing.id &&
          cartList[i].clothingCartList.userId ==
            this.$store.state.user.user.userId
        ) {
          this.$message({
            type: "success",
            message: "该商品已在你的购物车里",
            duration: 1500,
          });
          return;
        }
      }
      this.cartQuery.clothingId = this.clothing.id;
      this.cartQuery.userId = this.$store.state.user.user.userId;
      this.cartQuery.clothingNum = this.cartClothingNum;
      this.cartQuery.clothingColor = this.selectClothingAttr[0].values;
      this.cartQuery.clothingSize = this.selectClothingAttr[1].values;
      this.create(this.cartQuery).then(
        (response) => {
          if (response.code === 200) {
            this.$message({
              type: "success",
              message: "成功添加至购物车",
              duration: 1500,
            });
            let queryInfo = {};
            queryInfo.userId = this.$store.state.user.user.userId;
            queryInfo.pagenum = 1;
            queryInfo.pagesize = 1000;
            this.getClothingCart(queryInfo);
            this.addCartDialogVisible = false;
          }
        },
        () => {
          this.$message({
            type: "error",
            message: "该商品添加购物车失败",
            duration: 1500,
          });
        }
      );
    },

    onSelectRegion(data) {
      this.alterAddrForm.receiverAddrProvince = data.province.value;
      this.alterAddrForm.receiverAddrCity = data.city.value;
      this.alterAddrForm.receiverAddrStreet = data.area.value;
    },

    buyDialogVisible(id) {
      this.getGoodsInfo(id);
      this.receiver = JSON.parse(
        JSON.stringify(this.$store.state.receiver.receiverList[0])
      );
      this.receiverAddress = this.mergeAddress(
        this.receiver.receiverProvince,
        this.receiver.receiverCity,
        this.receiver.receiverRegion,
        this.receiver.receiverDetailAddress
      );
      this.submitOrderDialogVisible = true;
    },

    mergeAddress(province, city, region, detailAddr) {
      return province + city + region + detailAddr;
    },
    accurateAddr() {
      this.receiverAddress = this.mergeAddress(
        this.alterAddrForm.receiverAddrProvince,
        this.alterAddrForm.receiverAddrCity,
        this.alterAddrForm.receiverAddrStreet,
        this.alterAddrForm.receiverAddrDetail
      );
      this.receiver.receiverProvince = this.alterAddrForm.receiverAddrProvince;
      this.receiver.receiverCity = this.alterAddrForm.receiverAddrCity;
      this.receiver.receiverRegion = this.alterAddrForm.receiverAddrStreet;
      this.receiver.receiverDetailAddress =
        this.alterAddrForm.receiverAddrDetail;
      this.receiver.receiverName = this.alterAddrForm.receiver;
      this.receiver.receiverPhone = this.alterAddrForm.receiverPhone;
      this.innerAlterAddrVisible = false;
    },

    alterAddr() {
      this.innerAlterAddrVisible = true;
    },

    submitOrder() {
      let user = JSON.parse(localStorage.getItem("userInfo"));
      this.order.userId = user.userId;
      this.order.memberUsername = user.username;
      this.order.totalAmount = this.orderClothingSum;
      this.order.payAmount = this.orderClothingSum;
      this.order.payType = 0;
      this.order.sourceType = 0;
      this.order.status = 0;
      this.order.orderType = 0;
      this.order.deliveryCompany = this.deliveryCompany;
      this.order.autoConfirmDay = 15;
      this.order.integration = 5;
      this.order.growth = 20;
      this.order.promotionInfo = "无";
      this.order.receiverName = this.receiver.receiverName;
      this.order.receiverPhone = this.receiver.receiverPhone;
      this.order.receiverPostCode = 528400;
      this.order.receiverProvince = this.receiver.receiverProvince;
      this.order.receiverCity = this.receiver.receiverCity;
      this.order.receiverRegion = this.receiver.receiverRegion;
      this.order.receiverDetailAddress = this.receiver.receiverDetailAddress;
      this.order.note = this.orderRemark;
      this.order.deleteStatus = 0;
      this.order.clothingId = this.clothing.id;
      let orderParam = {
        order: this.order,
        clothing: this.clothing,
        orderClothingNum: this.orderClothingNum,
        orderClothingColor: this.selectClothingAttr[0].values,
        orderClothingSize: this.selectClothingAttr[1].values,
      };
      createOrder(orderParam).then((response) => {
        if (response.code === 200) {
          this.$message({
            message: "订单提交成功，请支付",
            type: "success",
            duration: 1000,
          });
          this.orderId = response.data;
        }
      });
      this.submitOrderDialogVisible = false;
      this.paydialogVisible = true;
    },

    paydialog() {
      this.$confirm("是否要进行该支付操作?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        let updatePayOrder = {};
        updatePayOrder.orderId = this.orderId;
        updatePayOrder.payType = this.payType;
        updatePayOrder.status = 1;
        updatepayInfo(updatePayOrder).then((res) => {
          if (res.code === 200) {
            this.$message({
              message: "支付成功",
              type: "success",
              duration: 1000,
            });
            this.paydialogVisible = false;
          }
        });
      });
    },
  },
};
</script>

<style>
@import url(https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i);
@import "../../assets/vendor/icofont/icofont.min.css";
@import "../../assets/vendor/boxicons/css/boxicons.min.css";
@import "../../assets/vendor/owl.carousel/assets/owl.carousel.min.css";
@import "../../assets/vendor/venobox/venobox.css";
@import "../../assets/css/style.css";

.simpleImg-size {
  width: 255px;
  height: 255px;
}

.img-fluid {
  width: 100%;
  height: 100%;
}

.simple-button {
  margin-top: 15px;
  width: 60px;
  height: 30px;
  border: 0 none;
  font-size: 14px;
  text-align: center;
  font-weight: 500;
  line-height: 1;
  color: #444444;
  background: #f0f0f0;
  border-radius: 50px;
}

.simple-button:hover {
  color: #414c64;
  background: #ffc107;
}

.shopping-cart-button {
  margin-left: 15px;
  margin-bottom: 10px;
  width: 90px;
  height: 25px;
  border: 0 none;
  font-size: 14px;
  text-align: center;
  font-weight: 500;
  line-height: 1;
  color: #444444;
  background: #fafafc;
  border-radius: 50px;
}

.shopping-cart-button:hover {
  color: #414c64;
  background: #ffc107;
}

.line {
  margin-top: -25px;
}

.buy-img {
  width: 100px;
  height: 100px;
  border-radius: 10px;
  margin: 5px 5px;
}

.row .buy-clothingname {
  display: inline-block;
  width: 75%;
  margin-top: 10px;
  margin-left: 10px;
  font-size: 20px;
  font-weight: 550;
}

.row .buy-clothingPrice {
  font-size: 14px;
  color: rgb(110, 110, 110);
}

.row .buy-clothingSize {
  font-size: 14px;
  margin-left: 10px;
  margin-top: 20px;
  color: rgb(252, 104, 104);
}

.clothing-size {
  margin-top: 10px;
  width: 100%;
  height: 70px;
}

.clothing-size-1 {
  font-size: 16px;
  color: #6c6d6c;
  padding: 10px 10px 10px 0;
  margin-left: 5px;
  margin-top: 10px;
}

.radio-1 {
  margin-top: 10px;
  margin-left: 14px;
}

.other-mess {
  margin: 15px 0 10px 5px;
}

.other-mess .other-mess-1 {
  margin-right: 20px;
}

.batch-other-mess-1 {
  margin-top: 10px;
  margin-right: 20px;
}

.other-mess-2 {
  margin-right: 10%;
}

.sumPrice {
  display: inline-block;
  font-size: 13px;
  font-weight: 500;
  margin-left: 65%;
  margin-top: 10px;
}
.sumPrice-1 {
  font-size: 20px;
  font-weight: 500;
  color: #ffce3a;
}

.receive-location {
  height: 50px;
  margin: 10px 5px;
  background-color: rgb(252, 248, 248);
  border-radius: 8px;
}

.receive-location .icon-locate {
  display: inline-block;
  line-height: 50px;
}

.receive-location .location-span {
  display: inline-block;
  font-size: 14px;
  font-weight: bold;
  margin-top: 5px;
  margin-left: -5px;
}

.receive-location .username-span {
  font-size: 10px;
  color: rgb(110, 110, 110);
  margin-left: -5px;
}

.receive-location .icon-css {
  margin-top: 15px;
  float: right;
}
</style>
