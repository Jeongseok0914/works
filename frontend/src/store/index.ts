import Vue from 'vue'
import Vuex from 'vuex'
import { AppState } from './modules/app/type'
import { TagsViewState } from './modules/tag-view/type'
import { PermissionState } from './modules/permission/type'
import { SettingsState } from './modules/settings/type'
import { UserStoreState } from './modules/user/type'

Vue.use(Vuex)

export interface IRootState {
  app: AppState
  tagsView: TagsViewState
  permission: PermissionState
  settings: SettingsState
  userStore: UserStoreState
}

// Declare empty store first, dynamically register all modules later.
export default new Vuex.Store<IRootState>({})
