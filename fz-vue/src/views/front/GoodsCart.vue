<template>
  <section id="portfolio-details" class="portfolio-details">
    <div class="container">
      <el-page-header @back="goBack" content="我的购物车"> </el-page-header>
      <el-card class="operate-container" shadow="never">
        <i class="el-icon-tickets"></i>
        <span>数据列表</span>
        <div style="float: right">
          <span>批量操作：</span>
          <el-button @click="handleDeleteIds()" size="mini" type="danger">
            移除商品
          </el-button>
        </div>
      </el-card>
      <el-table
        :data="list"
        class="goodCart-table"
        @select="changeGoods"
        @select-all="changeAllGoods"
        @selection-change="handleSelectionChange"
      >
        <el-table-column type="selection" width="55"> </el-table-column>
        <el-table-column label="服装商品" width="120" align="center"
          ><template slot-scope="scope">
            <img
              :src="scope.row.clothingList.pic"
              width="100"
              height="100"
              class="head_pic"
            />
          </template>
        </el-table-column>
        <el-table-column prop="clothingList.name" width="380">
        </el-table-column>
        <el-table-column
          prop="clothingList.priceStr"
          label="商品单价"
          width="120"
          align="center"
        >
        </el-table-column>
        <el-table-column label="数量" width="160" align="center">
          <template slot-scope="scope">
            <el-input-number
              v-model="scope.row.clothingCartList.clothingNum"
              controls-position="right"
              @change="handleChange(scope.$index, scope.row)"
              :min="1"
              :max="100"
              size="mini"
              :disabled="selectedCount"
            ></el-input-number>
          </template>
        </el-table-column>
        <el-table-column
          prop="clothingCartList.paymentStr"
          label="支付金额"
          width="120"
          align="center"
        >
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
                @click="handleDeleteSingle(scope.row)"
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
                @click="goodsDetail(scope.row)"
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
            <el-button type="success" size="medium" round @click="settlement"
              >结算</el-button
            >
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
        <div style="margin-left: 5px">
          <span class="other-mess-2">数量</span>共&nbsp;<el-input-number
            v-model="orderClothingNum"
            size="mini"
            @change="handleChangeNum(1)"
            :min="1"
            :max="100"
            label="描述文字"
          ></el-input-number
          >&nbsp;件
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
        <div class="order-remark">
          <div>订单备注</div>
          <br />
          <div>
            <el-input
              type="textarea"
              v-model="orderRemark"
              placeholder="输入订单信息"
            ></el-input>
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
      <el-dialog
        title="支付界面"
        :visible.sync="paydialogVisible"
        width="30%"
        :before-close="cancelPaydialog"
      >
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
          <el-button @click="cancelPaydialog">取 消</el-button>
          <el-button type="warning" @click="paydialog">确 定 支 付</el-button>
        </span>
      </el-dialog>

      <!-- 批量提交订单 -->
      <el-dialog
        title="确认订单"
        :visible.sync="submitBatchOrderDialogVisible"
        width="35%"
      >
        <div v-for="(order, index) in batchOrders" :key="index">
          <hr class="line" v-if="index === 0" />
          <hr class="line1" v-else />
          <div class="row">
            <div class="col-lg-3">
              <img class="buy-img" :src="order.clothing.pic" alt="" />
            </div>
            <div class="col-lg-9">
              <div>
                <span class="batch-buy-clothingname">{{
                  order.clothing.name
                }}</span>
                <span class="buy-clothingPrice"
                  >￥{{ order.clothing.price }}</span
                >
              </div>
              <div
                class="batch-buy-clothingSize"
                style="margin: 10px 0"
                v-if="order.selectClothingAttr.length"
              >
                颜色：{{
                  order.selectClothingAttr[0].values
                }}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;尺码：{{
                  order.selectClothingAttr[1].values
                }}码
              </div>
              <div>
                <span class="batch-other-mess-1">配送方式</span>顺丰 | 圆通 |
                中通 | 韵达
              </div>
            </div>
          </div>
          <div class="row receive-location">
            <div class="col-lg-1">
              <i class="el-icon-map-location icon-locate"></i>
            </div>
            <div class="col-lg-10">
              <span class="location-span">{{ order.receiverAddress }}</span>
              <div>
                <span class="username-span"
                  >{{ order.receiver.receiverName }}&nbsp;&nbsp;{{
                    order.receiver.receiverPhone
                  }}</span
                >
              </div>
            </div>
            <div class="col-lg-1 icon-css">
              <a href="#" @click="alterBatchOrderAddr(index)"
                ><i class="el-icon-arrow-right"></i
              ></a>
            </div>
          </div>
          <div class="other-mess">
            <span class="other-mess-1">配送服务</span>快递&nbsp;免邮
            <span class="batch-other-mess-2">数量</span>共&nbsp;<el-input-number
              v-model="order.clothingCart.clothingNum"
              size="mini"
              @change="handleBatchOrderNum(index)"
              :min="1"
              :max="100"
              label="描述文字"
            ></el-input-number
            >&nbsp;件
          </div>
          <div class="clothing-size">
            <div
              v-for="(clothingAttr, idx) in order.selectClothingAttr"
              :key="idx"
            >
              <span class="clothing-size-1"> {{ clothingAttr.name }}： </span>
              <el-radio-group
                v-if="clothingAttr.handAddStatus === 0"
                v-model="order.selectClothingAttr[idx].values"
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
                v-model="order.selectClothingAttr[idx].values"
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
          <div class="order-remark">
            <div>订单备注</div>
            <br />
            <div>
              <el-input
                type="textarea"
                v-model="order.remark"
                placeholder="输入订单信息"
              ></el-input>
            </div>
          </div>
          <span class="sumPrice">合计：</span>￥<span class="sumPrice-1">{{
            order.clothingCart.orderSumPrice
          }}</span>
        </div>
        <span slot="footer" class="dialog-footer">
          <span class="batch-sumPrice" style="font-size: 12px"
            >总计：￥<span class="batch-sumPrice-1">{{
              batchOrdersSumPrice
            }}</span></span
          >
          <el-button @click="submitBatchOrderDialogVisible = false"
            >取 消</el-button
          >
          <el-button type="warning" @click="submitBatchOrder"
            >提交所有订单</el-button
          >
        </span>

        <el-dialog
          width="50%"
          title="收货人信息"
          :visible.sync="innerAlterBatchOrderAddrVisible"
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
            <el-button @click="innerAlterBatchOrderAddrVisible = false"
              >取 消</el-button
            >
            <el-button type="warning" @click="accurateBatchAddr"
              >确定</el-button
            >
          </span>
        </el-dialog>
      </el-dialog>
    </div>
  </section>
</template>

<script>
import { mapGetters, mapMutations, mapActions } from "vuex";
import { deleteCartIds } from "@/api/clothingCart";
import { fetchList as fetchClothingAttrList } from "@/api/clothingAttr";
import { getClothing } from "@/api/clothing";
import {
  createOrder,
  updatepayInfo,
  createOrderBatch,
  updatepayInfoList,
} from "@/api/order";
import VDistpicker from "v-distpicker";
export default {
  name: "GoodCart",
  data() {
    return {
      total: 0,
      queryInfo: {
        userId: null,
        query: "",
        pagenum: 1,
        pagesize: 10,
      },
      clothing: {},
      selectClothingAttr: [],
      receiverAddress: "",
      receiver: {},
      deliveryCompany: "顺丰快递  |  圆通快递  |  中通快递  |  韵达快递",
      order: {
        userId: null,
        memberUsername: "",
        totalAmount: null,
        payAmount: null,
        payType: 0,
        sourceType: 0,
        status: 0,
        orderType: 0,
        deliveryCompany: "",
        autoConfirmDay: 15,
        integration: 5,
        growth: 20,
        promotionInfo: "无",
        receiverName: "",
        receiverPhone: "",
        receiverPostCode: 528400,
        receiverProvince: "",
        receiverCity: "",
        receiverRegion: "",
        receiverDetailAddress: "",
        note: "",
        deleteStatus: 0,
        clothingId: null,
      },
      payType: null,
      orderClothingNum: 1,
      orderRemark: "",
      orderClothingSum: 0,
      selectedCount: false,
      innerAlterAddrVisible: false,
      goods: {},
      radio: "M",
      submitOrderDialogVisible: false,
      paydialogVisible: false,
      submitBatchOrderDialogVisible: false,
      innerAlterBatchOrderAddrVisible: false,
      alterAddrForm: {
        receiver: "",
        receiverPhone: "",
        receiverAddrProvince: "",
        receiverAddrCity: "",
        receiverAddrStreet: "",
        receiverAddrDetail: "",
      },
      goodsNum: 1,
      goodsSum: 0,
      buyGoodsSum: 0,
      goodsPrice: 0,
      list: [],
      multipleSelection: [],
      batchOrders: [],
      batchOrdersSumPrice: 0,
      batchId: null,
      orderIds: null,
      isPayOrPayBatch: false,
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

  computed: {},

  created() {
    let user = JSON.parse(localStorage.getItem("userInfo"));
    this.queryInfo.userId = user.userId;
    this.getClothingCartList();
  },

  methods: {
    ...mapMutations([]),

    ...mapActions([
      "getClothingCart",
      "deleteClothingCartIds",
      "deleteClothingCartId",
    ]),

    goBack() {
      window.history.back();
    },

    getClothingCartList() {
      this.getClothingCart(this.queryInfo).then((res) => {
        let resList = this.$store.state.cart.clothingCart;
        this.list = resList.list;
        for (let i = 0; i < this.list.length; i++) {
          this.list[i].clothingCartList.payment =
            this.list[i].clothingCartList.clothingNum *
            this.list[i].clothingList.price;
          this.list[i].clothingList.priceStr =
            "￥" + this.list[i].clothingList.price + "元";
          this.list[i].clothingCartList.paymentStr =
            "￥" + this.list[i].clothingCartList.payment + "元";
        }
        this.total = resList.total;
      });
      // fetchList(this.queryInfo).then((response) => {
      //   this.list = response.data.list;
      //   for (let i = 0; i < this.list.length; i++) {
      //     this.list[i].clothingCartList.payment = this.list[i].clothingCartList.clothingNum * this.list[i].clothingList.price;
      //     this.list[i].clothingList.priceStr = "￥" + this.list[i].clothingList.price + "元";
      //     this.list[i].clothingCartList.paymentStr = "￥" + this.list[i].clothingCartList.payment + "元";
      //   }
      //   this.total = response.data.total;
      // });
    },
    getClothingAttrList(type, cid, clothingColor, clothingSize, clothing) {
      let param = { pageNum: 1, pageSize: 100, type: type };
      let selectClothingAttr = [];
      fetchClothingAttrList(cid, param).then((response) => {
        let list = response.data.list;
        for (let i = 0; i < list.length; i++) {
          let options = [];
          if (list[i].handAddStatus === 1 || list[i].handAddStatus === 0) {
            //编辑状态下获取手动添加编辑属性
            options = this.getEditAttrOptions(list[i].id, clothing);
          }
          //编辑状态下获取选中属性
          selectClothingAttr.push({
            id: list[i].id,
            name: list[i].name,
            handAddStatus: list[i].handAddStatus,
            inputList: list[i].inputList,
            options: options,
            values: "",
          });
        }
        selectClothingAttr[0].values = clothingColor;
        selectClothingAttr[1].values = clothingSize;
      });
      return selectClothingAttr;
    },
    getEditAttrOptions(id, clothing) {
      let options = [];
      for (let i = 0; i < clothing.clothingAttributeValueList.length; i++) {
        let attrValue = clothing.clothingAttributeValueList[i];
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
    accurateBatchAddr() {
      this.batchOrders[this.batchId].receiverAddress = this.mergeAddress(
        this.alterAddrForm.receiverAddrProvince,
        this.alterAddrForm.receiverAddrCity,
        this.alterAddrForm.receiverAddrStreet,
        this.alterAddrForm.receiverAddrDetail
      );
      this.batchOrders[this.batchId].receiver.receiverProvince =
        this.alterAddrForm.receiverAddrProvince;
      this.batchOrders[this.batchId].receiver.receiverCity =
        this.alterAddrForm.receiverAddrCity;
      this.batchOrders[this.batchId].receiver.receiverRegion =
        this.alterAddrForm.receiverAddrStreet;
      this.batchOrders[this.batchId].receiver.receiverDetailAddress =
        this.alterAddrForm.receiverAddrDetail;
      this.batchOrders[this.batchId].receiver.receiverName =
        this.alterAddrForm.receiver;
      this.batchOrders[this.batchId].receiver.receiverPhone =
        this.alterAddrForm.receiverPhone;
      this.innerAlterBatchOrderAddrVisible = false;
    },
    mergeAddress(province, city, region, detailAddr) {
      return province + city + region + detailAddr;
    },
    handleChangeNum(index) {
      if (index === 0) {
        this.cartClothingSum = this.clothingNum * this.clothing.price;
        this.cartClothingSum = this.cartClothingSum.toFixed(1);
      } else {
        this.orderClothingSum = this.orderClothingNum * this.clothing.price;
        this.orderClothingSum = this.orderClothingSum.toFixed(1);
      }
    },
    handleBatchOrderNum(index) {
      this.batchOrdersSumPrice -= parseFloat(
        this.batchOrders[index].clothingCart.orderSumPrice
      );
      this.batchOrders[index].clothingCart.orderSumPrice =
        this.batchOrders[index].clothingCart.clothingNum *
        this.batchOrders[index].clothing.price;
      this.batchOrdersSumPrice +=
        this.batchOrders[index].clothingCart.orderSumPrice;
      this.batchOrders[index].clothingCart.orderSumPrice =
        this.batchOrders[index].clothingCart.orderSumPrice.toFixed(1);
    },
    onSelectRegion(data) {
      this.alterAddrForm.receiverAddrProvince = data.province.value;
      this.alterAddrForm.receiverAddrCity = data.city.value;
      this.alterAddrForm.receiverAddrStreet = data.area.value;
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

    async buyDialogVisible(id) {
      await getClothing(this.list[id].clothingList.id).then((response) => {
        this.clothing = response.data;
        this.selectClothingAttr = this.getClothingAttrList(
          0,
          this.clothing.clothingAttributeCategoryId,
          this.list[id].clothingCartList.clothingColor,
          this.list[id].clothingCartList.clothingSize,
          this.clothing
        );
        this.serviceId = this.getServiceList();
      });
      this.orderClothingNum = this.list[id].clothingCartList.clothingNum;
      this.handleChangeNum(1);
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

    submitOrder() {
      let user = JSON.parse(localStorage.getItem("userInfo"));
      this.order.userId = user.userId;
      this.order.memberUsername = user.username;
      this.order.totalAmount = this.orderClothingSum;
      this.order.payAmount = this.orderClothingSum;
      this.order.sourceType = 0;
      this.order.orderType = 0;
      this.order.deliveryCompany = this.deliveryCompany;
      this.order.receiverName = this.receiver.receiverName;
      this.order.receiverPhone = this.receiver.receiverPhone;
      this.order.receiverProvince = this.receiver.receiverProvince;
      this.order.receiverCity = this.receiver.receiverCity;
      this.order.receiverRegion = this.receiver.receiverRegion;
      this.order.receiverDetailAddress = this.receiver.receiverDetailAddress;
      this.order.note = this.orderRemark;
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
      this.isPayOrPayBatch = false;
      this.paydialogVisible = true;
    },

    submitBatchOrder() {
      let order = {};
      let batchOrder = [];
      let user = JSON.parse(localStorage.getItem("userInfo"));
      for (let i = 0; i < this.batchOrders.length; i++) {
        order.userId = user.userId;
        order.memberUsername = user.username;
        order.totalAmount = this.batchOrders[i].clothingCart.clothingNum;
        order.payAmount = this.batchOrders[i].clothingCart.orderSumPrice;
        order.payType = 0;
        order.sourceType = 0;
        order.status = 0;
        order.orderType = 0;
        order.deliveryCompany = this.deliveryCompany;
        order.autoConfirmDay = 15;
        order.integration = 5;
        order.growth = 20;
        order.promotionInfo = "无";
        order.receiverName = this.batchOrders[i].receiver.receiverName;
        order.receiverPhone = this.batchOrders[i].receiver.receiverPhone;
        order.receiverPostCode = 528400;
        order.receiverProvince = this.batchOrders[i].receiver.receiverProvince;
        order.receiverCity = this.batchOrders[i].receiver.receiverCity;
        order.receiverRegion = this.batchOrders[i].receiver.receiverRegion;
        order.receiverDetailAddress =
          this.batchOrders[i].receiver.receiverDetailAddress;
        order.note = this.batchOrders[i].remark;
        order.deleteStatus = 0;
        order.clothingId = this.batchOrders[i].clothing.id;
        let orderParam = {
          order: order,
          clothing: this.batchOrders[i].clothingSubmit,
          orderClothingNum: this.batchOrders[i].clothingCart.clothingNum,
          orderClothingColor: this.batchOrders[i].selectClothingAttr[0].values,
          orderClothingSize: this.batchOrders[i].selectClothingAttr[1].values,
        };
        batchOrder.push(orderParam);
      }
      console.log("batchOrder", batchOrder);
      createOrderBatch(batchOrder).then((response) => {
        console.log("response", response);
        if (response.code === 200) {
          this.orderIds = response.data;
          this.$message({
            message: "订单提交成功，请支付",
            type: "success",
            duration: 1000,
          });
          this.orderId = response.data;
        }
      });
      this.submitBatchOrderDialogVisible = false;
      this.orderClothingSum = this.batchOrdersSumPrice;
      this.isPayOrPayBatch = true;
      this.paydialogVisible = true;
    },

    paydialog() {
      if (this.isPayOrPayBatch === false) {
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
      } else {
        let updatePayOrderList = [];
        for (let i = 0; i < this.batchOrders.length; i++) {
          let updatePayOrder = {};
          updatePayOrder.orderId = this.orderIds[i];
          updatePayOrder.payType = this.payType;
          updatePayOrder.status = 1;
          updatePayOrderList.push(updatePayOrder);
        }
        updatepayInfoList(updatePayOrderList).then((res) => {
          if (res.code === 200) {
            this.$message({
              message: "支付成功",
              type: "success",
              duration: 1000,
            });
            this.paydialogVisible = false;
          }
        });
      }
    },

    cancelPaydialog() {
      this.paydialogVisible = false;
    },

    async settlement() {
      if (this.multipleSelection < 1) {
        this.$message({
          message: "请选择一条记录",
          type: "warning",
          duration: 1000,
        });
        return;
      }
      this.batchOrders = [];
      this.batchOrdersSumPrice = 0;
      for (let i = 0; i < this.multipleSelection.length; i++) {
        let clothing = {};
        let attr = [];
        let order = {};
        await getClothing(this.list[i].clothingList.id).then((response) => {
          clothing = response.data;
          attr = this.getClothingAttrList(
            0,
            this.list[i].clothingList.clothingAttributeCategoryId,
            this.list[i].clothingCartList.clothingColor,
            this.list[i].clothingCartList.clothingSize,
            clothing
          );
          order.clothingSubmit = clothing;
        });
        order.clothing = JSON.parse(JSON.stringify(this.list[i].clothingList));
        order.clothingCart = JSON.parse(
          JSON.stringify(this.list[i].clothingCartList)
        );
        order.selectClothingAttr = attr;
        order.receiver = JSON.parse(
          JSON.stringify(this.$store.state.receiver.receiverList[0])
        );
        order.clothingCart.orderSumPrice = order.clothingCart.payment;
        order.remark = "";
        order.receiverAddress = this.mergeAddress(
          order.receiver.receiverProvince,
          order.receiver.receiverCity,
          order.receiver.receiverRegion,
          order.receiver.receiverDetailAddress
        );
        this.batchOrdersSumPrice += order.clothingCart.orderSumPrice;
        this.batchOrders.push(order);
      }
      console.log("this.batchOrders", this.batchOrders);
      this.submitBatchOrderDialogVisible = true;
    },

    handleChange1() {
      this.buyGoodsSum = this.goodsNum * this.goodsPrice;
      this.buyGoodsSum = this.buyGoodsSum.toFixed(2);
    },

    handleChange(id, row) {
      if (row.clothingCartList.clothingId == this.multipleSelection[id].clothingCartList.clothingId) {
        this.goodsSum = this.goodsSum - this.list[id].clothingCartList.payment;
        this.list[id].clothingCartList.payment =
          this.list[id].clothingCartList.clothingNum *
          this.list[id].clothingList.price;
        this.goodsSum += this.list[id].clothingCartList.payment;

      } else {
        this.list[id].clothingCartList.payment =
          this.list[id].clothingCartList.clothingNum *
          this.list[id].clothingList.price;
      }
      this.list[id].clothingCartList.paymentStr =
        "￥" + this.list[id].clothingCartList.payment + "元";
    },

    goodsDetail(row) {
      this.$router.push({
        path: "/goodsDetail",
        query: { id: row.clothingCartList.clothingId },
      });
    },

    changeGoods(list, row) {
      let selected = list.length && list.indexOf(row) !== -1;
      if (selected == true) {
        this.goodsSum += row.clothingCartList.payment;
        row.clothingCartList.selected = true;
      } else {
        this.goodsSum -= row.clothingCartList.payment;
        row.clothingCartList.selected = false;
      }
    },

    changeAllGoods(list) {
      if (list.length == 0) {
        this.goodsSum = 0;
      } else {
        this.goodsSum = 0;
        for (var i = 0; i < list.length; i++) {
          this.goodsSum += list[i].clothingCartList.payment;
        }
      }
    },

    alterAddr() {
      this.alterAddrForm.receiver = "";
      this.alterAddrForm.receiverPhone = "";
      this.alterAddrForm.receiverAddrProvince = "";
      this.alterAddrForm.receiverAddrCity = "";
      this.alterAddrForm.receiverAddrStreet = "";
      this.alterAddrForm.receiverAddrDetail = "";
      this.innerAlterAddrVisible = true;
    },

    alterBatchOrderAddr(index) {
      this.alterAddrForm.receiver = "";
      this.alterAddrForm.receiverPhone = "";
      this.alterAddrForm.receiverAddrProvince = "";
      this.alterAddrForm.receiverAddrCity = "";
      this.alterAddrForm.receiverAddrStreet = "";
      this.alterAddrForm.receiverAddrDetail = "";
      this.batchId = index;
      this.innerAlterBatchOrderAddrVisible = true;
    },

    handleDeleteSingle(row) {
      this.$confirm("是否要进行批量删除操作?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        let id = row.clothingCartList.id;
        this.deleteClothingCartId(id).then(() => {
          this.getClothingCartList();
          this.$message({
            message: "删除成功",
            type: "success",
            duration: 1500,
          });
        });
      });
    },

    handleDeleteIds() {
      this.$confirm("是否要进行批量删除操作?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        if (this.multipleSelection < 1) {
          this.$message({
            message: "请选择一条记录",
            type: "warning",
            duration: 1000,
          });
          return;
        }
        let ids = [];
        let params = new URLSearchParams();
        for (let i = 0; i < this.multipleSelection.length; i++) {
          ids.push(this.multipleSelection[i].clothingCartList.id);
        }
        params.append("ids", ids);
        this.deleteClothingCartIds(params).then(() => {
          this.getClothingCartList();
          this.$message({
            message: "删除成功",
            type: "success",
            duration: 1500,
          });
        });
      });
    },

    //分页
    handleSelectionChange(val) {
      this.multipleSelection = val;
      console.log(this.multipleSelection);
      for (let i = 0; i < this.multipleSelection.length; i++) {
        console.log(this.list[i]);
      }
    },
    // //分页
    handleSizeChange(val) {
      this.queryInfo.pagesize = val;
      this.getList();
    },
    handleCurrentChange(val) {
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

.operate-container {
  margin-top: 20px;
}

.operate-container .btn-add {
  margin-left: 20px;
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

.line1 {
  margin-top: 30px;
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
  font-size: 18px;
  font-weight: 550;
}

.row .batch-buy-clothingname {
  display: inline-block;
  width: 75%;
  margin-top: 10px;
  font-size: 18px;
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

.row .batch-buy-clothingSize {
  font-size: 14px;
  margin: 10px -1 0 10px;
  color: rgb(250, 127, 127);
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
  margin-left: 12px;
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
  margin-right: 5%;
}

.batch-other-mess-2 {
  margin-left: 15%;
  margin-right: 4%;
}

.order-remark {
  margin: 10px 0 10px 5px;
}

.sumPrice {
  display: inline-block;
  font-size: 13px;
  font-weight: 500;
  margin-left: 65%;
  margin-top: 10px;
}

.bacth-sumPrice {
  font-size: 10px;
  font-weight: 500;
  margin-right: 45%;
}

.sumPrice-1 {
  font-size: 20px;
  font-weight: 500;
  color: #ffce3a;
}

.batch-sumPrice-1 {
  font-size: 20px;
  font-weight: 500;
  color: #57df2e;
}

.address-spacing {
  margin-right: 10px;
}

.carousel-item1 {
  width: 635px;
  height: 380px;
}
</style>
