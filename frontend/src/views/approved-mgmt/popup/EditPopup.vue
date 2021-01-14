<template>
  <el-dialog :visible.sync="dialogVisible" title="결재 정보 수정" :before-close="handleClose" width="550px" top>
    <ValidationObserver ref="editForm" tag="form">
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
      <el-button class="write-form-button-setup" type="primary" @click.native="setApproved()">수정</el-button>
    </ValidationObserver>
  </el-dialog>
</template>

<script lang="ts">
import { Component, Vue, Prop } from 'vue-property-decorator'
import { ApprovedStoreModule } from '@/store/modules/approved/store'
import { MessageService } from '@/utils/message-service'

@Component({
  name: 'EditPopup'
})
export default class extends Vue {
  $refs!: { editForm: any }
  @Prop({ default: false }) private showDialog: boolean
  @Prop({ required: true }) private props!: any
  private title = ''
  private content = ''

  get dialogVisible() {
    this.title = this.props.title
    this.content = this.props.content
    return this.showDialog
  }
  set dialogVisible(val) {
    this.$emit('update:visible', val)
  }

  private handleClose(done) {
    this.close(done)
  }

  private async close(done) {
    // await this.$refs.approvedForm.reset()

    this.dialogVisible = false
  }

  private async setApproved(done) {
    const payload = {
      idx: this.props.idx,
      title: this.title,
      content: this.content
    }

    this.$refs.editForm.validate().then(async result => {
      if (result) {
        await ApprovedStoreModule.ChangeApproved(payload).then(async (resolve: any) => {
          if (resolve === 200) {
            MessageService.notiSuccess('수정 되었습니다.')
            await this.$refs.editForm.reset()
            await ApprovedStoreModule.GetApproved()
            this.close(done)
          } else {
            MessageService.notiError('수정 되지 않았습니다.')
          }
        })
      }
    })
  }
}
</script>

<style lang="scss" scoped></style>
