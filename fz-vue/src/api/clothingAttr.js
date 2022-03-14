import request from '@/utils/request'
export function fetchList(cid,params) {
  return request({
    url:'/clothingAttribute/list/'+cid,
    method:'get',
    params:params
  })
}

export function deleteClothingAttr(data) {
  return request({
    url:'/clothingAttribute/delete',
    method:'post',
    data:data
  })
}

export function createClothingAttr(data) {
  return request({
    url:'/clothingAttribute/create',
    method:'post',
    data:data
  })
}

export function updateClothingAttr(id,data) {
  return request({
    url:'/clothingAttribute/update/'+id,
    method:'post',
    data:data
  })
}
export function getClothingAttr(id) {
  return request({
    url:'/clothingAttribute/'+id,
    method:'get'
  })
}

export function getClothingAttrInfo(clothingCategoryId) {
  return request({
    url:'/clothingAttribute/attrInfo/'+clothingCategoryId,
    method:'get'
  })
}
