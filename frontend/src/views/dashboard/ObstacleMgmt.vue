<template>
  <div class="dashboard-obstacle-mgmt">
    <div class="dashboard-obstacle-mgmt__search">
      <span class="dashboard-obstacle-mgmt__search__date-title">시작기간</span>
      <span><el-date-picker v-model="searchStartDate" type="date" placeholder="날짜 선택"/></span>
      <span class="dashboard-obstacle-mgmt__search__date-title">종료기간</span>
      <span><el-date-picker v-model="searchEndDate" type="date" placeholder="날짜 선택"/></span>
      <span>
        <el-button type="primary" @click.native="searchObstacleItem()"><svg-icon name="part03-s-search"/></el-button>
      </span>
    </div>
    <div class="dashboard-obstacle-mgmt__chart-card">
      <card-frame class="item" :card-frame-items="cardFrameItems"></card-frame>
      <pie-chart class="item" :chart-items="pieChartItems" />
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import { MessageService } from '@/utils/message-service'
import PieChart, { IPieChart } from '@/components/Chart/PieChart.vue'
import CardFrame, { ICardFrame } from '@/components/CardFrame/index.vue'
import CardPanel from '@/components/CardPanel/index.vue'
import variables from '@/styles/_variables.scss'

@Component({
  name: 'DashboardObstacleMgmt',
  components: { PieChart, CardFrame, CardPanel }
})
export default class extends Vue {
  private searchStartDate: any = ''
  private searchEndDate: any = ''

  private pieChartItems: IPieChart = {
    legend: ['결재', '도착확인', '번호표발급', '제증명발급', '보험청구', '앱설치', '장애'],
    colors: [variables.payment, variables.arrive, variables.numberTicket, variables.proof, variables.insurance, variables.install, variables.obstacle],
    seriesRadius: '70%',
    seriesMegTitle: '현황',
    seriesPosition: ['50%', '60%'],
    seriesData: [
      { value: 335, name: '결재' },
      { value: 310, name: '도착확인' },
      { value: 234, name: '번호표발급' },
      { value: 135, name: '제증명발급' },
      { value: 1548, name: '보험청구' },
      { value: 135, name: '앱설치' },
      { value: 135, name: '장애' }
    ]
  }

  private cardFrameItems: ICardFrame = {
    lastDate: '',
    toDate: '',
    title: '장애 현황',
    userCount: 1234566789,
    paymentCount: 987654321,
    paymentRatio: 0.8,
    paymentRatioType: 'plus',
    arriveRatio: 0.2,
    arriveRatioType: 'minus',
    numberTicketRatio: 12.3,
    numberTicketRatioType: 'plus',
    proofRatio: 7.4,
    proofRatioType: 'plus',
    insuranceRatio: 1.4,
    insuranceRatioType: 'plus',
    installRatio: 0.6,
    installRatioType: 'plus',
    obstacleRatio: 0.2,
    obstacleRatioType: 'minus'
  }

  private searchObstacleItem() {
    const searchStartDate = this.searchStartDate || ''
    const searchEndDate = this.searchEndDate || ''
    if (searchStartDate === '') {
      MessageService.notiWarning('시작 기간을 입력해 주세요.')
      return false
    }
    if (searchEndDate === '') {
      MessageService.notiWarning('종료 기간을 입력해 주세요.')
      return false
    }
    if (searchStartDate > searchEndDate) {
      MessageService.notiWarning('기간 입력을 확인해 주세요.')
      return false
    }
  }
}
</script>

<style lang="scss">
.dashboard-obstacle-mgmt {
  width: 96%;
  height: 100%;
  margin-top: 20px;
  margin-left: 20px;
  padding: 20px;
  background-color: #fff;
  border-radius: 5px;
  border: solid 1px #e5e5e5;
  margin-bottom: 30px;
  &__search {
    margin-left: 40px;
    &__date-title {
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
    .el-button {
      width: 60px;
    }
  }
  &__chart-card {
    width: 120vw;
    display: grid;
    margin-top: 30px;
    column-gap: 10px;
    grid-template-columns: 1fr 1fr 1fr 1fr;
    .item:nth-child(1) {
      width: 350px;
      margin-left: 50px;
      margin-top: -60px;
      grid-column-start: 1;
      grid-row-start: 1;
    }
    .item:nth-child(2) {
      width: 55vw;
      font-weight: bold;
      grid-column-start: 2;
      grid-row-start: 1;
    }
  }
}
</style>
