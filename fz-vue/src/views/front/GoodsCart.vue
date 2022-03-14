<template>
  <section id="portfolio-details" class="portfolio-details">
    <div class="container">
      <el-page-header @back="goBack" content="我的购物车"> </el-page-header>
      <el-table
        :data="goodsCart"
        class="goodCart-table"
        @select="changeGoods"
        @select-all="changeAllGoods"
      >
        <el-table-column type="selection" width="55"> </el-table-column>
        <el-table-column label="服装商品" width="120"
          ><template slot-scope="scope">
            <img
              :src="scope.row.goodImg"
              width="100"
              height="100"
              class="head_pic"
            />
          </template>
        </el-table-column>
        <el-table-column prop="goodName" width="380"> </el-table-column>
        <el-table-column prop="goodPrice" label="商品单价" width="120">
        </el-table-column>
        <el-table-column label="数量" width="160">
          <template slot-scope="scope">
            <el-input-number
              v-model="scope.row.goodNum"
              controls-position="right"
              @change="handleChange(scope.$index)"
              :min="1"
              :max="1000"
              size="mini"
              :disabled="selectedCount"
            ></el-input-number>
          </template>
        </el-table-column>
        <el-table-column prop="payment" label="支付金额" width="120">
        </el-table-column>
        <el-table-column label="操作" width="150">
          <template slot-scope="scope">
            <el-tooltip
              class="item"
              effect="light"
              content="删除该商品"
              placement="bottom"
            >
              <el-button
                size="mini"
                type="primary"
                icon="el-icon-delete"
                circle
                plain
              >
              </el-button>
            </el-tooltip>
            <el-tooltip
              class="item"
              effect="light"
              content="购买"
              placement="bottom"
            >
              <el-button
                size="mini"
                type="warning"
                icon="el-icon-sell"
                circle
                plain
                @click="buyDialogVisible(scope.$index)"
              >
              </el-button>
            </el-tooltip>
            <el-tooltip
              class="item"
              effect="light"
              content="商品详情"
              placement="bottom"
            >
              <el-button
                size="mini"
                type="info"
                icon="el-icon-message"
                circle
                plain
                @click="goodsDetail(scope.$index)"
              >
              </el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <el-row>
        <el-col :span="18">
          <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="queryInfo.pagenum"
            :page-size="queryInfo.pagesize"
            :page-sizes="[5, 10, 20, 40]"
            layout="total, sizes, prev, pager, next, jumper"
            :total="total"
          >
          </el-pagination>
        </el-col>
        <el-col :span="6">
          <div>
            <span class="settlement-span">总计：￥{{ goodsSum }}元</span>
            <el-button type="success" size="medium" round>结算</el-button>
          </div>
        </el-col>
      </el-row>

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
              src="../../assets/img/portfolio/portfolio-details-1.jpg"
              alt=""
            />
          </div>
          <div class="col-lg-9">
            <span class="buy-goodsname"
              >潮流破洞牛仔裤<!-- {{goods.name}} --></span
            >
            <span class="buy-goodsPrice">￥88.88<!-- {{goods.price}} --></span>
            <div class="buy-goodsSize">尺码：{{ this.radio }}码</div>
          </div>
        </div>
        <div class="row receive-location">
          <div class="col-lg-1">
            <i class="el-icon-map-location icon-locate"></i>
          </div>
          <div class="col-lg-10">
            <span class="location-span"
              >广东省中山市学院路1号<!-- {{user.location}} --></span
            >
            <div>
              <span class="username-span"
                >小哈猫<!-- {{user.username}} -->&nbsp;&nbsp;16161717181<!-- {{user.phone}} --></span
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
            v-model="goodsNum"
            size="mini"
            @change="handleChange1"
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
          buyGoodsSum
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

        <!-- <el-dialog title="收货信息" :visible.sync="innerAlterAddrVisible">
          <el-table :data="alterAddrForm">
            <el-table-column
              property="receiver"
              label="收货人"
              width="150"
            ></el-table-column>
            <el-table-column
              property="receiverPhone"
              label="收货人电话"
              width="150"
            ></el-table-column>
          </el-table>
        </el-dialog> -->
      </el-dialog>
    </div>
  </section>
</template>

<script>
export default {
  name: "GoodCart",
  data() {
    return {
      total: 0,
      queryInfo: {
        query: "",
        pagenum: 1,
        pagesize: 10,
      },
      selectedCount: false,
      innerAlterAddrVisible: false,

      goods: {},
      radio: "M",
      submitOrderDialogVisible: false,
      form: {
        desc: "",
      },
      alterAddrForm: {
        receiver: "",
        receiverPhone: "",
        receiverAddrProvince: "",
        receiverAddrCity: "",
        receiverAddrStreet: "",
      },
      goodsNum: 1,

      goodsCart: [
        {
          goodImg: require("../../assets/img/portfolio/portfolio-1.jpg"),
          goodName: "潮流破洞牛仔裤",
          goodPrice: 88.88,
          goodNum: 1,
          payment: 88.88,
        },
        {
          goodImg: require("../../assets/img/portfolio/portfolio-2.jpg"),
          goodName: "简约舒适上衣",
          goodPrice: 188.88,
          goodNum: 1,
          payment: 188.88,
        },
      ],

      goodsSum: 0,
      buyGoodsSum: 0,
      goodsPrice: 0,
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

  // created() {
  //   // this.buyGoodsSum = this.goods.price;
  //   this.buyGoodsSum = ;
  // },

  methods: {
    goBack() {
      window.history.back();
    },

    buyDialogVisible(id) {
      this.goodsPrice = this.goodsCart[id].payment;
      this.buyGoodsSum = this.goodsCart[id].payment;
      this.goodsNum = 1;
      this.submitOrderDialogVisible = true;
    },

    submitOrder() {},

    handleChange1() {
      this.buyGoodsSum = this.goodsNum * this.goodsPrice;
      this.buyGoodsSum = this.buyGoodsSum.toFixed(2);
    },

    handleChange(id) {
      this.goodsCart[id].payment =
        this.goodsCart[id].goodPrice * this.goodsCart[id].goodNum;
      this.goodsCart[id].payment = this.goodsCart[id].payment;
    },

    goodsDetail(id) {
      this.$router.push("/goodsDetail");
      console.log(id);
    },

    changeGoods(list, row) {
      let selected = list.length && list.indexOf(row) !== -1;
      if (selected == true) {
        this.goodsSum += row.payment;
      } else {
        this.goodsSum -= row.payment;
        // this.selectedCount = false;
      }
    },

    changeAllGoods(list) {
      // console.log("all", list.length);
      if (list.length == 0) {
        this.goodsSum = 0;
      } else {
        this.goodsSum = 0;
        for (var i = 0; i < list.length; i++) {
          this.goodsSum += list[i].payment;
        }
      }
    },

    alterAddr() {
      this.innerAlterAddrVisible = true;
    },

    accurateAddr() {
      console.log(this.alterAddrForm);
      this.innerAlterAddrVisible = false;
    },

    // cancelGoods(list) {
    //   for (var i = 0; i < list.length; i++) {
    //     this.goodsSum -= list[i].payment;
    //   }
    // },

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
      this.queryInfo.pagesize = val;
      this.getList();
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.queryInfo.pagenum = val; // 获取新页码
      this.getList();
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
.receive-location .icon-css {
  margin-top: 15px;
  float: right;
}

.receive-location .username-span {
  font-size: 10px;
  color: rgb(110, 110, 110);
  margin-left: -5px;
}

.other-mess {
  margin: 20px 0 10px 5px;
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

.alterAddr-css {
  margin-left: 5px;
}

.address-spacing {
  margin-right: 10px;
}
</style>
