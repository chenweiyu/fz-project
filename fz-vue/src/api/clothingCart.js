import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/clothingCart/list',
    method: 'get',
    params: params
  })
}

export function createClothingCart(data) {
  return request({
    url: '/clothingCart/create',
    method: 'post',
    data: data
  })
}

export function deleteCartId(id) {
  return request({
    url: '/clothingCart/delete/' + id,
    method: 'get',
  })
}

export function deleteCartIds(params) {
  return request({
    url: '/clothingCart/delete/batch',
    method: 'post',
    params: params
  })
}
