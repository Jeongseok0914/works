import Vue from 'vue'
import VueLodash from 'vue-lodash'

import { random, map, set, cloneDeep, toString, isNumber, debounce } from 'lodash'

Vue.use(VueLodash, { name: 'custom', lodash: { map, random, set, cloneDeep, toString, isNumber, debounce } })
