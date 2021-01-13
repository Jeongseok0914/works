import Vue from 'vue'
import Router, { RouteConfig } from 'vue-router'

import * as routerName from '@/router/modules/router-constants'

Vue.use(Router)

export const constantRoutes: RouteConfig[] = [
  {
    path: '/redirect',
    component: routerName['Layout'],
    meta: { hidden: true },
    children: [
      {
        path: '/redirect/:path*',
        component: routerName['rediredct']
      }
    ]
  },
  {
    path: '/login',
    component: routerName['login'],
    meta: { hidden: true }
  },
  {
    path: '/auth-redirect',
    component: routerName['authRedirect'],
    meta: { hidden: true }
  },
  {
    path: '/404',
    component: routerName['error404Page'],
    meta: { hidden: true }
  },
  {
    path: '/401',
    component: routerName['error401Page'],
    meta: { hidden: true }
  },
  {
    path: '/',
    component: routerName['Layout'],
    redirect: '/approved-mgmt',
    meta: { hidden: true },
    children: [
      {
        path: 'main',
        component: routerName['main'],
        name: 'Main',
        meta: {
          title: 'main',
          affix: true
        }
      }
    ]
  }
]

export const asyncRoutes: RouteConfig[] = [
  {
    path: '*',
    redirect: '/404',
    meta: { hidden: true }
  }
]

const createRouter = () =>
  new Router({
    scrollBehavior: (to, from, savedPosition) => {
      if (savedPosition) {
        return savedPosition
      } else {
        return { x: 0, y: 0 }
      }
    },
    base: process.env.BASE_URL,
    routes: constantRoutes
  })

const router = createRouter()

export function resetRouter() {
  const newRouter = createRouter()
  ;(router as any).matcher = (newRouter as any).matcher
}

export default router
