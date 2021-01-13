<template>
  <div class="card-frame">
    <!-- <div class="card-frame__date">
      <span style="margin-right:20px;"> <span v-if="cardFrameItems.lastDate">latest data : </span>{{ cardFrameItems.lastDate }} </span>
      <span><span v-if="cardFrameItems.toDate">today : </span>{{ cardFrameItems.toDate }}</span>
    </div> -->
    <div class="card-frame__use">{{ cardFrameItems.title }}</div>
    <div class="card-frame__count">
      <div class="card-frame__count__text">
        <span>전체 사용자 수 : </span>
        <span><count-to :start-val="0" :end-val="cardFrameItems.userCount" :duration="2600"/></span>
      </div>
      <div class="card-frame__count__text">
        <span>전체 결재 건 수 : </span>
        <span><count-to :start-val="0" :end-val="cardFrameItems.paymentCount" :duration="2600"/></span>
      </div>
      <div class="card-frame__count__line"></div>
    </div>
    <div class="card-frame__content">
      <div class="padding">
        <span><svg-icon name="part03-s-circle" :style="{ fill: variables.payment }"/></span>
        <span class="text margin-left">결제 건수</span>
        <span class="plus" v-if="cardFrameItems.paymentRatioType === 'plus'">↑ {{ cardFrameItems.paymentRatio }}%</span>
        <span class="minus" v-else-if="cardFrameItems.paymentRatioType === 'minus'">↓ {{ cardFrameItems.paymentRatio }}%</span>
      </div>
      <div class="padding">
        <span><svg-icon name="part03-s-circle" :style="{ fill: variables.arrive }"/></span>
        <span class="text margin-left">도착확인 건수</span>
        <span class="plus" v-if="cardFrameItems.arriveRatioType === 'plus'">↑ {{ cardFrameItems.arriveRatio }}%</span>
        <span class="minus" v-else-if="cardFrameItems.arriveRatioType === 'minus'">↓ {{ cardFrameItems.arriveRatio }}%</span>
      </div>
      <div class="padding">
        <span><svg-icon name="part03-s-circle" :style="{ fill: variables.numberTicket }"/></span>
        <span class="text margin-left">번호표 발급 건수</span>
        <span class="plus" v-if="cardFrameItems.numberTicketRatioType === 'plus'">↑ {{ cardFrameItems.numberTicketRatio }}%</span>
        <span class="minus" v-else-if="cardFrameItems.numberTicketRatioType === 'minus'">↓ {{ cardFrameItems.numberTicketRatio }}%</span>
      </div>
      <div class="padding">
        <span><svg-icon name="part03-s-circle" :style="{ fill: variables.proof }"/></span>
        <span class="text margin-left">제증명 발급 건수</span>
        <span class="plus" v-if="cardFrameItems.proofRatioType === 'plus'">↑ {{ cardFrameItems.proofRatio }}%</span>
        <span class="minus" v-else-if="cardFrameItems.proofRatioType === 'minus'">↓ {{ cardFrameItems.proofRatio }}%</span>
      </div>
      <div class="padding">
        <span><svg-icon name="part03-s-circle" :style="{ fill: variables.insurance }"/></span>
        <span class="text margin-left">보험청구 건수</span>
        <span class="plus" v-if="cardFrameItems.insuranceRatioType === 'plus'">↑ {{ cardFrameItems.insuranceRatio }}%</span>
        <span class="minus" v-else-if="cardFrameItems.insuranceRatioType === 'minus'">↓ {{ cardFrameItems.insuranceRatio }}%</span>
      </div>
      <div class="padding">
        <span><svg-icon name="part03-s-circle" :style="{ fill: variables.install }"/></span>
        <span class="text margin-left">앱 설치 건수</span>
        <span class="plus" v-if="cardFrameItems.installRatioType === 'plus'">↑ {{ cardFrameItems.installRatio }}%</span>
        <span class="minus" v-else-if="cardFrameItems.installRatioType === 'minus'">↓ {{ cardFrameItems.installRatio }}%</span>
      </div>
      <div class="padding">
        <span><svg-icon name="part03-s-circle" :style="{ fill: variables.obstacle }"/></span>
        <span class="text margin-left">장애 건수</span>
        <span class="plus" v-if="cardFrameItems.obstacleRatioType === 'plus'">↑ {{ cardFrameItems.obstacleRatio }}%</span>
        <span class="minus" v-else-if="cardFrameItems.obstacleRatioType === 'minus'">↓ {{ cardFrameItems.obstacleRatio }}%</span>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue, Prop } from 'vue-property-decorator'
import CountTo from 'vue-count-to'
import variables from '@/styles/_variables.scss'

export interface ICardFrame {
  lastDate: string
  toDate: string
  title: string
  userCount: number
  paymentCount: number
  paymentRatio: number
  paymentRatioType: string
  arriveRatio: number
  arriveRatioType: string
  numberTicketRatio: number
  numberTicketRatioType: string
  proofRatio: number
  proofRatioType: string
  insuranceRatio: number
  insuranceRatioType: string
  installRatio: number
  installRatioType: string
  obstacleRatio: number
  obstacleRatioType: string
}

@Component({
  name: 'CardFrame',
  components: { CountTo }
})
export default class extends Vue {
  @Prop({ required: true }) private cardFrameItems!: ICardFrame

  get variables() {
    return variables
  }
}
</script>

<style lang="scss" scoped>
.card-frame {
  width: 100%;
  height: 100%;
  &__date {
    font-size: 15px;
    font-family: NotoSansCJKkr;
    font-size: 15px;
    font-weight: 500;
    font-stretch: normal;
    font-style: normal;
    line-height: normal;
    letter-spacing: normal;
    margin-top: -40px;

    color: #414146;
  }
  &__use {
    margin-top: 60px;
    font-size: 30px;
    font-weight: bold;
    letter-spacing: -0.6px;
    text-align: left;
    color: #323640;
  }
  &__count {
    margin-top: 50px;
    &__text {
      font-size: 16px;
      font-weight: 500;
      font-stretch: normal;
      font-style: normal;
      line-height: normal;
      letter-spacing: -0.32px;
      text-align: left;
      color: #3d424e;
      margin-bottom: 25px;
    }
    &__line {
      border-bottom: solid 1px #3d424e;
      width: 16vw;
    }
  }
  &__content {
    &__payment-circle {
      width: 10px;
      height: 10px;
      background-color: $payment;
      border-radius: 8px;
    }
    .padding {
      margin-top: 25px;
    }
    .margin-left {
      margin-left: 5px;
    }
    .text {
      font-size: 14px;
      font-weight: 500;
      font-stretch: normal;
      font-style: normal;
      line-height: normal;
      letter-spacing: normal;
      text-align: left;
      color: #323640;
    }
    .plus {
      font-size: 14px;
      font-weight: blod;
      text-align: left;
      color: #1fa7cb;
    }
    .minus {
      font-size: 14px;
      font-weight: blod;
      text-align: left;
      color: #db4437;
    }
  }
}
</style>
