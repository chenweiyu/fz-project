<template>
  <section id="portfolio-details" class="portfolio-details">
    <div class="container">
      <el-page-header @back="goBack" content="商品详情" class="page-header">
      </el-page-header>
      <div class="row">
        <div class="col-lg-7">
          <h4 class="clothing-title">{{ clothing.name }}-服装图片</h4>
          <div id="demo" class="carousel slide imgSize" data-ride="carousel">
            <!-- 指示符 -->
            <ul class="carousel-indicators">
              <li data-target="#demo" data-slide-to="0" class="active"></li>
              <li data-target="#demo" data-slide-to="1"></li>
              <li data-target="#demo" data-slide-to="2"></li>
            </ul>

            <!-- 轮播图片 -->
            <div class="carousel-inner">
              <!-- <div class="carousel-item active">
                <img src="../../assets/img/portfolio/portfolio-details-1.jpg" />
              </div>
              <div class="carousel-item">
                <img src="../../assets/img/portfolio/portfolio-details-2.jpg" />
              </div>
              <div class="carousel-item">
                <img src="../../assets/img/portfolio/portfolio-details-3.jpg" />
              </div> -->
              <div class="carousel-item active">
                <img :src="clothing.pic" class="carousel-item1" />
              </div>
              <div
                class="carousel-item"
                v-for="(item, index) in pics"
                :key="index"
              >
                <img :src="item" class="carousel-item1" />
              </div>
            </div>

            <!-- 左右切换按钮 -->
            <a class="carousel-control-prev" href="#demo" data-slide="prev">
              <span class="carousel-control-prev-icon"></span>
            </a>
            <a class="carousel-control-next" href="#demo" data-slide="next">
              <span class="carousel-control-next-icon"></span>
            </a>
          </div>
        </div>

        <div class="col-lg-5 good-detail">
          <h4>{{ clothing.name }}</h4>
          <ul>
            <li class="price">
              <span class="price-1">价格：</span>
              <span class="price-2">{{ clothing.price }}元</span>
              <span class="brand-1"
                ><el-tag type="success"
                  >品牌：{{ clothing.brandName }}</el-tag
                ></span
              >
            </li>
            <li class="detail-1">
              <span class="detail-2">发货</span>
              <span class="detail-3"
                >浙江杭州<!-- {{clothing.goodAddress}}-->
                | 快递:免运费</span
              >
            </li>
            <li class="detail-1">
              <span class="detail-2">保障</span>
              <span class="detail-3" v-if="!serviceId.length">商家目前没有添加保障信息</span>
              <span
                class="detail-3"
                v-for="(item, index) in serviceId"
                :key="index"
                ><span>{{ ServiceList[item - 1] }}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span
              >
            </li>
            <li class="detail-1">
              <span class="detail-2">活动</span>
              <span class="detail-3">注册新用户可领取F & C官网红包10元！</span>
            </li>
          </ul>

          <div class="payment">
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
                    @change="changeRedio"
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
                    @change="changeRedio"
                  ></el-radio>
                </el-radio-group>
              </div>
            </div>
            <div class="row">
              <div class="col-lg-5">
                <el-tag type="success" size="mini" style="margin-top: 30px"
                  >正品</el-tag
                >
              </div>
              <div class="col-lg-7 pay-button">
                <el-button type="warning" plain @click="submitCarDialogVisible()"
                  ><i class="el-icon-shopping-cart-1"></i
                  >&nbsp;加入购物车</el-button
                >
                <el-button type="danger" plain @click="buyDialogVisible()"
                  >购 买</el-button
                >
              </div>
            </div>
          </div>
        </div>
      </div>

      <!-- 加入购物车模态框 -->
      <el-dialog
        title="确认加入购物车"
        :visible.sync="addCarDialogVisible"
        width="30%"
      >
        <hr class="line" />
        <div class="row">
          <div class="col-lg-3">
            <img
              class="buy-img"
              :src="clothing.pic"
              alt="服装图片"
            />
          </div>
          <div class="col-lg-9">
            <span class="buy-clothingname"
              >{{clothing.name}}</span
            >
            <span class="buy-clothingPrice"
              >￥{{clothing.price}}</span
            >
            <div class="buy-clothingSize"><el-tag type="success" size="small"
                  >品牌：{{ clothing.brandName }}</el-tag
                ></div>
            <!-- <div class="buy-clothingSize" v-if="selectClothingAttr.length">颜色：{{ selectClothingAttr[0].values }}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;尺码：{{ selectClothingAttr[1].values }}码</div> -->
          </div>
        </div>
        <el-divider content-position="left">商品详情</el-divider>
        <div class="other-mess">
          <span class="other-mess-1">配送服务</span>
          <span class="detail-3" v-if="!serviceId.length">快递&nbsp;&nbsp;免邮</span>
          <span
                v-for="(item, index) in serviceId"
                :key="index"
                ><span>{{ ServiceList[item - 1] }}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span
              >
        </div>
        <div class="other-mess">
          <span class="other-mess-1">颜&nbsp;&nbsp;色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
          <span class="detail-3">{{ selectClothingAttr[0].values }}</span>
        </div>
        <div class="other-mess">
          <span class="other-mess-1">尺&nbsp;&nbsp;码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
          <span class="detail-3">{{ selectClothingAttr[1].values }}码</span>
        </div>
        <div style="margin-left: 5px">
          <span class="other-mess-2">数&nbsp;&nbsp;量</span>共&nbsp;<el-input-number
            v-model="clothingNum"
            size="mini"
            @change="handleChange(0)"
            :min="1"
            :max="10"
            label="描述文字"
          ></el-input-number
          >&nbsp;件
        </div>
        <span class="sumPrice">合计：</span>￥<span class="sumPrice-1">{{
          carClothingSum
        }}</span>
        <span slot="footer" class="dialog-footer">
          <el-button @click="addCarDialogVisible = false">取 消</el-button>
          <el-button type="warning" @click="addCar">确定</el-button>
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
            <img
              class="buy-img"
              :src="clothing.pic"
              alt=""
            />
          </div>
          <div class="col-lg-9">
            <span class="buy-clothingname"
              >{{ clothing.name }}</span
            >
            <span class="buy-clothingPrice"
              >￥{{ clothing.price }}</span
            >
            <div class="buy-clothingSize" v-if="selectClothingAttr.length">颜色：{{ selectClothingAttr[0].values }}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;尺码：{{ selectClothingAttr[1].values }}码</div>
          </div>
        </div>
        <div class="row receive-location">
          <div class="col-lg-1">
            <i class="el-icon-map-location icon-locate"></i>
          </div>
          <div class="col-lg-10">
            <span class="location-span"
              >广东省中山市学院路1号</span
            >
            <div>
              <span class="username-span"
                >小哈猫&nbsp;&nbsp;16161717181</span
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
        <div style="margin-left: 5px">
          <span class="other-mess-2">数量</span>共&nbsp;<el-input-number
            v-model="clothingNum"
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
            <el-input type="textarea" v-model="form.desc"></el-input>
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
            <el-form-item label="所在地区">
              <el-row>
                <el-col :span="7" class="address-spacing">
                  <el-input
                    v-model="alterAddrForm.receiverAddrProvince"
                    placeholder="省份"
                  ></el-input>
                </el-col>
                <el-col :span="7" class="address-spacing">
                  <el-input
                    v-model="alterAddrForm.receiverAddrCity"
                    placeholder="城市"
                  ></el-input>
                </el-col>
                <el-col :span="7">
                  <el-input
                    v-model="alterAddrForm.receiverAddrStreet"
                    placeholder="区/县/乡"
                  ></el-input>
                </el-col>
              </el-row>
            </el-form-item>
          </el-form>

          <span slot="footer" class="dialog-footer">
            <el-button @click="innerAlterAddrVisible = false">取 消</el-button>
            <el-button type="warning" @click="accurateAddr">确定</el-button>
          </span>
        </el-dialog>
      </el-dialog>
    </div>
  </section>
</template>

<script>
import { getClothing } from "@/api/clothing";
import { fetchList as fetchClothingAttrList } from "@/api/clothingAttr";

export default {
  name: "GoodDetail",

  data() {
    return {
      clothing: {},
      pics: [],
      selectClothingAttr: [],
      radio: "M",
      submitOrderDialogVisible: false,
      addCarDialogVisible: false,
      form: {
        desc: "",
      },
      clothingNum: 1,
      carClothingSum: 0,
      orderClothingSum: 0,
      innerAlterAddrVisible: false,
      alterAddrForm: {
        receiver: "",
        receiverPhone: "",
        receiverAddrProvince: "",
        receiverAddrCity: "",
        receiverAddrStreet: "",
      },
      ServiceList: ["无忧退货", "快速退款", "免费包邮"],
      serviceId: [],
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

  created() {
    this.getGoodsInfo();
  },

  methods: {
    goBack() {
      window.history.back();
    },
    alterAddr() {
      this.innerAlterAddrVisible = true;
    },
    accurateAddr() {
      console.log(this.alterAddrForm);
      this.innerAlterAddrVisible = false;
    },
    buyDialogVisible() {
      this.submitOrderDialogVisible = true;
    },
    submitCarDialogVisible() {
      this.handleChange(0);
      this.addCarDialogVisible = true;
    },
    submitOrder() {},
    addCar() {},
    handleChange(index) {
      if (index === 0) {
        this.carClothingSum = this.clothingNum * this.clothing.price;
        this.carClothingSum = this.carClothingSum.toFixed(1);
      } else {
        this.orderClothingSum = this.clothingNum * this.clothing.price;
        this.orderClothingSum = this.orderClothingSum.toFixed(1);
      }
    },
    getGoodsInfo() {
      getClothing(this.$route.query.id).then((response) => {
        this.clothing = response.data;
        // if (
        //   this.clothing.pic === undefined ||
        //   this.clothing.pic == null ||
        //   this.clothing.pic === ""
        // ) {
        //   return;
        // }
        // this.pics.push(this.clothing.pic);
        if (
          this.clothing.albumPics === undefined ||
          this.clothing.albumPics == null ||
          this.clothing.albumPics === ""
        ) {
          return;
        }
        let albumPics = this.clothing.albumPics.split(",");
        for (let i = 0; i < albumPics.length; i++) {
          this.pics.push(albumPics[i]);
        }
        this.getClothingAttrList(0, this.clothing.clothingAttributeCategoryId);
        this.serviceId = this.getServiceList();
        console.log(this.serviceId);
      });
    },
    getClothingAttrList(type, cid) {
      let param = { pageNum: 1, pageSize: 100, type: type };
      fetchClothingAttrList(cid, param).then((response) => {
        let list = response.data.list;
        console.log(list);
        for (let i = 0; i < list.length; i++) {
          let options = [];
          let values = [];
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
            values: null,
          });
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
            console.log(strArr[j]);
            options.push(strArr[j]);
          }
          break;
        }
      }
      return options;
    },
    changeRedio() {
      console.log("this.selectClothingAttr", this.selectClothingAttr);
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

.page-header {
  margin-bottom: 10px;
}

.clothing-title {
  font-weight: 500;
  margin: 10px 0 15px 0;
}

.imgSize {
  height: 380px;
}

.imgSize img {
  width: 100%;
}

.good-detail {
  margin-top: 50px;
}

.good-detail h4 {
  font-weight: bold;
}

ul {
  list-style: none;
  margin: 15px -40px;
}

ul li {
  margin: 10px 0;
}
ul li:nth-child(2) {
  margin-top: 20px;
}

ul .price {
  width: 450px;
  height: 50px;
  background-image: url("../../assets/img/price-background.jpg");
}

ul li .price-1 {
  padding-left: 15px;
  font-size: 16px;
  color: #6c6d6c;
  line-height: 50px;
}

ul li .price-2 {
  font-size: 26px;
  color: #ffce3a;
  line-height: 50px;
  font-weight: 600;
}

.brand-1 {
  float: right;
  margin: 10px 15px;
}

.good-detail ul li .detail-1 {
  width: 100%;
  height: 30px;
}
.good-detail ul li .detail-2 {
  font-size: 14px;
  color: rgb(110, 110, 110);
  line-height: 30px;
  padding-left: 5px;
  padding-right: 20px;
}

.good-detail ul li .detail-3 {
  font-size: 14px;
}

.payment {
  width: 100%;
  height: 105px;
  margin-top: 35px;
  border-radius: 10px;
}

.payment .clothing-size {
  width: 100%;
  height: 50px;
}

.payment .clothing-size-1 {
  font-size: 16px;
  color: #6c6d6c;
  padding: 10px 10px 10px 0;
  margin-left: 7px;
}

.payment .radio-1 {
  margin-top: 6px;
}

.payment .clothing-size-2 {
  margin-top: 10px;
}

.payment .pay-button {
  margin-top: 30px;
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
  color: rgb(110, 110, 110);
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

.other-mess {
  margin: 15px 0 10px 5px;
}

.other-mess .other-mess-1 {
  margin-right: 20px;
}

.other-mess-2 {
  margin-right: 48px;
}

.order-remark {
  margin: 10px 0 10px 5px;
}

.sumPrice {
  display: inline-block;
  font-size: 14px;
  font-weight: 500;
  margin-left: 65%;
  margin-top: 10px;
}

.sumPrice-1 {
  font-size: 22px;
  font-weight: 500;
  color: #ffce3a;
}

.address-spacing {
  margin-right: 10px;
}

.carousel-item1 {
  width: 635px;
  height: 380px;
}
</style>
