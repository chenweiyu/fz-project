import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url:'/clothing/list',
    method:'get',
    params:params
  })
}

export function fetchTideList(params) {
  return request({
    url:'/clothing/listTide',
    method:'get',
    params:params
  })
}

export function fetchSimpleList(params) {
  return request({
    url:'/clothing/listSimple',
    method:'get',
    params:params
  })
}

export function fetchSportList(params) {
  return request({
    url:'/clothing/listSport',
    method:'get',
    params:params
  })
}

export function fetchNationList(params) {
  return request({
    url:'/clothing/listNation',
    method:'get',
    params:params
  })
}

export function updateDeleteStatus(params) {
  return request({
    url:'/clothing/update/deleteStatus',
    method:'post',
    params:params
  })
}

export function updateNewStatus(params) {
  return request({
    url:'/clothing/update/newStatus',
    method:'post',
    params:params
  })
}

export function updateRecommendStatus(params) {
  return request({
    url:'/clothing/update/recommendStatus',
    method:'post',
    params:params
  })
}

export function updatePublishStatus(params) {
  return request({
    url:'/clothing/update/publishStatus',
    method:'post',
    params:params
  })
}

export function createClothing(data) {
  return request({
    url:'/clothing/create',
    method:'post',
    data:data
  })
}

export function updateClothing(id,data) {
  return request({
    url:'/clothing/update/'+id,
    method:'post',
    data:data
  })
}

export function getClothing(id) {
  return request({
    url:'/clothing/updateInfo/'+id,
    method:'get',
  })
}

