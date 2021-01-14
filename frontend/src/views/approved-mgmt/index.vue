<template>
  <div class="approved-mgmt">
    <div class="approved-mgmt-hearder">결재 관리</div>
    <div class="approved-mgmt-table">
      <el-table :data="approvedList" header-align="center">
        <el-table-column prop="title" label="제목"></el-table-column>
        <el-table-column prop="content" label="내용"></el-table-column>
        <el-table-column prop="sysCretDate" label="요청일자"></el-table-column>
        <el-table-column prop="sysUpdtDate" label="결재일자"></el-table-column>
        <el-table-column label="결재상태">
          <template slot-scope="scope">
            <el-button v-if="scope.row.status === 'W'" type="primary">요청(수정가능)</el-button>
          </template>
        </el-table-column>
        <el-table-column v-if="roleId === 'R0000'" label="결재">
          <template slot-scope="scope">
            <div v-if="scope.row.status === 'W'">
              <el-button>22</el-button>
              <el-button>22</el-button>
            </div>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import { ApprovedStoreModule } from '@/store/modules/approved/store'
import { UserStoreModule } from '../../store/modules/user/store'
@Component({
  name: 'ApprovedMgmt'
})
export default class extends Vue {
  private data = []

  get approvedList() {
    return ApprovedStoreModule.approvedList
  }
  get roleId() {
    return UserStoreModule.roleId
  }

  mounted() {
    ApprovedStoreModule.GetApproved()
  }
}
</script>

<style lang="scss" scoped>
.approved-mgmt {
  &-hearder {
    width: 100%;
    height: 100px;
    border: solid 1px grey;
    font-size: 30px;
    font-weight: bold;
    padding-left: 30px;
    line-height: 3;
    color: grey;
  }
  &-table {
    padding: 5%;
  }
}
</style>
