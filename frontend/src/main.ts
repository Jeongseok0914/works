import Vue from 'vue'
import App from '@/App.vue'
import store from '@/store'
import router from '@/router'
import i18n from '@/lang'
import ElementUI from 'element-ui'
import SvgIcon from 'vue-svgicon'

import '@/plugins/lodash'
import '@/plugins/vTooltip'
import '@/plugins/excel'

import '@/styles/element-variables.scss'
import '@/styles/index.scss'
import '@/utils/vee-validate'
import '@/icons/components'
import '@/permission'
import 'normalize.css'
import 'default-passive-events'

import infiniteScroll from 'vue-infinite-scroll'
import Rx from 'rxjs/Rx'
import VueRx from 'vue-rx'

import { AppStoreModule } from '@/store/modules/app/store'

Vue.use(ElementUI, {
  size: AppStoreModule.size,
  i18n: (key: string, value: string) => i18n.t(key, value)
})

Vue.use(SvgIcon, {
  tagName: 'svg-icon'
})

Vue.use(infiniteScroll)
Vue.use(VueRx, Rx)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  i18n,
  render: h => h(App)
}).$mount('#app')
