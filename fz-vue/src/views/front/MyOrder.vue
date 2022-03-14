<template>
  <section id="portfolio-details" class="portfolio-details">
    <div class="container">
      <el-page-header @back="goBack" content="我的详情"> </el-page-header>
      <el-table :data="orders" class="goodCart-table">
        <el-table-column type="selection" width="55"> </el-table-column>
        <el-table-column label="已提交订单商品" width="120"
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
        <el-table-column prop="goodPrice" label="商品单价" width="100">
        </el-table-column>
        <el-table-column prop="goodNum" label="数目" width="60">
        </el-table-column>
        <el-table-column label="付款状态" width="100">
          <el-tag type="warning" size="small"
            >已支付<!--{{order.status}}--></el-tag
          >
        </el-table-column>
        <el-table-column prop="payment" label="实付金额" width="100">
        </el-table-column>
        <el-table-column label="操作" width="180">
          <template slot-scope="scope">
            <el-button size="mini" type="warning" icon="el-icon-edit"
              >退款
            </el-button>
            <el-button
              size="mini"
              type="info"
              icon="el-icon-message"
              @click="showOrderDetailDialog(scope.$index)"
              >详情
            </el-button>
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
      </el-row>

      <!-- 订单详情 -->
      <el-dialog
        title="订单详情"
        :visible.sync="orderDetailDialogVisible"
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
            <div class="buy-goodsSize">
              尺码：<!-- {{orderDetail.radio}} -->码
            </div>
          </div>
        </div>
        <el-divider content-position="left">收货信息</el-divider>
        <div class="row receive-location">
          <div class="col-lg-1 col-md-1 col-sm-1">
            <i class="el-icon-map-location icon-locate"></i>
          </div>
          <div class="col-lg-10 col-md-10 col-sm-10">
            <span class="location-span"
              >广东省中山市学院路1号<!-- {{user.location}} --></span
            >
            <div>
              <span class="username-span"
                >小哈猫<!-- {{user.username}} -->&nbsp;&nbsp;16161717181<!-- {{user.phone}} --></span
              >
            </div>
          </div>
        </div>
        <el-divider content-position="left">商品信息</el-divider>
        <ul class="order-mess">
          <li>
            <span class="goods-mess-1">数量</span>{{ orderDetail.goodNum }}
          </li>
          <li>
            <span class="goods-mess-2">付款状态</span
            ><el-tag type="warning" size="small"
              >已支付<!--{{order.status}}--></el-tag
            >
          </li>
          <li>
            <span class="goods-mess-1">总价</span>{{ orderDetail.payment }}
          </li>
          <li>
            <span class="goods-mess-3">订单提交时间</span
            >1<!--{{orderDetail.submitTime}}-->
          </li>
        </ul>
        <el-divider content-position="left">订单备注</el-divider>
        <div>
          <el-input type="textarea" v-model="form.desc"></el-input>
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

      form: {
        desc: "",
      },

      orderDetailDialogVisible: false,
      orderDetail: {},

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

    async showOrderDetailDialog(id) {
      console.log(id);
      this.orderDetail = this.orders[id];
      // const { data: res } = await this.$http.get("/role/info/" + id);
      // if (res.code !== 200) {
      //   return this.$message.error("查询信息失败！");
      // }
      // console.log(res.data);
      // this.editForm = res.data; // 对象复制
      this.orderDetailDialogVisible = true;
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
