<template>
  <div class="drawer-container">
    <div class="btn-logout">
      <el-button type="text" @click.native="logout"> 로그아웃 <svg-icon name="part01-logout" /> </el-button>
    </div>
    <div class="drawer-item">
      <!-- <span>{{ $t('settings.theme') }}</span>
      <theme-picker style="float: right;height: 26px;margin: -3px 8px 0 0;" @change="themeChange" /> -->
    </div>
    <div>
      <h3 class="drawer-title">
        사용자 정보
      </h3>
      <div class="drawer-item">
        <el-card :body-style="{ padding: '0px' }" style="background:#454545; height: 145px;">
          <img v-if="env === 'production'" src="/scms/img/icons/sk_image.png" style="width:50px; height:50px; margin-left: 20px; margin-top:10px;" />
          <img v-else src="/img/icons/sk_image.png" style="width:50px; height:50px; margin-left: 20px; margin-top:10px;" />
          <div style="padding: 14px; color:#a59d9d; text-align:right;">
            <span>123213</span>
          </div>
        </el-card>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import { SettingsModule } from '@/store/modules/settings/store'
import { UserStoreModule } from '@/store/modules/user/store'
import { AppStoreModule } from '@/store/modules/app/store'
import { Loading } from 'element-ui'

@Component({
  name: 'Settings',
  components: {}
})
export default class extends Vue {
  get env() {
    return process.env.NODE_ENV
  }

  get fixedHeader() {
    return SettingsModule.fixedHeader
  }

  set fixedHeader(value) {
    SettingsModule.ChangeSetting({ key: 'fixedHeader', value })
  }

  get showTagsView() {
    return SettingsModule.showTagsView
  }

  set showTagsView(value) {
    SettingsModule.ChangeSetting({ key: 'showTagsView', value })
  }

  get showSidebarLogo() {
    return SettingsModule.showSidebarLogo
  }

  set showSidebarLogo(value) {
    SettingsModule.ChangeSetting({ key: 'showSidebarLogo', value })
  }

  get sidebarTextTheme() {
    return SettingsModule.sidebarTextTheme
  }

  set sidebarTextTheme(value) {
    SettingsModule.ChangeSetting({ key: 'sidebarTextTheme', value })
  }

  private themeChange(value: string) {
    SettingsModule.ChangeSetting({ key: 'theme', value })
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

<style lang="scss" scoped>
.drawer-container {
  .btn-logout {
    text-align: right;
    border-bottom: 1px solid #e86e3d;
    .el-button {
      margin-bottom: 10px;
      color: gray;
      border-color: transparent;
      background-color: transparent;
    }
  }
  padding: 24px;
  font-size: 14px;
  line-height: 1.5;
  word-wrap: break-word;

  .drawer-title {
    // border-bottom: 1px solid #e86e3d;
    margin-bottom: 12px;
    color: rgba(0, 0, 0, 0.85);
    font-size: 14px;
    line-height: 22px;
  }

  .drawer-item {
    color: rgba(0, 0, 0, 0.65);
    font-size: 14px;
    padding: 12px 0;
  }

  .drawer-switch {
    float: right;
  }
}
.bottom {
  text-align: right;
  line-height: 12px;
}
.clearfix:before,
.clearfix:after {
  display: table;
  content: '';
}

.clearfix:after {
  clear: both;
}
</style>
