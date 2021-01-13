import { Route } from 'vue-router'

export interface TagsViewState {
  visitedViews: TagViewItem[]
  cachedViews: (string | undefined)[]
}

export interface TagViewItem extends Partial<Route> {
  title?: string
}
