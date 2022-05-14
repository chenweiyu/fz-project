import { fetchList, createClothingCart, deleteCartIds, deleteCartId } from '@/api/clothingCart'

const cart = {
  state: {
    clothingCart: []
  },

  mutations: {
    SET_CLOTHINGCART: (state, clothingCart) => {
      state.clothingCart = clothingCart
    },
    // ADD_CCATTR: (state, id) => {
    //   state.clothingCart[id].clothingCartList.
    // }
  },

  actions: {
    // 登录
    getClothingCart({ commit }, queryInfo) {
      return new Promise((resolve, reject) => {
        fetchList(queryInfo).then(response => {
          if (response.code === 200) {
            commit("SET_CLOTHINGCART", response.data);
          }
          resolve(response);
        }).catch(error => {
          reject(error);
        })
      })
    },
    create({ commit }, cartQuery) {
      return new Promise((resolve, reject) => {
        createClothingCart(cartQuery).then((response) => {
          if (response.code === 200) {
            resolve(response);
          }
        }).catch(error => {
          reject(error);
        })
      })
    },
    deleteClothingCartId({ commit }, id) {
      return new Promise((resolve, reject) => {
        deleteCartId(id).then((response) => {
          if (response.code === 200) {
            resolve(response);
          }
        }).catch(error => {
          reject(error);
        })
      })
    },
    deleteClothingCartIds({ commit }, params) {
      return new Promise((resolve, reject) => {
        deleteCartIds(params).then((response) => {
          if (response.code === 200) {
            resolve(response);
          }
        }).catch(error => {
          reject(error);
        })
      })
    },
  }
}

export default cart
