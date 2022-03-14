<template>
  <div style="margin-top: 50px">
    <el-form :model="value"
             ref="clothingRelationForm"
             label-width="120px"
             style="width: 800px"
             size="small">
      <el-form-item label="关联专题：">
        <el-transfer
          style="display: inline-block;"
          filterable
          :filter-method="filterMethod"
          filter-placeholder="请输入专题名称"
          v-model="selectSubject"
          :titles="subjectTitles"
          :data="subjectList">
        </el-transfer>
      </el-form-item>
      <el-form-item label="关联优选：">
        <el-transfer
          style="display: inline-block"
          filterable
          :filter-method="filterMethod"
          filter-placeholder="请输入优选名称"
          v-model="selectPrefrenceArea"
          :titles="prefrenceAreaTitles"
          :data="prefrenceAreaList">
        </el-transfer>
      </el-form-item>
      <el-form-item style="text-align: center">
        <el-button size="medium" @click="handlePrev">上一步，填写商品属性</el-button>
        <el-button type="primary" size="medium" @click="handleFinishCommit">完成，提交商品</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  import {fetchListAll as fetchSubjectList} from '@/api/subject'
  import {fetchList as fetchPrefrenceAreaList} from '@/api/prefrenceArea'

  export default {
    name: "ClothingRelationDetail",
    props: {
      value: Object,
      isEdit: {
        type: Boolean,
        default: false
      }
    },
    data() {
      return {
        //所有专题列表
        subjectList: [],
        //专题左右标题
        subjectTitles: ['待选择', '已选择'],
        //所有专题列表
        prefrenceAreaList: [],
        //专题左右标题
        prefrenceAreaTitles: ['待选择', '已选择']
      };
    },
    created() {
      // this.getSubjectList();
      // this.getPrefrenceAreaList();
    },
    computed:{
      //选中的专题
      selectSubject:{
        get:function () {
          let subjects =[];
          if(this.value.subjectClothingRelationList==null||this.value.subjectClothingRelationList.length<=0){
            return subjects;
          }
          for(let i=0;i<this.value.subjectClothingRelationList.length;i++){
            subjects.push(this.value.subjectClothingRelationList[i].subjectId);
          }
          return subjects;
        },
        set:function (newValue) {
          this.value.subjectClothingRelationList=[];
          for(let i=0;i<newValue.length;i++){
            this.value.subjectClothingRelationList.push({subjectId:newValue[i]});
          }
        }
      },
      //选中的优选
      selectPrefrenceArea:{
        get:function () {
          let prefrenceAreas =[];
          if(this.value.prefrenceAreaClothingRelationList==null||this.value.prefrenceAreaClothingRelationList.length<=0){
            return prefrenceAreas;
          }
          for(let i=0;i<this.value.prefrenceAreaClothingRelationList.length;i++){
            prefrenceAreas.push(this.value.prefrenceAreaClothingRelationList[i].prefrenceAreaId);
          }
          return prefrenceAreas;
        },
        set:function (newValue) {
          this.value.prefrenceAreaClothingRelationList=[];
          for(let i=0;i<newValue.length;i++){
            this.value.prefrenceAreaClothingRelationList.push({prefrenceAreaId:newValue[i]});
          }
        }
      }
    },
    methods: {
      filterMethod(query, item) {
        return item.label.indexOf(query) > -1;
      },
      getSubjectList() {
        fetchSubjectList().then(response => {
          let list = response.data;
          for (let i = 0; i < list.length; i++) {
            this.subjectList.push({
              label: list[i].title,
              key: list[i].id
            });
          }
        });
      },
      getPrefrenceAreaList() {
        fetchPrefrenceAreaList().then(response=>{
          let list = response.data;
          for (let i = 0; i < list.length; i++) {
            this.prefrenceAreaList.push({
              label: list[i].name,
              key: list[i].id
            });
          }
        });
      },
      handlePrev(){
        this.$emit('prevStep')
      },
      handleFinishCommit(){
        this.$emit('finishCommit',this.isEdit);
      }
    }
  }
</script>

<style scoped>

</style>
