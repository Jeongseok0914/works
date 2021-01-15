<template>
  <el-dialog :visible.sync="dialogVisible" title="결재자 검색" :before-close="handleClose" width="550px" top>
    <ValidationObserver ref="approvedForm" tag="form">
      <el-form label-width="70px">
        <ValidationProvider name="결재자">
          <el-form-item slot-scope="{ errors }" :error="errors[0]" label="결재자">
            <el-input v-model="name" style="width:220px; margin-right:10px;" />
            <el-button @click.native="searchUser()" icon="el-icon-search">검색</el-button>
          </el-form-item>
        </ValidationProvider>
      </el-form>
      <div style="width: 100%; padding: 5%;">
        <el-radio v-model="radio" @change="changeItem(item)" v-for="item in approvedUserList" :key="item.id" :label="item.userName">{{ item.userName }}</el-radio>
      </div>
      <el-button style="margin-bottom: 40px; margin-top:20px;" v-if="approvedUserList.length > 0" type="primary" @click.native="enter">확인</el-button>
    </ValidationObserver>
  </el-dialog>
</template>

<script lang="ts">
import { Component, Vue, Prop } from 'vue-property-decorator'
import { UserStoreModule } from '@/store/modules/user/store'
import { ValidationObserver } from 'vee-validate'
import { MessageService } from '@/utils/message-service'
@Component({
  name: 'UserSearchPopup'
})
export default class extends Vue {
  @Prop({ default: false }) private showDialog: boolean
  $refs!: { approvedForm: any }
  private name: string = ''
  private radioItem = { userId: '', userName: '' }
  private radio = ''

  get approvedUserList() {
    return UserStoreModule.approvedUserList
  }

  get dialogVisible() {
    return this.showDialog
  }
  set dialogVisible(val) {
    this.$emit('update:visible', val)
  }

  private handleClose(done) {
    this.close(done)
  }

  private async close(done) {
    await this.$refs.approvedForm.reset()
    UserStoreModule.ChangeValue({ key: 'approvedUserList', value: [] })
    this.name = ''
    this.dialogVisible = false
  }

  private enter(done) {
    if (this.radioItem.userId === '') {
      MessageService.notiWarning('사용자를 선택해 주세요.')
    } else {
      UserStoreModule.ChangeValue({ key: 'approvedUserInfo', value: { userId: this.radioItem.userId, userName: this.radioItem.userName } })
      UserStoreModule.ChangeValue({ key: 'approvedUserList', value: [] })
      this.close(done)
    }
  }

  private searchUser() {
    this.$refs.approvedForm.validate().then(async result => {
      if (result) {
        await UserStoreModule.UserSearch({ userName: this.name })
      }
    })
  }
  private async changeItem(item) {
    this.radioItem = item
  }
}
</script>

<style lang="scss" scoped></style>
