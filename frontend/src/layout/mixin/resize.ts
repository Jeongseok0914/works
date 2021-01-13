import { Component, Vue, Watch } from 'vue-property-decorator'
import { AppStoreModule, DeviceType } from '@/store/modules/app/store'

const WIDTH = 992 // refer to Bootstrap's responsive design

@Component({
  name: 'ResizeMixin'
})
export default class extends Vue {
  get device() {
    return AppStoreModule.device
  }

  get sidebar() {
    return AppStoreModule.sidebar
  }

  @Watch('$route')
  private onRouteChange() {
    // if (this.device === DeviceType.Mobile && this.sidebar.opened) {
    //   AppStoreModule.CloseSideBar(false)
    // }
  }

  beforeMount() {
    // window.addEventListener('resize', this.resizeHandler)
  }

  mounted() {
    // const isMobile = this.isMobile()
    // if (isMobile) {
    //   AppStoreModule.ToggleDevice(DeviceType.Mobile)
    //   AppStoreModule.CloseSideBar(true)
    // }
  }

  beforeDestroy() {
    // window.removeEventListener('resize', this.resizeHandler)
  }

  private isMobile() {
    // const rect = document.body.getBoundingClientRect()
    // return rect.width - 1 < WIDTH
  }

  private resizeHandler() {
    // if (!document.hidden) {
    //   const isMobile = this.isMobile()
    //   AppStoreModule.ToggleDevice(isMobile ? DeviceType.Mobile : DeviceType.Desktop)
    //   if (isMobile) {
    //     AppStoreModule.CloseSideBar(true)
    //   }
    // }
  }
}
