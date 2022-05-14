import { login, logout, getInfo, updateUser } from '@/api/login'
import { getToken, setToken, removeToken } from '@/utils/auth'

const user = {
  state: {
    token: getToken(),
    user: JSON.parse(localStorage.getItem("userInfo")) || {},
    avatar: '',
    roles: [],
    auth: [],
  },

  mutations: {
    SET_TOKEN: (state, token) => {
      state.token = token
    },
    SET_USER: (state, user) => {
      localStorage.setItem('userInfo', JSON.stringify(user));
      state.user = user
    },
    SET_AVATAR: (state, avatar) => {
      state.avatar = avatar
    },
    SET_ROLES: (state, roles) => {
      state.roles = roles
    },
    SET_AUTH: (state, auth) => {
      state.auth = auth
    },
  },

  actions: {
    // 登录
    Login({ commit }, userInfo) {
      const username = userInfo.username.trim()
      return new Promise((resolve, reject) => {
        login(username, userInfo.password).then(response => {
          const data = response.data
          const tokenStr = data.token
          const auth = data.auth;
          setToken(tokenStr)
          let user = {
            userId: data.userId,
            username: data.username,
            userface: data.userface,
            phone: data.phone,
            email: data.email,
            sex: data.sex
          };
          commit('SET_TOKEN', tokenStr);
          commit('SET_AUTH', auth);
          commit('SET_USER', user);
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 更新用户信息
    saveUserInfo({ commit }, userInfo) {
      let id = userInfo.userId;
      userInfo.username.trim()
      return new Promise((resolve, reject) => {
        updateUser(id, userInfo).then(response => {
          if (response.code === 200) {
            commit('SET_NAME', userInfo.username)
            commit('SET_USERFACE', userInfo.userface)
            commit('SET_PHONE', userInfo.phone)
            commit('SET_EMAIL', userInfo.email)
            commit('SET_SEX', userInfo.sex)
          }
        })
      })
    },

    // 获取用户信息
    GetInfo({ commit, state }) {
      return new Promise((resolve, reject) => {
        getInfo().then(response => {
          const data = response.data
          console.log("data", data);
          if (data.roles && data.roles.length > 0) { // 验证返回的roles是否是一个非空数组
            commit('SET_ROLES', data.roles)
          } else {
            reject('getInfo: roles must be a non-null array !')
          }
          commit('SET_NAME', data.username)
          commit('SET_AVATAR', data.icon)
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 登出
    LogOut({ commit, state }) {
      return new Promise((resolve, reject) => {
        logout(state.token).then(() => {
          commit('SET_TOKEN', '')
          commit('SET_ROLES', [])
          removeToken()
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 前端 登出
    FedLogOut({ commit }) {
      return new Promise(resolve => {
        commit('SET_TOKEN', '')
        removeToken()
        resolve()
      })
    }
  }
}

export default user
