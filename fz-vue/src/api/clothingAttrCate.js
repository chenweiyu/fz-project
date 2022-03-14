import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url:'/clothingAttribute/category/list',
    method:'get',
    params:params
  })
}

export function createProductAttrCate(data) {
  return request({
    url:'/clothingAttribute/category/create',
    method:'post',
    data:data
  })
}

export function deleteProductAttrCate(id) {
  return request({
    url:'/clothingAttribute/category/delete/'+id,
    method:'get'
  })
}

export function updateProductAttrCate(id,data) {
  return request({
    url:'/clothingAttribute/category/update/'+id,
    method:'post',
    data:data
  })
}
export function fetchListWithAttr() {
  return request({
    url:'/clothingAttribute/category/list/withAttr',
    method:'get'
  })
}
