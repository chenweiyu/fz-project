<template>
  <section id="portfolio-details" class="portfolio-details">
    <div class="container">
      <el-page-header @back="goBack" content="我的详情"> </el-page-header>
      <el-menu
        :default-active="activeIndex"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
      >
        <el-menu-item index="1">全部订单</el-menu-item>
        <el-menu-item index="7">未付款</el-menu-item>
        <el-menu-item index="2">待发货</el-menu-item>
        <el-menu-item index="3">已发货</el-menu-item>
        <el-menu-item index="4">已收货</el-menu-item>
        <el-menu-item index="5">退款中</el-menu-item>
        <el-menu-item index="6">已退款</el-menu-item>
      </el-menu>
      <el-table :data="showOrders" class="goodCart-table">
        <el-table-column type="selection" width="45"> </el-table-column>
        <el-table-column label="已提交订单商品" width="120"
          ><template slot-scope="scope">
            <img
              :src="scope.row.clothingPic"
              width="100"
              height="100"
              class="head_pic"
            />
          </template>
        </el-table-column>
        <el-table-column prop="clothingName" width="210"
          ><template slot-scope="scope"
            ><p>{{ scope.row.clothingName }}</p>
            <p>
              <el-tag
                v-if="scope.row.orderType === 2 && scope.row.payType !== 0"
                size="mini"
                style="margin-right: 10px"
                >退款中</el-tag
              >
              <el-tag
                type="success"
                v-if="scope.row.orderType === 3"
                size="mini"
                style="margin-right: 10px"
                >已退款</el-tag
              >
              <el-tag
                type="success"
                v-if="
                  scope.row.status === 1 &&
                  scope.row.orderType !== 3 &&
                  scope.row.orderType !== 2 &&
                  scope.row.payType !== 0
                "
                size="mini"
                style="margin-right: 10px"
                >待发货</el-tag
              >
              <el-tag
                type="success"
                v-if="scope.row.status === 2 && scope.row.orderType !== 3"
                size="mini"
                style="margin-right: 10px"
                >已发货</el-tag
              >
              <el-tag
                type="success"
                v-if="scope.row.status === 6 && scope.row.orderType !== 3"
                size="mini"
                style="margin-right: 10px"
                >已收货</el-tag
              >
            </p></template
          ></el-table-column
        >
        <el-table-column
          prop="orderSn"
          label="订单编号"
          width="180"
          align="center"
        >
        </el-table-column>
        <el-table-column
          prop="clothingPrice"
          label="商品单价"
          width="100"
          align="center"
        >
        </el-table-column>
        <el-table-column
          prop="clothingNum"
          label="数目"
          width="50"
          align="center"
        >
        </el-table-column>
        <el-table-column label="付款状态" width="100" align="center">
          <template slot-scope="scope">
            <el-tag type="warning" size="small">{{
              scope.row.payType | formatPayType
            }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column
          prop="payment"
          label="实付金额"
          width="100"
          align="center"
        >
        </el-table-column>
        <el-table-column label="操作" width="180" align="center">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="primary"
              icon="el-icon-money"
              @click="showPayDialog(scope.$index)"
              v-if="scope.row.payType === 0"
              >付款
            </el-button>
            <el-button
              size="mini"
              type="warning"
              icon="el-icon-edit"
              plain
              @click="showReturnRequestDialog(scope.$index)"
              v-if="
                scope.row.payType !== 0 &&
                scope.row.orderType !== 2 &&
                scope.row.orderType !== 3
              "
              >退款
            </el-button>
            <el-button
              size="mini"
              type="info"
              icon="el-icon-message"
              @click="showOrderDetailDialog(scope.$index)"
              >详情
            </el-button>
            <el-button
              size="mini"
              type="success"
              icon="el-icon-success"
              style="margin-top: 10px"
              @click="confirmDialog(scope.$index)"
              v-if="scope.row.status === 2 && scope.row.orderType !== 3"
              >确认收货
            </el-button>
          </template>
        </el-table-column>
      </el-table>

      <el-row v-show="activeIndex === '1'">
        <el-col :span="18">
          <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="queryInfo.pageNum"
            :page-size="queryInfo.pageSize"
            :page-sizes="[5, 10, 20, 40]"
            layout="total, sizes, prev, pager, next, jumper"
            :total="total"
          >
          </el-pagination>
        </el-col>
      </el-row>

      <!-- 订单详情 -->
      <el-dialog
        title="订单详情"
        :visible.sync="orderDetailDialogVisible"
        width="35%"
      >
        <hr class="line" />
        <div class="row">
          <div class="col-lg-3">
            <img class="buy-img" :src="orderDetail.clothingPic" alt="" />
          </div>
          <div class="col-lg-9">
            <span class="buy-goodsname">{{ orderDetail.clothingName }}</span>
            <span class="buy-goodsPrice"
              >￥{{ orderDetail.clothingPrice }}</span
            >
            <div class="buy-goodsSize">
              颜色：{{
                orderDetail.clothingColor
              }}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;尺码：{{
                orderDetail.clothingSize
              }}码
            </div>
            <el-tag
              v-if="orderDetail.orderType === 2"
              size="mini"
              style="margin-left: 10px"
              >该订单退款中</el-tag
            >
            <el-tag
              type="success"
              v-if="orderDetail.orderType === 3"
              size="mini"
              style="margin-left: 10px"
              >该订单已退款</el-tag
            >
            <el-tag
              type="success"
              v-if="orderDetail.status === 1 && orderDetail.orderType !== 3"
              size="mini"
              style="margin-left: 10px"
              >该订单待发货</el-tag
            >
            <el-tag
              type="success"
              v-if="orderDetail.status === 2 && orderDetail.orderType !== 3"
              size="mini"
              style="margin-left: 10px"
              >该订单已发货</el-tag
            >
            <el-tag
              type="success"
              v-if="orderDetail.orderType === 6 && orderDetail.orderType !== 3"
              size="mini"
              style="margin-left: 10px"
              >该订单已收货</el-tag
            >
          </div>
        </div>
        <el-divider content-position="left">收货信息</el-divider>
        <div class="row receive-location">
          <div class="col-lg-1 col-md-1 col-sm-1">
            <i class="el-icon-map-location icon-locate"></i>
          </div>
          <div class="col-lg-10 col-md-10 col-sm-10">
            <span class="location-span">{{ orderDetail.location }}</span>
            <div>
              <span class="username-span"
                >{{ orderDetail.receiverName }}&nbsp;&nbsp;{{
                  orderDetail.receiverPhone
                }}</span
              >
            </div>
          </div>
        </div>
        <el-divider content-position="left">商品信息</el-divider>
        <ul class="order-mess">
          <li>
            <span class="goods-mess-1">数量</span>{{ orderDetail.clothingNum }}
          </li>
          <li>
            <span class="goods-mess-2">付款状态</span
            ><el-tag type="warning" size="small">{{
              orderDetail.payType | formatPayType
            }}</el-tag>
          </li>
          <li>
            <span class="goods-mess-1">实付</span>{{ orderDetail.payment }}元
          </li>
          <li>
            <span class="goods-mess-3">订单提交时间</span
            >1<!--{{orderDetail.submitTime}}-->
          </li>
        </ul>
        <el-divider content-position="left">订单备注</el-divider>
        <div>
          <el-input type="textarea" v-model="remarks"></el-input>
        </div>
        <span class="sumPrice">实付：</span>￥<span class="sumPrice-1">{{
          orderDetail.payment
        }}</span>
        <span slot="footer" class="dialog-footer">
          <el-button @click="orderDetailDialogVisible = false">取 消</el-button>
          <el-button type="warning" @click="orderDetailDialogVisible = false"
            >确定</el-button
          >
        </span>
      </el-dialog>

      <!-- 支付模态框 -->
      <el-dialog
        title="支付界面"
        :visible.sync="paydialogVisible"
        width="30%"
        :before-close="cancelPaydialog"
      >
        <span>应付金额：</span
        ><span style="font-size: 18px; font-weight: bold; color: #293a29"
          >&nbsp;{{ orderClothingSum }}元</span
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
          <el-button @click="cancelPaydialog">取 消</el-button>
          <el-button type="warning" @click="paydialog">确 定 支 付</el-button>
        </span>
      </el-dialog>

      <!-- 申请退款模态框 -->
      <el-dialog
        title="申请退款界面"
        :visible.sync="returnDialogVisible"
        width="30%"
        :before-close="cancelReturndialog"
      >
        <div style="margin-left: 13%; margin-bottom: 20px">
          <el-tag type="info" size="small"
            >取消后无法恢复，优惠劵，红包可退回，有效期内使用</el-tag
          >
        </div>
        <p>请选择退款原因：</p>
        <div>
          <el-radio-group v-model="returnRequest.reason">
            <el-radio
              v-for="(item, index) in selectReturnReason"
              :label="item"
              :key="index"
              style="display: block; margin-left: 40%; margin-bottom: 15px"
            ></el-radio>
          </el-radio-group>
        </div>
        <div>
          <p style="margin-bottom: 10px">问题描述：</p>
          <el-input
            type="textarea"
            v-model="returnRequest.description"
          ></el-input>
        </div>
        <span slot="footer" class="dialog-footer">
          <el-button @click="cancelReturndialog">取 消</el-button>
          <el-button type="warning" @click="returnRequestDialog"
            >确 定 退 款</el-button
          >
        </span>
      </el-dialog>
    </div>
  </section>
</template>

<script>
import { getUserOrderList, updatepayInfo } from "@/api/order";
import { fetchusefulList } from "@/api/returnReason";
import { createReturnApply } from "@/api/returnApply";

export default {
  name: "GoodCart",
  data() {
    return {
      activeIndex: "1",
      total: 0,
      queryInfo: {
        query: "",
        pageNum: 1,
        pageSize: 10,
      },
      queryInfoList: {
        pageNum: 1,
        pageSize: 1000,
      },
      remarks: "",
      orderDetailDialogVisible: false,
      paydialogVisible: false,
      returnDialogVisible: false,
      orderDetail: {},
      orderList: [],
      orders: [],
      ordersList: [],
      showOrders: [],
      goodsSum: 0,
      payType: null,
      orderClothingSum: 0,
      updatePayOrder: {},
      index: null,
      selectReturnReason: [],
      returnRequest: {
        reason: "",
        description: "",
      },
      user: {},
      currentRowId: null,
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
    this.user = this.$store.state.user.user;
    this.orders = this.getMyOrder(this.queryInfo);
    this.ordersList = this.getMyOrder(this.queryInfoList);
  },

  filters: {
    formatPayType(value) {
      if (value === 1) {
        return "支付宝";
      } else if (value === 2) {
        return "微信支付";
      } else {
        return "未支付";
      }
    },
  },

  methods: {
    goBack() {
      window.history.back();
    },

    handleSelect(key, keyPath) {
      console.log("key:" + key + "; keyPath:" + keyPath);
      let queryInfo = {
        pageNum: 1,
        pageSize: 1000,
      };
      // this.showOrders = [];
      if (key == 1) {
        this.activeIndex = "1";
        this.showOrders = this.orders;
      } else if (key == 2) {
        this.activeIndex = "2";
        this.showOrders = this.ordersList.filter(
          (item) =>
            item.status === 1 &&
            item.orderType !== 3 &&
            item.orderType !== 2 &&
            item.payType !== 0
        );
      } else if (key == 3) {
        this.activeIndex = "3";
        this.showOrders = this.ordersList.filter(
          (item) => item.status === 2 && item.orderType !== 3
        );
      } else if (key == 4) {
        console.log("2");
        this.activeIndex = "4";
        this.showOrders = this.ordersList.filter(
          (item) => item.status === 6 && item.orderType !== 3
        );
      } else if (key == 5) {
        this.activeIndex = "5";
        this.showOrders = this.ordersList.filter(
          (item) => item.orderType === 2 && item.payType !== 0
        );
      } else if (key == 7) {
        this.activeIndex = "7";
        this.showOrders = this.ordersList.filter((item) => item.payType === 0);
      } else if (key == 6) {
        this.activeIndex = "6";
        this.showOrders = this.ordersList.filter(
          (item) => item.orderType === 3
        );
      }
    },

    handleChange(id) {
      this.goodsCart[id].payment =
        this.goodsCart[id].goodPrice * this.goodsCart[id].goodNum;
    },

    getMyOrder(queryInfo) {
      let userId = this.$store.state.user.user.userId;
      let orders = [];
      getUserOrderList(userId, queryInfo).then((res) => {
        console.log(res);
        this.orderList = res.data.list;
        this.total = res.data.total;
        for (let i = 0; i < this.orderList.length; i++) {
          let order = {
            clothingPic: this.orderList[i].orderItemList[0].clothingPic,
            clothingName: this.orderList[i].orderItemList[0].clothingName,
            clothingBrand: this.orderList[i].orderItemList[0].clothingBrand,
            orderSn: this.orderList[i].orderSn,
            clothingPrice: this.orderList[i].orderItemList[0].clothingPrice,
            payType: this.orderList[i].payType,
            clothingNum:
              "x" + this.orderList[i].orderItemList[0].clothingQuantity,
            payment: "￥" + this.orderList[i].payAmount,
            clothingAttr: this.orderList[i].orderItemList[0].clothingAttr,
            receiverProvince: this.orderList[i].receiverProvince,
            receiverCity: this.orderList[i].receiverCity,
            receiverRegion: this.orderList[i].receiverRegion,
            receiverDetailAddress: this.orderList[i].receiverDetailAddress,
            receiverName: this.orderList[i].receiverName,
            receiverPhone: this.orderList[i].receiverPhone,
            note: this.orderList[i].note,
            orderId: this.orderList[i].id,
            clothingId: this.orderList[i].orderItemList[0].clothingId,
            memberUsername: this.orderList[i].memberUsername,
            payAmount: this.orderList[i].payAmount,
            clothingCount: this.orderList[i].orderItemList[0].clothingQuantity,
            orderType: this.orderList[i].orderType,
            status: this.orderList[i].status,
          };
          orders.push(order);
        }
        this.showOrders = this.orders;
      });
      return orders;
    },

    async showOrderDetailDialog(id) {
      this.orderDetail = this.orders[id];
      let attr = JSON.parse(this.orderDetail.clothingAttr);
      this.orderDetail.clothingColor = attr[0].value;
      this.orderDetail.clothingSize = attr[1].value;
      this.orderDetail.location =
        this.orderDetail.receiverProvince +
        this.orderDetail.receiverCity +
        this.orderDetail.receiverRegion +
        this.orderDetail.receiverDetailAddress;
      this.remarks = this.orderDetail.note;
      this.orderDetailDialogVisible = true;
    },

    showPayDialog(id) {
      this.index = id;
      this.orderClothingSum = this.orders[id].payment;
      this.updatePayOrder.orderId = this.orders[id].orderId;
      this.paydialogVisible = true;
    },

    cancelPaydialog() {
      this.paydialogVisible = false;
    },

    paydialog() {
      this.updatePayOrder.payType = this.payType;
      this.updatePayOrder.status = 1;
      console.log(this.updatePayOrder);
      updatepayInfo(this.updatePayOrder).then((res) => {
        if (res.code === 200) {
          this.orders = this.getMyOrder();
          this.$message({
            message: "支付成功",
            type: "success",
            duration: 1000,
          });
          this.paydialogVisible = false;
        }
      });
    },

    showReturnRequestDialog(id) {
      this.currentRowId = id;
      fetchusefulList().then((res) => {
        this.selectReturnReason = [];
        if (res.code === 200) {
          for (let i = 0; i < res.data.list.length; i++) {
            this.selectReturnReason.push(res.data.list[i].name);
          }
        }
      });
      let attr = "";
      let str = JSON.parse(this.orders[id].clothingAttr);
      let len = str.length;
      for (let i = 0; i < len; i++) {
        attr += str[i].key + "：" + str[i].value;
        if (i != len - 1) {
          attr += "；";
        }
      }
      this.returnDialogVisible = true;
      this.returnRequest.orderId = this.orders[id].orderId;
      this.returnRequest.companyAddressId = 1;
      this.returnRequest.clothingId = this.orders[id].clothingId;
      this.returnRequest.orderSn = this.orders[id].orderSn;
      this.returnRequest.memberUsername = this.orders[id].memberUsername;
      this.returnRequest.returnAmount = this.orders[id].payAmount;
      this.returnRequest.returnName = this.user.username;
      this.returnRequest.returnPhone = this.user.phone;
      this.returnRequest.status = 0;
      this.returnRequest.clothingPic = this.orders[id].clothingPic;
      this.returnRequest.clothingName = this.orders[id].clothingName;
      this.returnRequest.clothingBrand = this.orders[id].clothingBrand;
      this.returnRequest.clothingAttr = attr;
      this.returnRequest.clothingCount = this.orders[id].clothingCount;
      this.returnRequest.clothingPrice = this.orders[id].clothingPrice;
      this.returnRequest.clothingRealPrice = this.orders[id].payAmount;
    },

    returnRequestDialog() {
      createReturnApply(this.returnRequest).then((res) => {
        if (res.code === 200) {
          this.updatePayOrder = {};
          this.updatePayOrder.orderId = this.orders[this.currentRowId].orderId;
          this.updatePayOrder.orderType = 2;
          updatepayInfo(this.updatePayOrder).then((res) => {
            console.log("orderType", res);
          });
          this.returnDialogVisible = false;
          this.orders[this.currentRowId].orderType = 2;
          this.$message({
            message: "退款提交成功，待后台人员确认",
            type: "success",
            duration: 1500,
          });
        }
      });
    },

    cancelReturndialog() {
      this.returnDialogVisible = false;
    },

    confirmDialog(id) {
      this.$confirm("是否要进行该确认收货操作?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        this.updatePayOrder.orderId = this.showOrders[id].orderId;
        this.updatePayOrder.status = 6;
        updatepayInfo(this.updatePayOrder).then((res) => {
          if (res.code === 200) {
            this.activeIndex = "1";
            this.ordersList = this.getMyOrder(this.queryInfoList);
            this.$message({
              message: "确认收货成功",
              type: "success",
              duration: 1000,
            });
            this.orders = this.getMyOrder(this.queryInfo);
            this.ordersList = this.getMyOrder(this.queryInfoList);
          }
        });
      });
    },

    //分页
    handleSelectionChange(val) {
      console.log(val);
      //复制id到multipleSelection   map  [3,2,5,6,7]
      this.multipleSelection = val.map((x) => {
        return x.id;
      });
      console.log("选择的id：", this.multipleSelection);
    },
    // //分页
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.queryInfo.pageSize = val;
      this.queryInfo.pageNum = 1;
      this.orders = this.getMyOrder(this.queryInfo);
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.queryInfo.pageNum = val; // 获取新页码
      this.orders = this.getMyOrder(this.queryInfo);
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

.goodCart-table {
  width: 100%;
  margin: 20px 0;
}

.settlement-span {
  margin-right: 10px;
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

.row .buy-goodsname {
  display: inline-block;
  width: 75%;
  margin-top: 10px;
  margin-left: 10px;
  font-size: 20px;
  font-weight: 550;
}

.row .buy-goodsPrice {
  font-size: 14px;
  color: rgb(110, 110, 110);
}

.row .buy-goodsSize {
  font-size: 14px;
  margin-left: 10px;
  margin-top: 20px;
  margin-bottom: 5px;
  color: rgb(161, 98, 98);
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

.order-mess {
  list-style: none;
  margin: 10px 0px 10px 5px;
  padding: 0px;
  height: 145px;
  line-height: 30px;
  background-color: rgb(252, 248, 248);
  border-radius: 8px;
}

.order-mess li {
  margin: 7px 7px 7px 15px;
}

.order-mess li .goods-mess-1 {
  font-weight: 14px;
  color: rgb(110, 110, 110);
  margin-right: 87px;
}
.order-mess li .goods-mess-2 {
  color: rgb(110, 110, 110);
  margin-right: 56px;
}
.order-mess li .goods-mess-3 {
  color: rgb(110, 110, 110);
  margin-right: 30px;
}

.order-remark {
  margin: 0px 0 10px 5px;
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
</style>
