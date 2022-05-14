import Vue from 'vue'
import Vuex from 'vuex'
import app from './modules/app'
import user from './modules/user'
import permission from './modules/permission'
import cart from './modules/cart'
import receiver from './modules/receiver'
import getters from './getters'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    currentUserId: null,
    currentUsername: null,
    keyword: null
  },
  mutations:{
    SET_KEYWORD(state, keyword) {
      state.keyword = keyword;
    }
  },
  modules: {
    app,
    user,
    permission,
    cart,
    receiver
  },
  getters
})

export default store
