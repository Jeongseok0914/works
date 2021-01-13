<template>
  <div id="bar-chart" class="bar-chart" />
</template>

<script lang="ts">
import { Component, Vue, Prop } from 'vue-property-decorator'
import { mixins } from 'vue-class-component'
import echarts, { ECharts, EChartOption } from 'echarts'
import variables from '@/styles/_variables.scss'

export interface IBarChart {
  legend: string[]
  colors: string[]
  xAxisData: string[]
  series: SeriesType[]
}

export interface SeriesType {
  name: string
  type: string
  stack: string
  data: number[]
}

@Component({
  name: 'BarChart'
})
export default class extends Vue {
  @Prop({ required: true }) private chartItems!: IBarChart
  @Prop({ default: 'chart' }) private className!: string
  @Prop({ default: 'chart' }) private id!: string
  @Prop({ default: '100%' }) private width!: string
  @Prop({ default: '500px' }) private height!: string
  private chart!: ECharts

  mounted() {
    this.initProcess()
  }

  beforeDestroy() {
    if (!this.chart) {
      return
    }
    this.chart.dispose()
    this.chart = null
  }

  private async initProcess() {
    this.chart = await echarts.init(this.$el as HTMLDivElement)
    await this.setOptions(this.chartItems)
  }

  private setOptions(chartItems: IBarChart) {
    if (this.chart) {
      this.chart.setOption({
        title: {
          text: ''
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          left: 250,
          data: chartItems.legend
        },
        color: chartItems.colors,
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        toolbox: {},
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: chartItems.xAxisData
        },
        yAxis: {
          type: 'value'
        },
        series: chartItems.series
      } as EChartOption<EChartOption.SeriesLine>)
    }
  }
}
</script>
<style lang="scss">
.bar-chart {
  width: 100%;
  height: 500px;
}
</style>
