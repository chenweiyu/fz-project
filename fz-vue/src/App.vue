<template>
  <div id="app">
    <!-- <img src="./assets/logo.png"> -->
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
/* #app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
} */
body {
  font-family: "Open Sans", sans-serif;
  color: #444444;
}
a {
  color: #ffc107;
}

a:hover {
  color: #ffce3a;
  text-decoration: none;
}

h1, h2, h3, h4, h5, h6 {
  font-family: "Raleway", sans-serif;
}
</style>
