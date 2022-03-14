<template>
  <div>
    <el-card>
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: '/backHome/clothingTable' }"
          >服装管理</el-breadcrumb-item
        >
        <el-breadcrumb-item v-show="!isEdit">添加服装</el-breadcrumb-item>
        <el-breadcrumb-item v-show="isEdit">编辑服装</el-breadcrumb-item>
      </el-breadcrumb>
      <!-- 2.1 顶部操作 -->
      <br />
      <el-card class="form-container" shadow="never">
        <el-steps :active="active" finish-status="success" align-center>
          <el-step title="填写商品信息"></el-step>
          <el-step title="填写商品促销"></el-step>
          <el-step title="填写商品属性"></el-step>
          <el-step title="选择商品关联"></el-step>
        </el-steps>
        <clothing-info-detail
          v-show="showStatus[0]"
          v-model="clothingParam"
          :is-edit="isEdit"
          @nextStep="nextStep"
        >
        </clothing-info-detail>
        <clothing-sale-detail
          v-show="showStatus[1]"
          v-model="clothingParam"
          :is-edit="isEdit"
          @nextStep="nextStep"
          @prevStep="prevStep"
        >
        </clothing-sale-detail>
        <clothing-attr-detail
          v-show="showStatus[2]"
          v-model="clothingParam"
          :is-edit="isEdit"
          @nextStep="nextStep"
          @prevStep="prevStep"
        >
        </clothing-attr-detail>
        <clothing-relation-detail
          v-show="showStatus[3]"
          v-model="clothingParam"
          :is-edit="isEdit"
          @prevStep="prevStep"
          @finishCommit="finishCommit"
        >
        </clothing-relation-detail>
      </el-card>
    </el-card>
  </div>
</template>
<script>
import ClothingInfoDetail from "./ClothingInfoDetail";
import ClothingSaleDetail from "./ClothingSaleDetail";
import ClothingAttrDetail from "./ClothingAttrDetail";
import ClothingRelationDetail from "./ClothingRelationDetail";
import { createClothing, getClothing, updateClothing } from "@/api/clothing";

const defaultClothingParam = {
  albumPics: "",
  brandId: null,
  brandName: "",
  deleteStatus: 0,
  description: "",
  detailDesc: "",
  detailHtml: "",
  detailMobileHtml: "",
  detailTitle: "",
  feightTemplateId: 0,
  flashPromotionCount: 0,
  flashPromotionId: 0,
  flashPromotionPrice: 0,
  flashPromotionSort: 0,
  giftPoint: 0,
  giftGrowth: 0,
  keywords: "",
  lowStock: 0,
  name: "",
  newStatus: 0,
  note: "",
  originalPrice: 0,
  pic: "",
  //会员价格{memberLevelId: 0,memberPrice: 0,memberLevelName: null}
  memberPriceList: [],
  //商品满减
  clothingFullReductionList: [{ fullPrice: 0, reducePrice: 0 }],
  //商品阶梯价格
  clothingLadderList: [{ count: 0, discount: 0, price: 0 }],
  previewStatus: 0,
  price: 0,
  clothingAttributeCategoryId: null,
  //商品属性相关{clothingAttributeId: 0, value: ''}
  clothingAttributeValueList: [],
  //商品sku库存信息{lowStock: 0, pic: '', price: 0, sale: 0, skuCode: '', spData: '', stock: 0}
  skuStockList: [],
  //商品相关专题{subjectId: 0}
  subjectClothingRelationList: [],
  //商品相关优选{prefrenceAreaId: 0}
  prefrenceAreaClothingRelationList: [],
  clothingCategoryId: null,
  clothingCategoryName: "",
  clothingSn: "",
  promotionEndTime: "",
  promotionPerLimit: 0,
  promotionPrice: null,
  promotionStartTime: "",
  promotionType: 0,
  publishStatus: 0,
  recommandStatus: 0,
  sale: 0,
  serviceIds: "",
  sort: 0,
  stock: 0,
  subTitle: "",
  unit: "",
  usePointLimit: 0,
  verifyStatus: 0,
  weight: 0,
};
export default {
  name: "ClothingDetail",
  components: {
    ClothingInfoDetail,
    ClothingSaleDetail,
    ClothingAttrDetail,
    ClothingRelationDetail,
  },
  props: {
    isEdit: {
      type: Boolean,
      default: false,
    },
  },
  data() {
    return {
      active: 0,
      clothingParam: Object.assign({}, defaultClothingParam),
      showStatus: [true, false, false, false],
    };
  },
  created() {
    if (this.isEdit) {
      getClothing(this.$route.query.id).then((response) => {
        this.clothingParam = response.data;
      });
    }
  },
  methods: {
    hideAll() {
      for (let i = 0; i < this.showStatus.length; i++) {
        this.showStatus[i] = false;
      }
    },
    prevStep() {
      if (this.active > 0 && this.active < this.showStatus.length) {
        this.active--;
        this.hideAll();
        this.showStatus[this.active] = true;
      }
    },
    nextStep() {
      if (this.active < this.showStatus.length - 1) {
        this.active++;
        this.hideAll();
        this.showStatus[this.active] = true;
      }
    },
    finishCommit(isEdit) {
      this.$confirm("是否要提交该产品", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        if (isEdit) {
          console.log("this.clothingParam", this.clothingParam);
          updateClothing(this.$route.query.id, this.clothingParam).then(
            (response) => {
              this.$message({
                type: "success",
                message: "提交成功",
                duration: 1000,
              });
              this.$router.back();
            }
          );
        } else {
          createClothing(this.clothingParam).then((response) => {
            this.$message({
              type: "success",
              message: "提交成功",
              duration: 1000,
            });
            location.reload();
          });
        }
      });
    },
  },
};
</script>
<style>
/* .form-container {
    width: 800px;
  } */

.form-container {
  /* position: absolute; */
  /* left: 0;
  right: 0; */
  width: 800px;
  padding: 35px 35px 15px 35px;
  margin-top: 20px;
  margin-bottom: 20px;
  margin-left: 10%;
}
</style>


