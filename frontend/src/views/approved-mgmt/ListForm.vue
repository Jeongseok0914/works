<template>
  <div class="list-form">
    <el-table :data="approvedList" header-align="center">
      <el-table-column prop="title" label="제목"></el-table-column>
      <el-table-column prop="content" label="내용"></el-table-column>
      <el-table-column prop="sysCretDate" label="요청일자"></el-table-column>
      <el-table-column prop="sysUpdtDate" label="결재일자"></el-table-column>
      <el-table-column label="결재상태">
        <template slot-scope="scope">
          <div v-if="scope.row.status === 'W' && roleId === 'R0001'">
            <el-button type="info" @click.native="changeItem(scope.row)">수정</el-button>
            <el-button type="danger" @click.native="removeItem(scope.row)">삭제</el-button>
          </div>
          <div v-else>
            {{ changeText(scope.row.status) }}
          </div>
        </template>
      </el-table-column>
      <el-table-column v-if="roleId === 'R0000'" label="결재">
        <template slot-scope="scope">
          <div v-if="scope.row.status === 'W'">
            <el-button type="success" @click.native="approvedItem(scope.row)">승인</el-button>
            <el-button type="danger" @click.native="rejectItem(scope.row)">반려</el-button>
          </div>
          <div v-else>
            {{ changeText(scope.row.status) }}
          </div>
        </template>
      </el-table-column>
    </el-table>
    <edit-popup :visible.sync="showDialog" :show-dialog="showDialog" :props="apprvedItem" />
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import { ApprovedStoreModule } from '@/store/modules/approved/store'
import { UserStoreModule } from '../../store/modules/user/store'
import EditPopup from './popup/EditPopup.vue'

@Component({
  name: 'ListForm',
  components: { EditPopup }
})
export default class extends Vue {
  private showDialog = false
  private apprvedItem = {}

  get approvedList() {
    return ApprovedStoreModule.approvedList
  }
  get roleId() {
    return UserStoreModule.roleId
  }

  mounted() {
    ApprovedStoreModule.GetApproved()
  }

  private async approvedItem(item) {
    const payload = {
      idx: item.idx,
      status: 'A'
    }
    await ApprovedStoreModule.ChangeApproved(payload).then(async (resolve: any) => {
      if (resolve === 200) {
        await ApprovedStoreModule.GetApproved()
      }
    })
  }

  private async rejectItem(item) {
    const payload = {
      idx: item.idx,
      status: 'R'
    }
    await ApprovedStoreModule.ChangeApproved(payload).then(async (resolve: any) => {
      if (resolve === 200) {
        await ApprovedStoreModule.GetApproved()
      }
    })
  }

  private async changeItem(item) {
    this.apprvedItem = Object.assign(item)
    this.showDialog = true
  }
  private async removeItem(item) {
    const payload = {
      idx: item.idx
    }
    await ApprovedStoreModule.RemoveApproved(payload).then(async (resolve: any) => {
      if (resolve === 200) {
        await ApprovedStoreModule.GetApproved()
      }
    })
  }

  private changeText(item) {
    if (item === 'R') {
      return '반려'
    } else if (item === 'A') {
      return '승인'
    }
    return ''
  }
}
</script>

<style lang="scss" scoped>
.list-form {
  padding: 5%;
}
</style>
