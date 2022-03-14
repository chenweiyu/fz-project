<template> 
  <clothing-detail :is-edit='false'></clothing-detail>
</template>
<script>
  import ClothingDetail from './components/ClothingDetail'
  export default {
    name: 'clothingAdd',
    components: { ClothingDetail }
  }
</script>
<style>
</style>
