import store from '@/store'

import defaultSettings from '@/settings'
import elementVariables from '@/styles/element-variables.scss'

import { SettingsState } from './type'
import { Action, getModule, Module, Mutation, VuexModule } from 'vuex-module-decorators'

@Module({ dynamic: true, store, name: 'settings', namespaced: true })
class Settings extends VuexModule implements SettingsState {
  public theme = elementVariables.theme
  public fixedHeader = defaultSettings.fixedHeader
  public showSettings = defaultSettings.showSettings
  public showTagsView = defaultSettings.showTagsView
  public showSidebarLogo = defaultSettings.showSidebarLogo
  public sidebarTextTheme = defaultSettings.sidebarTextTheme
  public loginTime = defaultSettings.loginTime
  public userEditStatus = false
  public loginTimeStatus = false

  @Action({ rawError: true })
  public ChangeSetting(payload: { key: string; value: any }) {
    this.CHANGE_SETTING(payload)
  }

  @Mutation
  private CHANGE_SETTING(payload: { key: string; value: any }) {
    const { key, value } = payload
    if (Object.prototype.hasOwnProperty.call(this, key)) {
      ;(this as any)[key] = value
    }
  }
}

export const SettingsModule = getModule(Settings)
