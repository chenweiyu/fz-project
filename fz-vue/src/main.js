// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
// import axios from 'axios'
import store from './store'
import VCharts from 'v-charts'
import qs from "qs"
// axios.defaults.baseURL = 'http://localhost:9001'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min.js'
import locale from 'element-ui/lib/locale/lang/zh-CN' // lang i18n
import $ from 'jquery'
// Vue.prototype.$axios = axios
Vue.config.productionTip = false
Vue.use(ElementUI, { locale })
// Vue.prototype.$http = axios

// this.$qs
Vue.prototype.$qs=qs;
Vue.use(VCharts)

router.beforeEach((to, from, next) => {
  if (to.matched.some(record => record.meta.requireAuth)) {
    if (store.state.user.user.userId != undefined && store.state.user.user.userId != null) {
      next();
    } else {
      next({
        path: '/login',
        query: { redirect: to.fullPath }
      })
    }
  }
  else {
    next();
  }
});

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
