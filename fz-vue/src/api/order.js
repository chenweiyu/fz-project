import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url:'/order/list',
    method:'get',
    params:params
  })
}

export function closeOrder(params) {
  return request({
    url:'/order/update/close',
    method:'post',
    params:params
  })
}

export function createOrderBatch(data) {
  return request({
    url: '/order/createBatch',
    method: 'post',
    data: data
  })
}

export function createOrder(data) {
  return request({
    url: '/order/create',
    method: 'post',
    data: data
  })
}

export function deleteOrder(params) {
  return request({
    url:'/order/delete',
    method:'post',
    params:params
  })
}

export function deliveryOrder(data) {
  return request({
    url:'/order/update/delivery',
    method:'post',
    data:data
  });
}

export function getOrderDetail(id) {
  return request({
    url:'/order/'+id,
    method:'get'
  });
}

export function getUserOrderList(userId, params) {
  return request({
    url: '/order/user/' + userId,
    method: 'get',
    params: params
  });
}

export function updateReceiverInfo(data) {
  return request({
    url:'/order/update/receiverInfo',
    method:'post',
    data:data
  });
}

export function updateMoneyInfo(data) {
  return request({
    url:'/order/update/moneyInfo',
    method:'post',
    data:data
  });
}

export function updatepayInfo(data) {
  return request({
    url:'/order/update/payInfo',
    method:'post',
    data:data
  });
}

export function updatepayInfoList(data) {
  return request({
    url: '/order/update/payInfoList',
    method: 'post',
    data: data
  });
}

export function updateOrderNote(params) {
  return request({
    url:'/order/update/note',
    method:'post',
    params:params
  })
}
