import request from '@/utils/request'

export const insertApproved = (data: any) =>
  request({
    url: '/insert-approved',
    method: 'post',
    data
  })
