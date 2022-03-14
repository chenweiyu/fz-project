import request from '@/utils/request'
export function fetchList(parentId,params) {
  return request({
    url:'/clothingCategory/list/'+parentId,
    method:'get',
    params:params
  })
}
export function deleteClothingCate(id) {
  return request({
    url:'/clothingCategory/delete/'+id,
    method:'post'
  })
}

export function createClothingCate(data) {
  return request({
    url:'/clothingCategory/create',
    method:'post',
    data:data
  })
}

export function updateClothingCate(id,data) {
  return request({
    url:'/clothingCategory/update/'+id,
    method:'post',
    data:data
  })
}

export function getClothingCate(id) {
  return request({
    url:'/clothingCategory/'+id,
    method:'get',
  })
}

export function updateShowStatus(data) {
  return request({
    url:'/clothingCategory/update/showStatus',
    method:'post',
    data:data
  })
}

export function updateNavStatus(data) {
  return request({
    url:'/clothingCategory/update/navStatus',
    method:'post',
    data:data
  })
}

export function fetchListWithChildren() {
  return request({
    url:'/clothingCategory/list/withChildren',
    method:'get'
  })
}
