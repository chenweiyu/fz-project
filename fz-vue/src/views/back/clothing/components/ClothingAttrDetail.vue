<template>
  <div style="margin-top: 50px">
    <el-form :model="value" ref="clothingAttrForm" label-width="120px" style="width: 720px" size="small">
      <el-form-item label="属性类型：">
        <el-select v-model="value.clothingAttributeCategoryId"
                   placeholder="请选择属性类型"
                   @change="handleClothingAttrChange">
          <el-option
            v-for="item in clothingAttributeCategoryOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="商品规格：">
        <el-card shadow="never" class="cardBg">
          <div v-for="(clothingAttr,idx) in selectClothingAttr" :key="idx">
            {{clothingAttr.name}}：
            <el-checkbox-group v-if="clothingAttr.handAddStatus===0" v-model="selectClothingAttr[idx].options">
              <el-checkbox v-for="(item, index) in getInputListArr(clothingAttr.inputList)" :label="item" :key="index"
                           class="littleMarginLeft" @change="changeSelectClothingAttr"></el-checkbox>
            </el-checkbox-group>
            <div v-else>
              <el-checkbox-group v-model="selectClothingAttr[idx].options">
                <div v-for="(item,index) in selectClothingAttr[idx].options" :key="index" style="display: inline-block"
                     class="littleMarginLeft">
                  <el-checkbox :label="item" :key="item"></el-checkbox>
                  <el-button type="text" class="littleMarginLeft" @click="handleRemoveClothingAttrValue(idx,index)">删除
                  </el-button>
                </div>
              </el-checkbox-group>
              <el-input v-model="addClothingAttrValue" style="width: 160px;margin-left: 10px" clearable></el-input>
              <el-button class="littleMarginLeft" @click="handleAddClothingAttrValue(idx)">增加</el-button>
            </div>
          </div>
        </el-card>
        <el-table style="width: 100%;margin-top: 20px"
                  :data="value.skuStockList"
                  border>
          <el-table-column
            v-for="(item,index) in selectClothingAttr"
            :label="item.name"
            :key="item.id"
            align="center">
            <template slot-scope="scope">
              {{getClothingSkuSp(scope.row,index)}}
            </template>
          </el-table-column>
          <el-table-column
            label="销售价格"
            width="80"
            align="center">
            <template slot-scope="scope">
              <el-input v-model="scope.row.price"></el-input>
            </template>
          </el-table-column>
          <el-table-column
            label="商品库存"
            width="80"
            align="center">
            <template slot-scope="scope">
              <el-input v-model="scope.row.stock"></el-input>
            </template>
          </el-table-column>
          <el-table-column
            label="库存预警值"
            width="80"
            align="center">
            <template slot-scope="scope">
              <el-input v-model="scope.row.lowStock"></el-input>
            </template>
          </el-table-column>
          <el-table-column
            label="SKU编号"
            align="center">
            <template slot-scope="scope">
              <el-input v-model="scope.row.skuCode"></el-input>
            </template>
          </el-table-column>
          <el-table-column
            label="操作"
            width="80"
            align="center">
            <template slot-scope="scope">
              <el-button
                type="text"
                @click="handleRemoveClothingSku(scope.$index, scope.row)">删除
              </el-button>
            </template>
          </el-table-column>
        </el-table>
        <el-button
          type="primary"
          style="margin-top: 20px"
          @click="handleRefreshClothingSkuList">刷新列表
        </el-button>
        <el-button
          type="primary"
          style="margin-top: 20px"
          @click="handleSyncClothingSkuPrice">同步价格
        </el-button>
        <el-button
          type="primary"
          style="margin-top: 20px"
          @click="handleSyncClothingSkuStock">同步库存
        </el-button>
      </el-form-item>
      <el-form-item label="属性图片：" v-if="hasAttrPic">
        <el-card shadow="never" class="cardBg">
          <div v-for="(item, index) in selectClothingAttrPics" :key="index">
            <span>{{item.name}}:</span>
            <single-upload v-model="item.pic"
                           style="width: 300px;display: inline-block;margin-left: 10px"></single-upload>
          </div>
        </el-card>
      </el-form-item>
      <el-form-item label="商品参数：">
        <el-card shadow="never" class="cardBg">
          <div v-for="(item,index) in selectClothingParam" :class="{littleMarginTop:index!==0}" :key="index">
            <div class="paramInputLabel">{{item.name}}:</div>
            <el-select v-if="item.inputType===1" class="paramInput" v-model="selectClothingParam[index].value">
              <el-option
                v-for="item in getParamInputList(item.inputList)"
                :key="item"
                :label="item"
                :value="item">
              </el-option>
            </el-select>
            <el-input v-else class="paramInput" v-model="selectClothingParam[index].value"></el-input>
          </div>
        </el-card>
      </el-form-item>
      <el-form-item label="商品相册：">
        <multi-upload v-model="selectClothingPics"></multi-upload>
      </el-form-item>
      <el-form-item label="规格参数：">
        <el-tabs v-model="activeHtmlName" type="card">
          <el-tab-pane label="电脑端详情" name="pc">
            <tinymce :width="595" :height="300" v-model="value.detailHtml"></tinymce>
          </el-tab-pane>
        </el-tabs>
      </el-form-item>
      <el-form-item style="text-align: center">
        <el-button size="medium" @click="handlePrev">上一步，填写商品促销</el-button>
        <el-button type="primary" size="medium" @click="handleNext">下一步，选择商品关联</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  import {fetchList as fetchClothingAttrCateList} from '@/api/clothingAttrCate'
  import {fetchList as fetchClothingAttrList} from '@/api/clothingAttr'
  import SingleUpload from '@/components/Upload/singleUpload'
  import MultiUpload from '@/components/Upload/multiUpload'
  import Tinymce from '@/components/Tinymce'

  export default {
    name: "ClothingAttrDetail",
    components: {SingleUpload, MultiUpload, Tinymce},
    props: {
      value: Object,
      isEdit: {
        type: Boolean,
        default: false
      }
    },
    data() {
      return {
        //编辑模式时是否初始化成功
        hasEditCreated:false,
        //商品属性分类下拉选项
        clothingAttributeCategoryOptions: [],
        //选中的商品属性
        selectClothingAttr: [],
        //选中的商品参数
        selectClothingParam: [],
        //选中的商品属性图片
        selectClothingAttrPics: [],
        //可手动添加的商品属性
        addClothingAttrValue: '',
        //商品富文本详情激活类型
        activeHtmlName: 'pc'
      }
    },
    computed: {
      //是否有商品属性图片
      hasAttrPic() {
        if (this.selectClothingAttrPics.length < 1) {
          return false;
        }
        return true;
      },
      //商品的编号
      clothingId(){
        return this.value.id;
      },
      //商品的主图和画册图片
      selectClothingPics:{
        get:function () {
          let pics=[];
          if(this.value.pic===undefined||this.value.pic==null||this.value.pic===''){
            return pics;
          }
          pics.push(this.value.pic);
          if(this.value.albumPics===undefined||this.value.albumPics==null||this.value.albumPics===''){
            return pics;
          }
          let albumPics = this.value.albumPics.split(',');
          for(let i=0;i<albumPics.length;i++){
            pics.push(albumPics[i]);
          }
          return pics;
        },
        set:function (newValue) {
          if (newValue == null || newValue.length === 0) {
            this.value.pic = null;
            this.value.albumPics = null;
          } else {
            this.value.pic = newValue[0];
            this.value.albumPics = '';
            if (newValue.length > 1) {
              for (let i = 1; i < newValue.length; i++) {
                this.value.albumPics += newValue[i];
                if (i !== newValue.length - 1) {
                  this.value.albumPics += ',';
                }
              }
            }
          }
        }
      }
    },
    created() {
      this.getClothingAttrCateList();
    },
    watch: {
      clothingId:function (newValue) {
        if(!this.isEdit)return;
        if(this.hasEditCreated)return;
        if(newValue===undefined||newValue==null||newValue===0)return;
        this.handleEditCreated();
      }
    },
    methods: {
      changeSelectClothingAttr() {
        console.log("this.selectClothingAttr", this.selectClothingAttr);
      },
      handleEditCreated() {
        //根据商品属性分类id获取属性和参数
        if(this.value.clothingAttributeCategoryId!=null){
          this.handleClothingAttrChange(this.value.clothingAttributeCategoryId);
        }
        this.hasEditCreated=true;
      },
      getClothingAttrCateList() {
        let param = {pageNum: 1, pageSize: 100};
        fetchClothingAttrCateList(param).then(response => {
          this.clothingAttributeCategoryOptions = [];
          let list = response.data.list;
          for (let i = 0; i < list.length; i++) {
            this.clothingAttributeCategoryOptions.push({label: list[i].name, value: list[i].id});
          }
        });
      },
      getClothingAttrList(type, cid) {
        let param = {pageNum: 1, pageSize: 100, type: type};
        fetchClothingAttrList(cid, param).then(response => {
          let list = response.data.list;
          if (type === 0) {
            this.selectClothingAttr = [];
            for (let i = 0; i < list.length; i++) {
              let options = [];
              let values = [];
              if (this.isEdit) {
                if (list[i].handAddStatus === 1 || list[i].handAddStatus === 0) {
                  //编辑状态下获取手动添加编辑属性
                  options = this.getEditAttrOptions(list[i].id);
                }
                //编辑状态下获取选中属性
                values = this.getEditAttrValues(i);
              }
              this.selectClothingAttr.push({
                id: list[i].id,
                name: list[i].name,
                handAddStatus: list[i].handAddStatus,
                inputList: list[i].inputList,
                values: values,
                options: options
              });
            }
            if(this.isEdit){
              //编辑模式下刷新商品属性图片
              this.refreshClothingAttrPics();
            }
          } else {
            this.selectClothingParam = [];
            for (let i = 0; i < list.length; i++) {
              let value=null;
              if(this.isEdit){
                //编辑模式下获取参数属性
                value= this.getEditParamValue(list[i].id);
              }
              this.selectClothingParam.push({
                id: list[i].id,
                name: list[i].name,
                value: value,
                inputType: list[i].inputType,
                inputList: list[i].inputList
              });
            }
          }
          console.log("this.selectClothingAttr1", this.selectClothingAttr);
        });
      },
      //获取设置的可手动添加属性值
      getEditAttrOptions(id) {
        let options = [];
        for (let i = 0; i < this.value.clothingAttributeValueList.length; i++) {
          let attrValue = this.value.clothingAttributeValueList[i];
          if (attrValue.clothingAttributeId === id) {
            if (attrValue.value === "") {
              break;
            }
            let strArr = attrValue.value.split(',');
            for (let j = 0; j < strArr.length; j++) {
              options.push(strArr[j]);
            }
            break;
          }
        }
        return options;
      },
      //获取选中的属性值
      getEditAttrValues(index) {
        let values = new Set();
        if (index === 0) {
          for (let i = 0; i < this.value.skuStockList.length; i++) {
            let sku = this.value.skuStockList[i];
            let spData = JSON.parse(sku.spData);
            if (spData!= null && spData.length>=1) {
              values.add(spData[0].value);
            }
          }
        } else if (index === 1) {
          for (let i = 0; i < this.value.skuStockList.length; i++) {
            let sku = this.value.skuStockList[i];
            let spData = JSON.parse(sku.spData);
            if (spData!= null && spData.length>=2) {
              values.add(spData[1].value);
            }
          }
        } else {
          for (let i = 0; i < this.value.skuStockList.length; i++) {
            let sku = this.value.skuStockList[i];
            let spData = JSON.parse(sku.spData);
            if (spData!= null && spData.length>=3) {
              values.add(spData[2].value);
            }
          }
        }
        return Array.from(values);
      },
      //获取属性的值
      getEditParamValue(id){
        for(let i=0;i<this.value.clothingAttributeValueList.length;i++){
          if(id===this.value.clothingAttributeValueList[i].clothingAttributeId){
            return this.value.clothingAttributeValueList[i].value;
          }
        }
      },
      handleClothingAttrChange(value) {
        console.log("vuale", value);
        this.getClothingAttrList(0, value);
        this.getClothingAttrList(1, value);
      },
      getInputListArr(inputList) {
        return inputList.split(',');
      },
      handleAddClothingAttrValue(idx) {
        let options = this.selectClothingAttr[idx].options;
        if (this.addClothingAttrValue == null || this.addClothingAttrValue == '') {
          this.$message({
            message: '属性值不能为空',
            type: 'warning',
            duration: 1000
          });
          return
        }
        if (options.indexOf(this.addClothingAttrValue) !== -1) {
          this.$message({
            message: '属性值不能重复',
            type: 'warning',
            duration: 1000
          });
          return;
        }
        this.selectClothingAttr[idx].options.push(this.addClothingAttrValue);
        this.addClothingAttrValue = null;
      },
      handleRemoveClothingAttrValue(idx, index) {
        this.selectClothingAttr[idx].options.splice(index, 1);
      },
      getClothingSkuSp(row, index) {
        let spData = JSON.parse(row.spData);
        if(spData!=null&&index<spData.length){
          return spData[index].value;
        }else{
          return null;
        }
      },
      handleRefreshClothingSkuList() {
        this.$confirm('刷新列表将导致sku信息重新生成，是否要刷新', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.refreshClothingAttrPics();
          this.refreshClothingSkuList();
        });
      },
      handleSyncClothingSkuPrice(){
        this.$confirm('将同步第一个sku的价格到所有sku,是否继续', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          if(this.value.skuStockList!==null&&this.value.skuStockList.length>0){
            let tempSkuList = [];
            tempSkuList = tempSkuList.concat(tempSkuList,this.value.skuStockList);
            let price=this.value.skuStockList[0].price;
            for(let i=0;i<tempSkuList.length;i++){
              tempSkuList[i].price=price;
            }
            this.value.skuStockList=[];
            this.value.skuStockList=this.value.skuStockList.concat(this.value.skuStockList,tempSkuList);
          }
        });
      },
      handleSyncClothingSkuStock(){
        this.$confirm('将同步第一个sku的库存到所有sku,是否继续', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          if(this.value.skuStockList!==null&&this.value.skuStockList.length>0){
            let tempSkuList = [];
            tempSkuList = tempSkuList.concat(tempSkuList,this.value.skuStockList);
            let stock=this.value.skuStockList[0].stock;
            let lowStock=this.value.skuStockList[0].lowStock;
            for(let i=0;i<tempSkuList.length;i++){
              tempSkuList[i].stock=stock;
              tempSkuList[i].lowStock=lowStock;
            }
            this.value.skuStockList=[];
            this.value.skuStockList=this.value.skuStockList.concat(this.value.skuStockList,tempSkuList);
          }
        });
      },
      refreshClothingSkuList() {
        this.value.skuStockList = [];
        let skuList = this.value.skuStockList;
        //只有一个属性时
        if (this.selectClothingAttr.length === 1) {
          let attr = this.selectClothingAttr[0];
          for (let i = 0; i < attr.values.length; i++) {
            skuList.push({
              spData: JSON.stringify([{key:attr.name,value:attr.values[i]}])
            });
          }
        } else if (this.selectClothingAttr.length === 2) {
          let attr0 = this.selectClothingAttr[0];
          let attr1 = this.selectClothingAttr[1];
          for (let i = 0; i < attr0.values.length; i++) {
            if (attr1.values.length === 0) {
              skuList.push({
                spData: JSON.stringify([{key:attr0.name,value:attr0.values[i]}])
              });
              continue;
            }
            for (let j = 0; j < attr1.values.length; j++) {
              let spData = [];
              spData.push({key:attr0.name,value:attr0.values[i]});
              spData.push({key:attr1.name,value:attr1.values[j]});
              skuList.push({
                spData: JSON.stringify(spData)
              });
            }
          }
        } else {
          let attr0 = this.selectClothingAttr[0];
          let attr1 = this.selectClothingAttr[1];
          let attr2 = this.selectClothingAttr[2];
          for (let i = 0; i < attr0.values.length; i++) {
            if (attr1.values.length === 0) {
              skuList.push({
                spData: JSON.stringify([{key:attr0.name,value:attr0.values[i]}])
              });
              continue;
            }
            for (let j = 0; j < attr1.values.length; j++) {
              if (attr2.values.length === 0) {
                let spData = [];
                spData.push({key:attr0.name,value:attr0.values[i]});
                spData.push({key:attr1.name,value:attr1.values[j]});
                skuList.push({
                  spData: JSON.stringify(spData)
                });
                continue;
              }
              for (let k = 0; k < attr2.values.length; k++) {
                let spData = [];
                spData.push({key:attr0.name,value:attr0.values[i]});
                spData.push({key:attr1.name,value:attr1.values[j]});
                spData.push({key:attr2.name,value:attr2.values[k]});
                skuList.push({
                  spData: JSON.stringify(spData)
                });
              }
            }
          }
        }
      },
      refreshClothingAttrPics() {
        this.selectClothingAttrPics = [];
        if (this.selectClothingAttr.length >= 1) {
          let values = this.selectClothingAttr[0].values;
          for (let i = 0; i < values.length; i++) {
            let pic=null;
            if(this.isEdit){
              //编辑状态下获取图片
              pic=this.getClothingSkuPic(values[i]);
            }
            this.selectClothingAttrPics.push({name: values[i], pic: pic})
          }
        }
      },
      //获取商品相关属性的图片
      getClothingSkuPic(name){
        for(let i=0;i<this.value.skuStockList.length;i++){
          let spData = JSON.parse(this.value.skuStockList[i].spData);
          if(name===spData[0].value){
            return this.value.skuStockList[i].pic;
          }
        }
        return null;
      },
      //合并商品属性
      mergeClothingAttrValue() {
        this.value.clothingAttributeValueList = [];
        for (let i = 0; i < this.selectClothingAttr.length; i++) {
          let attr = this.selectClothingAttr[i];
          if (attr.handAddStatus === 1 && attr.options != null && attr.options.length > 0) {
            this.value.clothingAttributeValueList.push({
              clothingAttributeId: attr.id,
              value: this.getOptionStr(attr.options)
            });
          }
          if (attr.handAddStatus === 0 && attr.options != null && attr.options.length > 0) {
            this.value.clothingAttributeValueList.push({
              clothingAttributeId: attr.id,
              value: this.getOptionStr(attr.options)
            });
          }
        }
        for (let i = 0; i < this.selectClothingParam.length; i++) {
          let param = this.selectClothingParam[i];
          this.value.clothingAttributeValueList.push({
            clothingAttributeId: param.id,
            value: param.value
          });
        }
      },
      //合并商品属性图片
      mergeClothingAttrPics() {
        for (let i = 0; i < this.selectClothingAttrPics.length; i++) {
          for (let j = 0; j < this.value.skuStockList.length; j++) {
            let spData = JSON.parse(this.value.skuStockList[j].spData);
            if (spData[0].value === this.selectClothingAttrPics[i].name) {
              this.value.skuStockList[j].pic = this.selectClothingAttrPics[i].pic;
            }
          }
        }
      },
      getOptionStr(arr) {
        let str = '';
        for (let i = 0; i < arr.length; i++) {
          str += arr[i];
          if (i != arr.length - 1) {
            str += ',';
          }
        }
        console.log("str", str);
        setTimeout(function() {
          console.log("str", str);
        }, 30000);
        return str;
      },
      handleRemoveClothingSku(index, row) {
        let list = this.value.skuStockList;
        if (list.length === 1) {
          list.pop();
        } else {
          list.splice(index, 1);
        }
      },
      getParamInputList(inputList) {
        return inputList.split(',');
      },
      handlePrev() {
        this.$emit('prevStep')
      },
      handleNext() {
        this.mergeClothingAttrValue();
        this.mergeClothingAttrPics();
        this.$emit('nextStep')
      }
    }
  }
</script>

<style scoped>
  .littleMarginLeft {
    margin-left: 10px;
  }

  .littleMarginTop {
    margin-top: 10px;
  }

  .paramInput {
    width: 250px;
  }

  .paramInputLabel {
    display: inline-block;
    width: 100px;
    text-align: right;
    padding-right: 10px
  }

  .cardBg {
    background: #F8F9FC;
  }
</style>
