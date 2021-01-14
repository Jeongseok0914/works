<template>
  <div class="write-form">
    <ValidationObserver ref="writeForm" tag="form">
      <el-form label-width="70px">
        <ValidationProvider name="결재자" rules="required">
          <el-form-item slot-scope="{ errors }" :error="errors[0]" label="결재자">
            <el-input v-model="approvedUser.userName" style="width:220px; margin-right:10px;" disabled />
            <el-button icon="el-icon-search" circle @click.native="showDialog = true"></el-button>
          </el-form-item>
        </ValidationProvider>
      </el-form>
      <el-form label-width="70px">
        <ValidationProvider name="제목" rules="required">
          <el-form-item slot-scope="{ errors }" :error="errors[0]" label="제목">
            <el-input v-model="title" />
          </el-form-item>
        </ValidationProvider>
      </el-form>
      <el-form label-width="70px">
        <ValidationProvider name="내용" rules="required">
          <el-form-item slot-scope="{ errors }" :error="errors[0]" label="내용">
            <el-input type="textarea" v-model="content" :autosize="{ minRows: 12, maxRows: 14 }" />
          </el-form-item>
        </ValidationProvider>
      </el-form>
      <el-button class="write-form-button-setup" type="primary" @click.native="setApproved()">등록</el-button>
      <user-search-popup :visible.sync="showDialog" :show-dialog="showDialog" />
    </ValidationObserver>
  </div>
</template>

<script lang="ts">
import { UserStoreModule } from '@/store/modules/user/store'
import { ApprovedStoreModule } from '@/store/modules/approved/store'
import { Component, Vue } from 'vue-property-decorator'
import UserSearchPopup from './popup/UserSearchPopup.vue'
import { MessageService } from '@/utils/message-service'
@Component({
  name: 'WriteForm',
  components: { UserSearchPopup }
})
export default class extends Vue {
  $refs!: { writeForm: any }
  private showDialog = false
  private title: string = ''
  private content: string = ''

  get approvedUser() {
    return UserStoreModule.approvedUserInfo
  }

  private async setApproved() {
    const payload = {
      title: this.title,
      content: this.content,
      approvedUserId: this.approvedUser.userId
    }

    this.$refs.writeForm.validate().then(async result => {
      if (result) {
        await ApprovedStoreModule.RegisterApproved(payload).then(async (resolve: any) => {
          if (resolve === 200) {
            this.title = ''
            this.content = ''
            UserStoreModule.ChangeValue({ key: 'approvedUserInfo', value: {} })
            MessageService.notiSuccess('등록 되었습니다.')
            await this.$refs.writeForm.reset()
          } else {
            MessageService.notiError('등록 되지 않았습니다.')
          }
        })
      }
    })
  }
}
</script>

<style lang="scss" scoped>
.write-form {
  padding: 100px;
  &-button-setup {
    padding: 20px;
    margin-left: 70px;
    font-size: 20px;
    width: 400px;
  }
}
</style>
