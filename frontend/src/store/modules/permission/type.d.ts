import { RouteConfig } from 'vue-router'

export interface PermissionState {
  routes: RouteConfig[]
  dynamicRoutes: RouteConfig[]
}
