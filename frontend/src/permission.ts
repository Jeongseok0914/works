import router from './router'
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
import { Message } from 'element-ui'
import { Route } from 'vue-router'
import { UserStoreModule } from '@/store/modules/user/store'
import { PermissionModule } from '@/store/modules/permission/store'

import i18n from '@/lang'
import settings from './settings'

NProgress.configure({ showSpinner: false })

const whiteList = ['/login', '/auth-redirect']

const getPageTitle = (key: string) => {
  const hasKey = i18n.te(`route.${key}`)
  if (hasKey) {
    const pageName = i18n.t(`route.${key}`)
    return `${pageName} - ${settings.title}`
  }
  return `${settings.title}`
}

router.beforeEach(async (to: Route, _: Route, next: any) => {
  NProgress.start()
  if (localStorage.getItem('token')) {
    if (to.path === '/login') {
      next({ path: '/' })
      NProgress.done()
    } else {
      if (UserStoreModule.roles.length === 0) {
        try {
          await UserStoreModule.CheckLogin({})
          const roles = UserStoreModule.roles
          PermissionModule.GenerateRoutes(roles)
          router.addRoutes(PermissionModule.dynamicRoutes)
          next({ ...to, replace: true })
        } catch (err) {
          localStorage.removeItem('token')
          Message.error(err || 'Has Error')
          next(`/login?redirect=${to.path}`)
          NProgress.done()
        }
      } else {
        next()
      }
    }
  } else {
    if (whiteList.indexOf(to.path) !== -1) {
      next()
    } else {
      next(`/login?redirect=${to.path}`)
      NProgress.done()
    }
  }
})

router.afterEach((to: Route) => {
  NProgress.done()
  document.title = getPageTitle(to.meta.title)
})
