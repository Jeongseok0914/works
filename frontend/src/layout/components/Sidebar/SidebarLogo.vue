<template>
  <div class="sidebar-logo-container">
    <div class="sidebar-logo-link">
      <div class="sidebar-title">
        <!-- <img src="@/assets/images/icon-logo.png" /> -->
      </div>
    </div>
    <div class="sidebar-logo-user">
      <div class="sidebar-image">
        <img src="@/assets/images/icon-admin-user.png" />
      </div>
      <div class="sidebar-title">
        <div class="text1">홍길동</div>
        <div class="text2">EUMC MOKDONG 원무</div>
        <div class="text3">Administator</div>
        <el-button class="button-1" type="text" @click.native="logout()"><img src="@/assets/images/icon-out.png"/></el-button>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator'
import { UserStoreModule } from '@/store/modules/user/store'
import { SettingsModule } from '@/store/modules/settings/store'
import { Loading } from 'element-ui'
import router from '@/router'
@Component({
  name: 'SidebarLogo'
})
export default class extends Vue {
  @Prop({ required: true }) private collapse!: boolean
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
.sidebarLogoFade-enter-active {
  transition: opacity 1.5s;
}

.sidebarLogoFade-enter,
.sidebarLogoFade-leave-to {
  opacity: 0;
}

.sidebar-logo-container {
  position: relative;
  width: 100%;
  height: 200px;
  /* margin-top: 9%; */
  background: #3d424e;
  /* overflow: hidden; */
  & .sidebar-logo-user {
    width: 100%;
    height: 100px;

    & .sidebar-image {
      display: inline-block;
      margin-left: 20px;
      margin-top: 20px;
      font-size: 20px;
    }
    & .sidebar-title {
      position: absolute;
      width: 182px;
      height: 60px;
      margin-left: 90px;
      margin-top: -59px;
      .text1 {
        color: #fff;
        font-size: 15px;
        font-weight: 500;
        font-stretch: normal;
        font-style: normal;
        line-height: normal;
        letter-spacing: normal;
        text-align: left;
      }
      .text2 {
        color: #fff;
        font-size: 15px;
        font-weight: 500;
        font-stretch: normal;
        font-style: normal;
        line-height: normal;
        letter-spacing: normal;
        text-align: left;
      }
      .text3 {
        color: #c5c6ca;
        font-size: 12px;
        font-weight: 500;
        font-stretch: normal;
        font-style: normal;
        line-height: normal;
        letter-spacing: normal;
        text-align: left;
      }
      .button-1 {
        position: absolute;
        margin-left: 180px;
        margin-top: -66px;
      }
    }
  }

  & .sidebar-logo-link {
    width: 100%;
    height: 100px;
    background-color: #323640;
    & .sidebar-title {
      display: inline-block;
      margin: 0;
      margin-left: 45px;
      color: #324157;
      margin-top: 35px;
    }
  }

  &.collapse {
    .sidebar-logo {
      margin-right: 0px;
    }
  }
}
</style>
