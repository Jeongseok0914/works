<template>
  <el-dialog :visible.sync="dialogVisible" title="결재자 검색" :before-close="handleClose" width="550px" top>
    <el-form ref="approvedForm" label-width="70px">
      <ValidationProvider name="결재자" rules="required">
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
  </el-dialog>
</template>

<script lang="ts">
import { Component, Vue, Prop } from 'vue-property-decorator'
import { UserStoreModule } from '@/store/modules/user/store'
@Component({
  name: 'UserSearchPopup'
})
export default class extends Vue {
  @Prop({ default: false }) private showDialog: boolean
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
    UserStoreModule.ChangeValue({ key: 'approvedUserList', value: [] })
    this.dialogVisible = false
  }

  private enter(done) {
    UserStoreModule.ChangeValue({ key: 'approvedUserInfo', value: { userId: this.radioItem.userId, userName: this.radioItem.userName } })
    UserStoreModule.ChangeValue({ key: 'approvedUserList', value: [] })
    this.dialogVisible = false
  }

  private async searchUser() {
    await UserStoreModule.UserSearch({ userName: this.name })
  }
  private async changeItem(item) {
    this.radioItem = item
    console.log(this.radioItem)
  }
}
</script>

<style lang="scss" scoped></style>
