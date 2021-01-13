<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script lang="ts">
import { Component, Vue, Watch } from 'vue-property-decorator'
import { PermissionModule } from '@/store/modules/permission/store'
import { SettingsModule } from '@/store/modules/settings/store'
import { AppStoreModule } from '@/store/modules/app/store'

@Component({
  name: 'App',
  components: {}
})
export default class extends Vue {
  created() {
    this.$i18n.locale = 'ko'
    AppStoreModule.SetLanguage('ko')
  }
}
</script>
