import { userFetchList, updateReceiver } from '@/api/receiver'

const receiver = {
  state: {
    receiverList: JSON.parse(localStorage.getItem("receiverList")) || [],
  },

  mutations: {
    SET_RECEIVERLIST: (state, receiverList) => {
      localStorage.setItem('receiverList', JSON.stringify(receiverList));
      state.receiverList = receiverList
    },
    SET_RECEIVER: (state, receiver) => {
      state.receiverList[0] = receiver
    }
  },

  actions: {
    getUserReceiverList({ commit }, uid) {
      return new Promise((resolve, reject) => {
        userFetchList(uid).then(response => {
          console.log(response, response.data.length);
          if (response.code === 200 && response.data.length != 0) {
            commit("SET_RECEIVERLIST", response.data);
          }
          resolve();
        }).catch(error => {
          reject(error);
        })
      })
    },

    updateReceiverList({ commit }, param) {
      let id = param.id;
      return new Promise((resolve, reject) => {
        updateReceiver(id, param).then(response => {
          if (response.code === 200) {
            commit("SET_RECEIVER", param);
          }
          resolve();
        }).catch(error => {
          reject(error);
        })
      })
    }
  }
}

export default receiver
