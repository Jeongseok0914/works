import arrayToTree from 'array-to-tree'
import { RouteConfig } from 'vue-router'
import { routerType } from '@/store/modules/user/type'
import * as routerName from '@/router/modules/router-constants'

import { set, size } from 'lodash'

export const convertRouter = (flatRouterList: routerType[]) => {
  const resultRouterList: RouteConfig[] = []
  const convertRouterToTree = arrayToTree(flatRouterList, { parentProperty: 'parentId', customID: 'menuId' })

  convertRouterToTree.forEach(item => {
    const routerItem = {
      path: item.path,
      component: routerName[item.component],
      redirect: item.redirect
    }
    if (size(item.children) > 0) {
      const childrenRouterList: RouteConfig[] = []
      item.children.forEach(childrenItem => {
        const childrenRouterItem = {
          path: childrenItem.path,
          component: routerName[childrenItem.component],
          name: childrenItem.name,
          meta: {
            title: childrenItem.title,
            noCache: true
          }
        }
        childrenRouterList.push(childrenRouterItem)
      })
      set(routerItem, 'children', childrenRouterList)
    }
    resultRouterList.push(routerItem)
  })

  return resultRouterList
}
