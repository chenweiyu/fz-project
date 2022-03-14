<template>
  <div>
    <el-card>
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: '//backHome/clothingTable' }"
          >服装管理</el-breadcrumb-item
        >
        <el-breadcrumb-item v-show="isEdit">修改服装类别</el-breadcrumb-item>
        <el-breadcrumb-item v-show="!isEdit">添加服装类别</el-breadcrumb-item>
      </el-breadcrumb>
      <!-- 2.1 顶部操作 -->
      <br />
      <el-card class="form-container" shadow="never">
        <el-form
          :model="clothingCate"
          :rules="rules"
          ref="clothingCateFrom"
          label-width="150px"
        >
          <el-form-item label="分类名称：" prop="name">
            <el-input v-model="clothingCate.name"></el-input>
          </el-form-item>
          <el-form-item label="上级分类：">
            <el-select v-model="clothingCate.parentId" placeholder="请选择分类">
              <el-option
                v-for="item in selectClothingCateList"
                :key="item.id"
                :label="item.name"
                :value="item.id"
              >
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="数量单位：">
            <el-input v-model="clothingCate.clothingUnit"></el-input>
          </el-form-item>
          <el-form-item label="排序：">
            <el-input v-model="clothingCate.sort"></el-input>
          </el-form-item>
          <el-form-item label="是否显示：">
            <el-radio-group v-model="clothingCate.showStatus">
              <el-radio :label="1">是</el-radio>
              <el-radio :label="0">否</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="是否显示在导航栏：">
            <el-radio-group v-model="clothingCate.navStatus">
              <el-radio :label="1">是</el-radio>
              <el-radio :label="0">否</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="分类图标：">
            <single-upload v-model="clothingCate.icon"></single-upload>
          </el-form-item>
          <el-form-item
            v-for="(filterClothingAttr, index) in filterClothingAttrList"
            :label="index | filterLabelFilter"
            :key="filterClothingAttr.key"
          >
            <el-cascader
              clearable
              v-model="filterClothingAttr.value"
              :options="filterAttrs"
            >
            </el-cascader>
            <el-button
              style="margin-left: 20px"
              @click.prevent="removeFilterAttr(filterClothingAttr)"
              >删除</el-button
            >
          </el-form-item>
          <el-form-item>
            <el-button
              size="small"
              type="primary"
              @click="handleAddFilterAttr()"
              >新增</el-button
            >
          </el-form-item>
          <el-form-item label="关键词：">
            <el-input v-model="clothingCate.keywords"></el-input>
          </el-form-item>
          <el-form-item label="分类描述：">
            <el-input
              type="textarea"
              :autosize="true"
              v-model="clothingCate.description"
            ></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit('clothingCateFrom')"
              >提交</el-button
            >
            <el-button v-if="!isEdit" @click="resetForm('clothingCateFrom')"
              >重置</el-button
            >
          </el-form-item>
        </el-form>
      </el-card>
    </el-card>
  </div>
</template>

<script>
import {
  fetchList,
  createClothingCate,
  updateClothingCate,
  getClothingCate,
} from "@/api/clothingCate";
import { fetchListWithAttr } from "@/api/clothingAttrCate";
import { getClothingAttrInfo } from "@/api/clothingAttr";
import SingleUpload from "@/components/Upload/singleUpload";

const defaultClothingCate = {
  description: "",
  icon: "",
  keywords: "",
  name: "",
  navStatus: 0,
  parentId: 0,
  clothingUnit: "",
  showStatus: 0,
  sort: 0,
  clothingAttributeIdList: [],
};
export default {
  name: "ClothingCateDetail",
  components: { SingleUpload },
  props: {
    isEdit: {
      type: Boolean,
      default: false,
    },
  },
  data() {
    return {
      clothingCate: Object.assign({}, defaultClothingCate),
      selectClothingCateList: [],
      rules: {
        name: [
          { required: true, message: "请输入品牌名称", trigger: "blur" },
          {
            min: 2,
            max: 140,
            message: "长度在 2 到 140 个字符",
            trigger: "blur",
          },
        ],
      },
      filterAttrs: [],
      filterClothingAttrList: [
        {
          value: [],
        },
      ],
    };
  },
  created() {
    if (this.isEdit) {
      getClothingCate(this.$route.query.id).then((response) => {
        this.clothingCate = response.data;
      });
      getClothingAttrInfo(this.$route.query.id).then((response) => {
        if (response.data != null && response.data.length > 0) {
          this.filterClothingAttrList = [];
          for (let i = 0; i < response.data.length; i++) {
            this.filterClothingAttrList.push({
              key: Date.now() + i,
              value: [
                response.data[i].attributeCategoryId,
                response.data[i].attributeId,
              ],
            });
          }
        }
      });
    } else {
      this.clothingCate = Object.assign({}, defaultClothingCate);
    }
    this.getSelectClothingCateList();
    this.getClothingAttrCateList();
  },
  methods: {
    getSelectClothingCateList() {
      fetchList(0, { pageSize: 100, pageNum: 1 }).then((response) => {
        this.selectClothingCateList = response.data.list;
        this.selectClothingCateList.unshift({ id: 0, name: "无上级分类" });
      });
    },
    getClothingAttrCateList() {
      fetchListWithAttr().then((response) => {
        let list = response.data;
        for (let i = 0; i < list.length; i++) {
          let clothingAttrCate = list[i];
          let children = [];
          if (
            clothingAttrCate.clothingAttributeList != null &&
            clothingAttrCate.clothingAttributeList.length > 0
          ) {
            for (
              let j = 0;
              j < clothingAttrCate.clothingAttributeList.length;
              j++
            ) {
              children.push({
                label: clothingAttrCate.clothingAttributeList[j].name,
                value: clothingAttrCate.clothingAttributeList[j].id,
              });
            }
          }
          this.filterAttrs.push({
            label: clothingAttrCate.name,
            value: clothingAttrCate.id,
            children: children,
          });
        }
      });
    },
    getClothingAttributeIdList() {
      //获取选中的筛选商品属性
      let clothingAttributeIdList = [];
      for (let i = 0; i < this.filterClothingAttrList.length; i++) {
        let item = this.filterClothingAttrList[i];
        if (item.value !== null && item.value.length === 2) {
          clothingAttributeIdList.push(item.value[1]);
        }
      }
      return clothingAttributeIdList;
    },
    onSubmit(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$confirm("是否提交数据", "提示", {
            confirmButtonText: "确定",
            cancelButtonText: "取消",
            type: "warning",
          }).then(() => {
            if (this.isEdit) {
              this.clothingCate.clothingAttributeIdList =
                this.getClothingAttributeIdList();
              updateClothingCate(this.$route.query.id, this.clothingCate).then(
                (response) => {
                  this.$message({
                    message: "修改成功",
                    type: "success",
                    duration: 1000,
                  });
                  this.$router.back();
                }
              );
            } else {
              this.clothingCate.clothingAttributeIdList =
                this.getClothingAttributeIdList();
              createClothingCate(this.clothingCate).then((response) => {
                this.$refs[formName].resetFields();
                this.resetForm(formName);
                this.$message({
                  message: "提交成功",
                  type: "success",
                  duration: 1000,
                });
              });
            }
          });
        } else {
          this.$message({
            message: "验证失败",
            type: "error",
            duration: 1000,
          });
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
      this.clothingCate = Object.assign({}, defaultClothingCate);
      this.getSelectClothingCateList();
      this.filterClothingAttrList = [
        {
          value: [],
        },
      ];
    },
    removeFilterAttr(clothingAttributeId) {
      if (this.filterClothingAttrList.length === 1) {
        this.$message({
          message: "至少要留一个",
          type: "warning",
          duration: 1000,
        });
        return;
      }
      var index = this.filterClothingAttrList.indexOf(clothingAttributeId);
      if (index !== -1) {
        this.filterClothingAttrList.splice(index, 1);
      }
    },
    handleAddFilterAttr() {
      if (this.filterClothingAttrList.length === 3) {
        this.$message({
          message: "最多添加三个",
          type: "warning",
          duration: 1000,
        });
        return;
      }
      this.filterClothingAttrList.push({
        value: null,
        key: Date.now(),
      });
    },
  },
  filters: {
    filterLabelFilter(index) {
      if (index === 0) {
        return "筛选属性：";
      } else {
        return "";
      }
    },
  },
};
</script>

<style scoped>
.form-container {
  width: 720px;
  padding: 35px 35px 15px 35px;
  margin-top: 20px;
  margin-bottom: 20px;
  margin-left: 15%;
}
</style>
