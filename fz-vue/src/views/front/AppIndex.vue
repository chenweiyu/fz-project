<template>
  <div>
    <Header @updateKeyword="changeKeyword"></Header>
    <router-view :keyword="keyword"></router-view>
  </div>
</template>

<script>
import Header from "../../components/Header.vue";
export default {
  name: "AppIndex",
  components: { Header },
  data() {
    return {
      keyword: "",
    };
  },

  methods: {
    changeKeyword(msg) {
      this.keyword = msg;
      if (this.keyword == "") {
        if (this.$route.path != "/index") {
          this.$router.push({ path: "/index" });
        }
      } else {
        if (this.$route.path != "/searchResult") {
          this.$router.push({ name: "SearchResult", params: { keyword: this.keyword } });
        }
      }
    },
  },
};
</script>

<style scoped>
</style>
