<template>
  <div class="card-panel">
    <div class="card-panel__text1">{{ cardPanelItems.title }}</div>
    <div class="card-panel__image"><svg-icon :name="cardPanelItems.icon" /></div>
    <div class="card-panel__count">
      <span class="card-panel__count__text2"><count-to :start-val="0" :end-val="cardPanelItems.count" :duration="2600"/></span>
      <span class="card-panel__count__text3">(+ <count-to :start-val="0" :end-val="cardPanelItems.ratio" :duration="2600" />%)</span>
    </div>
    <div class="card-panel__date">
      {{ cardPanelItems.period }}
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue, Prop } from 'vue-property-decorator'
import CountTo from 'vue-count-to'

export interface ICardPanel {
  title: string
  icon: string
  count: number
  ratio: number
  period: string
}

@Component({
  name: 'CardPanel',
  components: { CountTo }
})
export default class extends Vue {
  @Prop({ required: true }) private cardPanelItems!: ICardPanel
}
</script>

<style lang="scss" scoped>
.card-panel {
  width: 100%;
  height: 139px;
  border: solid 1px #e5e5e5;
  border-radius: 5px;
  &__text1 {
    font-size: 15px;
    font-weight: bold;
    letter-spacing: -0.28px;
    text-align: left;
    color: #303896;
    margin-top: 20px;
    margin-left: 20px;
  }
  &__count {
    margin-top: -10px;
    &__text2 {
      font-size: 26px;
      font-weight: bold;
      letter-spacing: -0.52px;
      text-align: left;
      margin-top: -10px;
      margin-left: 20px;
      color: #302f37;
    }
    &__text3 {
      font-size: 14px;
      font-weight: 500;
      letter-spacing: -0.28px;
      text-align: left;
      margin-left: 10px;
      color: #35cf4e;
    }
  }
  &__date {
    font-size: 12px;
    font-weight: bold;
    letter-spacing: -0.24px;
    text-align: left;
    margin-top: 15px;
    margin-left: 20px;
    color: #8d8d9a;
  }
  &__image {
    .svg-icon {
      width: 3em;
      height: 3em;
    }
    text-align: right;
    margin-top: -20px;
    margin-right: 20px;
  }
}
</style>
