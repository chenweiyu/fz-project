<template>
  <section style="width: 400px; height: 230px">
    <div v-for="tideGood in tideGoods" :key="tideGood.id">
      <img :src="tideGood.goodImg" />
    </div>
  </section>
</template>

<script>
export default {
  name: "test",
  data() {
    return {
      tideGoods: [
        {
          goodName: "潮流破洞牛仔裤",
          goodImg: require("../../assets/img/portfolio/portfolio-1.jpg"),
          goodPrice: "88.88",
        },
      ],
    };
  },
  // components: {
  //   "remote-js": {
  //     render(createElement) {
  //       return createElement("script", {
  //         attrs: {
  //           type: "text/JavaScript",
  //           src: "https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js",
  //         },
  //       });
  //     },
  //   },
  //   "remote-js": {
  //     render(createElement) {
  //       return createElement("script", {
  //         attrs: {
  //           type: "text/JavaScript",
  //           src: "https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js",
  //         },
  //       });
  //     },
  //   },
  //   "remote-js": {
  //     render(createElement) {
  //       return createElement("script", {
  //         attrs: {
  //           type: "text/JavaScript",
  //           src: "https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js",
  //         },
  //       });
  //     },
  //   },
  // },
};
</script>

<style>
/* @import "https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css"; */
</style>
