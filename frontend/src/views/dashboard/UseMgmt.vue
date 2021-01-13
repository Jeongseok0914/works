<template>
  <div class="dashboard-user-mgmt">
    <div class="dashboard-user-mgmt__search">
      <span class="dashboard-user-mgmt__search__date-title">시작기간</span>
      <span><el-date-picker v-model="searchStartDate" type="date" placeholder="날짜 선택"/></span>
      <span class="dashboard-user-mgmt__search__date-title">종료기간</span>
      <span><el-date-picker v-model="searchEndDate" type="date" placeholder="날짜 선택"/></span>
      <span>
        <el-button type="primary" @click.native="searchUseItem()"><svg-icon name="part03-s-search"/></el-button>
      </span>
    </div>
    <div class="dashboard-user-mgmt__chart-card">
      <card-frame class="item" :card-frame-items="cardFrameItems"></card-frame>
      <bar-chart :chart-items="barChartItems" class="item" />
    </div>
    <div class="dashboard-user-mgmt__panel">
      <card-panel :card-panel-items="cardPanelItem1" />
      <card-panel :card-panel-items="cardPanelItem2" />
      <card-panel :card-panel-items="cardPanelItem3" />
      <card-panel :card-panel-items="cardPanelItem4" />
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import BarChart, { IBarChart } from '@/components/Chart/BarChart.vue'
import CardFrame, { ICardFrame } from '@/components/CardFrame/index.vue'
import CardPanel, { ICardPanel } from '@/components/CardPanel/index.vue'
import variables from '@/styles/_variables.scss'
import { MessageService } from '@/utils/message-service'
@Component({
  name: 'DashboardUseMgmt',
  components: { BarChart, CardFrame, CardPanel }
})
export default class extends Vue {
  private searchStartDate: any = ''
  private searchEndDate: any = ''
  private barChartItems: IBarChart = {
    legend: ['결재', '도착확인', '번호표발급', '제증명발급', '보험청구', '앱설치', '장애'],
    colors: [variables.payment, variables.arrive, variables.numberTicket, variables.proof, variables.insurance, variables.install, variables.obstacle],
    xAxisData: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    series: [
      {
        name: '결재',
        type: 'line',
        stack: 'lineStack',
        data: [120, 132, 101, 134, 90, 230, 210, 120, 132, 101, 134, 90, 230, 210]
      },
      {
        name: '도착확인',
        type: 'line',
        stack: 'lineStack',
        data: [220, 182, 191, 234, 290, 330, 310, 120, 132, 101, 134, 90, 230, 210]
      },
      {
        name: '번호표발급',
        type: 'line',
        stack: 'lineStack',
        data: [150, 232, 201, 154, 190, 330, 410, 120, 132, 101, 134, 90, 230, 210]
      },
      {
        name: '제증명발급',
        type: 'line',
        stack: 'lineStack',
        data: [320, 332, 301, 334, 390, 330, 320, 120, 132, 101, 134, 90, 230, 210]
      },
      {
        name: '보험청구',
        type: 'line',
        stack: 'lineStack',
        data: [820, 932, 901, 934, 1290, 1330, 1320, 120, 132, 101, 134, 90, 230, 210]
      },
      {
        name: '앱설치',
        type: 'line',
        stack: 'lineStack',
        data: [820, 932, 901, 934, 1290, 1330, 1320, 120, 132, 101, 134, 90, 230, 210]
      },
      {
        name: '장애',
        type: 'line',
        stack: 'lineStack',
        data: [820, 932, 901, 934, 1290, 1330, 1320, 120, 132, 101, 134, 90, 230, 210]
      }
    ]
  }

  private cardFrameItems: ICardFrame = {
    lastDate: '2019.04.07',
    toDate: '2019.04.08',
    title: '이용 현황',
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

  private cardPanelItem1: ICardPanel = {
    title: '무인 수납',
    icon: 'icon-con-01',
    count: 32384,
    ratio: 40,
    period: '이용 기간 2020.10.18 ~ 10.28'
  }

  private cardPanelItem2: ICardPanel = {
    title: '제증명',
    icon: 'icon-con-02',
    count: 872384,
    ratio: 10,
    period: '이용 기간 2020.10.18 ~ 10.28'
  }

  private cardPanelItem3: ICardPanel = {
    title: '보험청구',
    icon: 'icon-con-03',
    count: 13384,
    ratio: 23,
    period: '이용 기간 2020.10.18 ~ 10.28'
  }

  private cardPanelItem4: ICardPanel = {
    title: '처방전 발행',
    icon: 'icon-con-04',
    count: 22384,
    ratio: 70,
    period: '이용 기간 2020.10.18 ~ 10.28'
  }

  private searchUseItem() {
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
.dashboard-user-mgmt {
  width: 96%;
  height: 100%;
  margin-top: 100px;
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
  &__panel {
    display: grid;
    padding: 3%;
    grid-template-columns: 1fr 1fr 1fr 1fr;
    column-gap: 10px;
  }
}
</style>
