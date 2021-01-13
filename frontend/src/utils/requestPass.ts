import axios from 'axios'

import { MessageService } from '@/utils/message-service'
import { SettingsModule } from '@/store/modules/settings/store'

declare module 'axios' {
  export interface AxiosResponse<T = any> extends Promise<T> {
    data: T
    resultCd: number
    status: number
    statusText: string
    headers: any
    config: AxiosRequestConfig
    request?: any
  }
}

const service = axios.create({
  baseURL: process.env.VUE_APP_BASE_API,
  withCredentials: true,
  timeout: 5000
})

service.interceptors.request.use(
  config => {
    const reqType = config.method
    switch (reqType) {
      case 'post':
        if (localStorage.getItem('userId')) {
          config.data.systemKey = localStorage.getItem('userId')
        }
        break

      default:
        break
    }

    return config
  },
  error => {
    Promise.reject(error)
  }
)

service.interceptors.response.use(
  response => {
    const value = true
    SettingsModule.ChangeSetting({ key: 'loginTimeStatus', value })
    const resultCd = response.data.resultCd
    if (response.status === 500) {
      MessageService.MsgError('내부 시스템 오류 관리자에게 문의하세요.')
      return false
    }

    return response.data
  },
  error => {
    MessageService.MsgError(error.message || 'empty error message')
    return Promise.reject(error)
  }
)

export default service
