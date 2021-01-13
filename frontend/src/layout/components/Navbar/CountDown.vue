<template>
  <div>
    <el-button type="text" plain icon="el-icon-time" style="width: 100px;" @click.native="resetBtn">
      {{ timeLeft }}
    </el-button>
  </div>
</template>

<script lang="ts">
import defaultSettings from '@/settings'
import { Component, Vue, Watch } from 'vue-property-decorator'
import { SettingsModule } from '@/store/modules/settings/store'
import { UserStoreModule } from '@/store/modules/user/store'
import { Loading } from 'element-ui'
@Component({
  name: 'CountDown'
})
export default class extends Vue {
  private selectedTime: number = 0
  private timeLeft: string = '00:00'
  private endTime: string | number = '0'
  private intervalTimer: any
  private status: boolean = false

  get loginTime() {
    return SettingsModule.loginTime
  }

  get loginTimeStatus() {
    return SettingsModule.loginTimeStatus
  }

  @Watch('loginTimeStatus', { deep: true })
  private changeTimer(value) {
    if (value === true) {
      this.setTime(defaultSettings.loginTime)
      const value = false
      SettingsModule.ChangeSetting({ key: 'loginTimeStatus', value })
    }
  }

  created() {
    this.setTime(this.loginTime)
  }
  /** Methods */
  public resetBtn() {
    this.setTime(this.loginTime)
  }
  private setTime(seconds) {
    clearInterval(this.intervalTimer)
    this.timer(seconds)
  }
  private timer(seconds) {
    const now = Date.now()
    const end = now + seconds * 1000
    this.displayTimeLeft(seconds)
    this.selectedTime = seconds
    this.displayEndTime(end)
    this.countdown(end)
  }

  private countdown(end) {
    this.intervalTimer = setInterval(() => {
      const secondsLeft = Math.round((end - Date.now()) / 1000)
      if (secondsLeft) {
        this.endTime = 0
      }
      if (secondsLeft < 0) {
        // Timeout end
        this.logout()
        clearInterval(this.intervalTimer)
        return false
      }
      this.displayTimeLeft(secondsLeft)
    }, 1000)
  }
  private displayTimeLeft(secondsLeft) {
    const minutes = Math.floor((secondsLeft % 3600) / 60)
    const seconds = secondsLeft % 60
    this.timeLeft = this.zeroPadded(minutes) + ':' + this.zeroPadded(seconds)
  }
  private displayEndTime(timestamp) {
    const end = new Date(timestamp)
    const hour = end.getHours()
    const minutes = end.getMinutes()
    this.endTime = this.hourConvert(hour) + ':' + this.zeroPadded(minutes)
  }
  private zeroPadded(num) {
    return num < 10 ? `0${num}` : num
  }
  private hourConvert(hour) {
    return hour % 12 || 12
  }
  private async logout() {
    await UserStoreModule.Logout()

    this.$router.push(`/login?redirect=${this.$route.fullPath}`)
    let loading: any
    loading = Loading.service({
      fullscreen: true,
      text: 'Loading',
      spinner: 'el-icon-loading',
      background: 'rgba(0, 0, 0, 0.7)'
    })
    setTimeout(() => {
      window.location.reload()
    }, 100)
  }
}
</script>

<style lang="scss" scoped></style>
