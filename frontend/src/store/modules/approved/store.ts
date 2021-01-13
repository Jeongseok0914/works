import store from '@/store'
import { VuexModule, Module, Action, Mutation, getModule } from 'vuex-module-decorators'
import { ApprovedStoreState } from './type'
import { insertApproved } from '@/api/approved-api'
@Module({ dynamic: true, store, name: 'approvedStore', namespaced: true })
class ApprovedStore extends VuexModule implements ApprovedStoreState {
  @Mutation
  private SET_CHANGE_VALUE(payload: { key: string; value: any }) {
    const { key, value } = payload
    if (Object.prototype.hasOwnProperty.call(this, key)) {
      ;(this as any)[key] = value
    }
  }

  @Action({ rawError: true })
  public async RegisterApproved(payload) {
    const { data } = await insertApproved(payload)
    console.log(data)
  }

  @Action({ rawError: true })
  public ChangeValue(payload: { key: string; value: any }) {
    this.SET_CHANGE_VALUE(payload)
  }
}

export const ApprovedStoreModule = getModule(ApprovedStore)
