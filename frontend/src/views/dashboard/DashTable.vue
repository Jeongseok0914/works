<template>
  <div class="dashboard-table">
    <div class="dashboard-table__header">
      <div class="dashboard-table__header__grid">
        <div class="dashboard-table__header__grid__title">테이블 타이틀</div>
        <div class="dashboard-table__header__grid__excel">
          <download-excel :data="tableData" name="filename.xls">
            <el-button type="info"><svg-icon name="excel" style="margin-right:7px;" />엑셀출력</el-button>
          </download-excel>
        </div>
      </div>
    </div>
    <div class="dashboard-table__body">
      <div class="dashboard-table__body__search">
        <span class="dashboard-table__body__search__date-title">시작기간</span>
        <span><el-date-picker v-model="searchStartDate" type="date" placeholder="날짜 선택"/></span>
        <span class="dashboard-table__body__search__date-title">종료기간</span>
        <span><el-date-picker v-model="searchEndDate" type="date" placeholder="날짜 선택"/></span>
        <span class="dashboard-table__body__search__date-title">구분</span>
        <span>
          <el-select v-model="select1">
            <el-option v-for="item in selectOption" :key="item.key" :label="item.label" :value="item.value"></el-option>
          </el-select>
        </span>
        <span class="dashboard-table__body__search__date-title">카드사</span>
        <span>
          <el-select v-model="select1">
            <el-option v-for="item in selectOption" :key="item.key" :label="item.label" :value="item.value"></el-option>
          </el-select>
        </span>
        <span class="dashboard-table__body__search__date-title">진료과</span>
        <span>
          <el-select v-model="select1">
            <el-option v-for="item in selectOption" :key="item.key" :label="item.label" :value="item.value"></el-option>
          </el-select>
        </span>
      </div>
      <div class="dashboard-table__body__table">
        <el-table :data="tableData" header-align="center">
          <el-table-column prop="date" label="날짜/시간" align="center"></el-table-column>
          <el-table-column prop="hosType" label="구분" align="center"></el-table-column>
          <el-table-column prop="deviceType" label="분류" align="center"></el-table-column>
          <el-table-column prop="pgType" label="PG사" align="center"></el-table-column>
          <el-table-column prop="paymentDept" label="카드사" align="center"></el-table-column>
          <el-table-column prop="price" label="금액" align="center"></el-table-column>
          <el-table-column prop="medicalType" label="진료과" align="center"></el-table-column>
          <el-table-column prop="gender" label="성별" align="center"></el-table-column>
          <el-table-column prop="birth" label="생년월일" align="center"></el-table-column>
        </el-table>
        <div class="dashboard-table__body__paging">
          <el-pagination :page-size="15" layout="prev, pager, next" :total="totalCount" :current-change="currentPage" @current-change="handleCurrentChange"> </el-pagination>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import { DashboardStoreModule } from '@/store/modules/dashboard/store'
@Component({
  name: 'DashboardTable'
})
export default class extends Vue {
  private searchStartDate: any = ''
  private searchEndDate: any = ''
  private select1: string = ''
  private page: number = 1
  private selectOption: any = [
    { label: '전체', value: 'A' },
    { label: 'BC카드', value: 'B' },
    { label: '국민카드', value: 'C' }
  ]

  get tableData() {
    return DashboardStoreModule.dashboardList
  }
  get totalCount() {
    return DashboardStoreModule.dashboardListTotalCount
  }

  created() {
    this.getDashboardList()
  }

  get currentPage() {
    return this.page
  }

  set currentPage(value) {
    this.$emit('update:page', value)
  }

  private async handleCurrentChange(value: number) {
    this.page = await value
    this.getDashboardList()
  }

  private async getDashboardList() {
    const payload = {
      page: this.page,
      limit: 15
    }
    await DashboardStoreModule.GetDashboardData(payload)
  }
}
</script>

<style lang="scss">
.dashboard-table {
  &__header {
    width: 96%;
    height: 60px;
    margin-top: 20px;
    margin-left: 20px;
    padding: 20px;
    border-top-left-radius: 5px;
    border-top-right-radius: 5px;
    border: solid 1px #e5e5e5;
    background-color: #409eff;
    &__grid {
      display: grid;
      grid-template-columns: 1fr 1fr;
      &__title {
        font-size: 20px;
        font-weight: bold;
        text-align: left;
        color: #ffffff;
      }
      &__excel {
        margin-top: -10px;
        font-weight: bold;
        text-align: right;
        .el-button {
          font-weight: bold;
        }
      }
    }
  }
  &__body {
    width: 96%;
    height: 100%;
    margin-left: 20px;
    background-color: #fff;
    border-bottom-left-radius: 5px;
    border-bottom-right-radius: 5px;
    border-bottom: solid 1px #e5e5e5;
    margin-bottom: 100px;
    &__search {
      margin-left: 40px;
      padding: 2%;
      &__date-title {
        margin-top: 20px;
        color: #000000;
        font-size: 17px;
        text-align: left;
        margin-right: 20px;
      }
      .el-date-editor {
        width: 180px;
        height: 40px;
        margin-right: 20px;
      }
      .el-select {
        width: 180px;
        margin-right: 20px;
      }
    }
    &__table {
      padding: 0%;
      .el-table th {
        background-color: #f9f9f9;
        font-size: 14px;
        font-weight: 500;
        font-stretch: normal;
        font-style: normal;
        line-height: normal;
        letter-spacing: normal;
        color: #4e5159;
      }
      .el-table__row {
        font-size: 14px;
        text-align: center;
        color: #4e5159;
      }
    }
    &__paging {
      text-align: center;
      padding: 3%;
      .el-pagination {
        .el-pager li {
          font-size: 16px;
        }
        .btn-prev {
          .el-icon el-icon-arrow-left {
            font-size: 18px;
          }
        }
      }
    }
  }
}
</style>
