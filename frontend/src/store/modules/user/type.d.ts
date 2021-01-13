export interface UserStoreState {
  roles: string[]
  routerList: RouteConfig[]
}

export interface routerType {
  path: string
  component: string
  name?: string
  redirect?: string
  title?: string
  noCache?: boolean
  children: routerType[]
}
