import store from '@/store'
import { VuexModule, Module, Action, Mutation, getModule } from 'vuex-module-decorators'
import { ApprovedStoreState } from './type'
import { selectApproved, insertApproved } from '@/api/approved-api'
@Module({ dynamic: true, store, name: 'approvedStore', namespaced: true })
class ApprovedStore extends VuexModule implements ApprovedStoreState {
  public approvedList = []
  @Mutation
  private SET_CHANGE_VALUE(payload: { key: string; value: any }) {
    const { key, value } = payload
    if (Object.prototype.hasOwnProperty.call(this, key)) {
      ;(this as any)[key] = value
    }
  }

  @Action({ rawError: true })
  public async GetApproved() {
    const { data } = await selectApproved()
    this.SET_CHANGE_VALUE({ key: 'approvedList', value: data })
  }

  @Action({ rawError: true })
  public async RegisterApproved(payload) {
    const { resultCd } = await insertApproved(payload)
    if (resultCd === 200) {
      return new Promise(resolve => {
        resolve(200)
      })
    }
  }

  @Action({ rawError: true })
  public ChangeValue(payload: { key: string; value: any }) {
    this.SET_CHANGE_VALUE(payload)
  }
}

export const ApprovedStoreModule = getModule(ApprovedStore)
