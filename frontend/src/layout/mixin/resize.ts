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
  private onRouteChange() {}

  beforeMount() {}

  mounted() {}

  beforeDestroy() {}

  private isMobile() {}

  private resizeHandler() {}
}
