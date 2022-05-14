import request from "@/utils/request"

export function userFetchList(uid) {
  return request({
    url: '/receiver/user/' + uid,
    method: 'get'
  })
}

export function updateReceiver(id, data) {
  return request({
    url: '/receiver/update/' + id,
    method: 'post',
    data: data
  })
}
