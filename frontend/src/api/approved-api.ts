import request from '@/utils/request'
export const selectApproved = () =>
  request({
    url: 'select-approved',
    method: 'post',
    data: {}
  })

export const insertApproved = (data: any) =>
  request({
    url: '/insert-approved',
    method: 'post',
    data
  })
