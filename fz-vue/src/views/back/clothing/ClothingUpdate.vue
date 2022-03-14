<template> 
  <clothing-detail :is-edit='true' class="clothing-detail-css"></clothing-detail>
</template>
<script>
  import ClothingDetail from './components/ClothingDetail'
  export default {
    name: 'updateClothing',
    components: { ClothingDetail }
  }
</script>
<style>
</style>
