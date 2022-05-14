import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/user/list',
    method: 'get',
    params: params
  })
}

export function updateStatus(id, params) {
  return request({
    url: '/user/updateStatus/' + id,
    method: 'post',
    params: params
  })
}

export function getRoleByUser(id) {
  return request({
    url: '/user/role/' + id,
    method: 'get'
  })
}

export function allocRole(data) {
  return request({
    url: '/user/role/update',
    method: 'post',
    data: data
  })
}

export function createUser(data) {
  return request({
    url: '/user/register',
    method: 'post',
    data: data
  })
}

export function updateUser(id, data) {
  return request({
    url: '/user/update/' + id,
    method: 'post',
    data: data
  })
}

export function deleteUser(data) {
  return request({
    url: '/user/delete',
    method: 'post',
    data: data
  })
}

export function logout() {
  return request({
    url: '/user/logout',
    method: 'post'
  })
}
