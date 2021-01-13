import store from '@/store'
import { asyncRoutes, constantRoutes } from '@/router'

import { UserStoreModule } from '@/store/modules/user/store'

import { PermissionState } from './type'
import { RouteConfig } from 'vue-router'
import { VuexModule, Module, Mutation, Action, getModule } from 'vuex-module-decorators'

const hasPermission = (roles: string[], route: RouteConfig) => {
  if (route.meta && route.meta.roles) {
    return roles.some(role => route.meta.roles.includes(role))
  } else {
    return true
  }
}

export const filterAsyncRoutes = (routes: RouteConfig[], roles: string[]) => {
  const res: RouteConfig[] = []
  routes.forEach(route => {
    const r = { ...route }
    if (hasPermission(roles, r)) {
      if (r.children) {
        r.children = filterAsyncRoutes(r.children, roles)
      }
      res.push(r)
    }
  })
  return res
}

@Module({ dynamic: true, store, name: 'permission', namespaced: true })
class Permission extends VuexModule implements PermissionState {
  public routes: RouteConfig[] = []
  public dynamicRoutes: RouteConfig[] = []

  @Mutation
  private SET_ROUTES(routes: RouteConfig[]) {
    this.routes = constantRoutes.concat(routes)
    this.dynamicRoutes = routes
  }

  @Mutation
  private SET_CLEAR_ROUTER() {
    this.routes = []
    this.dynamicRoutes = []
  }

  @Action({ rawError: true })
  public ClearRouter() {
    this.SET_CLEAR_ROUTER()
  }

  @Action({ rawError: true })
  public GenerateRoutes(roles: string[]) {
    let accessedRoutes: any
    if (roles.includes('admin')) {
      accessedRoutes = asyncRoutes
      UserStoreModule.routerList.forEach(item => {
        accessedRoutes.push(item)
      })
    } else {
      accessedRoutes = filterAsyncRoutes(asyncRoutes, roles)
    }
    this.SET_ROUTES(accessedRoutes)
  }
}

export const PermissionModule = getModule(Permission)
