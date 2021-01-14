import store from '@/store'
import { login, checkLogin, logout, userSearch } from '@/api/user-api'
import { UserStoreState } from './type'
import { VuexModule, Module, Action, Mutation, getModule } from 'vuex-module-decorators'
import { convertRouter } from './supprot'

@Module({ dynamic: true, store, name: 'userStore', namespaced: true })
class UserStore extends VuexModule implements UserStoreState {
  public userId = ''
  public userName = ''
  public roleId = ''
  public roles = []
  public routerList = []
  public approvedUserInfo = {
    userId: '',
    userName: ''
  }
  public approvedUserList = []

  @Mutation
  private SET_CHANGE_VALUE(payload: { key: string; value: any }) {
    const { key, value } = payload
    if (Object.prototype.hasOwnProperty.call(this, key)) {
      ;(this as any)[key] = value
    }
  }

  @Action({ rawError: true })
  public async Login(userInfo: { userId: string; userPassword: string }) {
    let { userId, userPassword } = userInfo
    userId = userId.trim()
    const { data = '' } = await login({ userId, userPassword })

    if (data !== '') {
      localStorage.setItem('token', data)
      return new Promise(resolve => {
        resolve(200)
      })
    }
  }

  @Action({ rawError: true })
  public async CheckLogin() {
    const { data } = await checkLogin({})
    const readyRouterList = convertRouter(data.menuList)
    this.SET_CHANGE_VALUE({ key: 'userId', value: data.userId })
    this.SET_CHANGE_VALUE({ key: 'userName', value: data.userName })
    this.SET_CHANGE_VALUE({ key: 'roleId', value: data.roleId })
    this.SET_CHANGE_VALUE({ key: 'routerList', value: Object.freeze(readyRouterList) })
    this.SET_CHANGE_VALUE({ key: 'roles', value: ['admin'] })
  }

  @Action({ rawError: true })
  public async Logout() {
    // await logout({ title: '로그아웃' })
    localStorage.removeItem('token')
  }

  @Action({ rawError: true })
  public async UserSearch(payload: { userName: string }) {
    const { data } = await userSearch(payload)
    this.SET_CHANGE_VALUE({ key: 'approvedUserList', value: data })
  }

  @Action({ rawError: true })
  public ChangeValue(payload: { key: string; value: any }) {
    this.SET_CHANGE_VALUE(payload)
  }
}

export const UserStoreModule = getModule(UserStore)
