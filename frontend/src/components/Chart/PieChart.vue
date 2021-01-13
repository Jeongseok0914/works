<template>
  <div id="pie-chart" class="pie-chart" />
</template>

<script lang="ts">
import { Component, Vue, Prop } from 'vue-property-decorator'
import { mixins } from 'vue-class-component'
import echarts, { ECharts, EChartOption } from 'echarts'

export interface IPieChart {
  legend: string[]
  colors: string[]
  seriesData: SeriesType[]
  seriesRadius: string
  seriesMegTitle: string
  seriesPosition: string[]
}

export interface SeriesType {
  value: number
  name: string
}

@Component({
  name: 'PieChart'
})
export default class extends Vue {
  @Prop({ required: true }) private chartItems!: IPieChart
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

  private setOptions(chartItems: IPieChart) {
    if (this.chart) {
      this.chart.setOption({
        title: {
          text: '',
          subtext: '',
          left: ''
        },
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        legend: {
          // orient: 'vertical',
          left: 250,
          data: chartItems.legend
        },
        color: chartItems.colors,
        series: [
          {
            name: chartItems.seriesMegTitle,
            type: 'pie',
            radius: chartItems.seriesRadius,
            center: chartItems.seriesPosition,
            data: chartItems.seriesData,
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      } as EChartOption<EChartOption.SeriesPie>)
    }
  }
}
</script>
<style lang="scss">
.pie-chart {
  width: 100%;
  height: 500px;
}
</style>
