import request from '@/utils/request'

export const login = (data: any) =>
  request({
    url: '/login',
    method: 'post',
    data
  })

export const checkLogin = (data: any) =>
  request({
    url: '/check-login',
    method: 'post',
    data
  })

export const logout = (data: any) =>
  request({
    url: '/logout',
    method: 'post',
    data
  })

export const userSearch = (data: any) =>
  request({
    url: '/user-search',
    method: 'post',
    data
  })
