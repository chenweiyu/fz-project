import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import AppIndex from '@/views/front/AppIndex'
import Index from '@/views/front/Index'
import GoodsDetail from '@/views/front/GoodsDetail'
import GoodsCart from '@/views/front/GoodsCart'
import MyOrder from '@/views/front/MyOrder'
import UserDetail from '@/views/front/UserDetail'
import test from '@/views/front/test'

import LoginIndex from '@/views/login/LoginIndex'

import Home from '@/views/back/Home'

import BackIndex from '@/views/back/index/Index'

import ClothingTable from '@/views/back/clothing/ClothingTable'
import ClothingCategory from '@/views/back/clothing/ClothingCategory'
import ClothingAdd from '@/views/back/clothing/ClothingAdd'
import ClothingUpdate from '@/views/back/clothing/ClothingUpdate'
import ClothingCateAdd from '@/views/back/clothing/ClothingCateAdd'
import ClothingCateUpdate from '@/views/back/clothing/ClothingCateUpdate'
import BrandIndex from '@/views/back/clothing/BrandIndex'
import BrandAdd from '@/views/back/clothing/BrandAdd'
import BrandUpdate from '@/views/back/clothing/BrandUpdate'

import OrderTable from '@/views/back/order/OrderTable'
import OrderReturn from '@/views/back/order/OrderReturn'
import ReasonSetting from '@/views/back/order/ReasonSetting'

import User from '@/views/back/User'
import Role from '@/views/back/Role'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    // {
    //   path: '/',
    //   name: 'test',
    //   component: test
    // },
    {
      path: '',
      component: LoginIndex,
      name: 'LoginIndex'
    },
    {
      path: '/login',
      component: LoginIndex,
      name: 'LoginIndex'
    },
    {
      path: '/appIndex',
      name: 'AppIndex',
      component: AppIndex,
      redirect: '/index',
      children: [
        {
          path: '/index',
          name: 'Index',
          component: Index,
        },
        {
          path: '/goodsDetail',
          name: 'GoodsDetail',
          component: GoodsDetail,
        },
        {
          path: '/goodsCart',
          name: 'GoodsCart',
          component: GoodsCart,
        },
        {
          path: '/myOrder',
          name: 'MyOrder',
          component: MyOrder,
        },
        {
          path: '/userDetail',
          name: 'UserDetail',
          component: UserDetail,
        }
      ]
    },
    {
      path: '/backHome',
      name: 'Home',
      component: Home,
      redirect: '/backHome/index',
      children: [
        {
          path: '/backHome/index',
          component: BackIndex
        },
        {
          path: '/backHome/clothingTable',
          name: 'ClothingTable',
          component: ClothingTable
        },
        {
          path: '/backHome/clothingCategory',
          name: 'ClothingCategory',
          component: ClothingCategory
        },
        {
          path: '/backHome/addClothingCate',
          name: 'ClothingCateAdd',
          component: ClothingCateAdd
        },
        {
          path: '/backHome/updateClothingCate',
          name: 'ClothingCateUpdate',
          component: ClothingCateUpdate
        },
        {
          path: '/backHome/clothingAdd',
          name: 'ClothingAdd',
          component: ClothingAdd,
        },
        {
          path: '/backHome/clothingUpdate',
          name: 'ClothingUpdate',
          component: ClothingUpdate,
        },
        {
          path: '/backHome/brand',
          name: 'BrandIndex',
          component: BrandIndex,
        },
        {
          path: '/backHome/brandAdd',
          name: 'BrandAdd',
          component: BrandAdd,
        },
        {
          path: '/backHome/brandUpdate',
          name: 'BrandUpdate',
          component: BrandUpdate,
        },
        {
          path: '/backHome/orderTable',
          name: 'OrderTable',
          component: OrderTable
        },
        {
          path: '/backHome/orderReturn',
          name: 'OrderReturn',
          component: OrderReturn
        },
        {
          path: '/backHome/reasonSetting',
          name: 'ReasonSetting',
          component: ReasonSetting
        },
        {
          path: '/user',
          name: 'User',
          component: User
        },
        {
          path: '/role',
          name: 'Role',
          component: Role
        }
      ]
    }
  ]
})
