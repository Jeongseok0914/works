<template>
  <div>
    <use-mgmt></use-mgmt>
    <obstacle-mgmt></obstacle-mgmt>
    <dash-table></dash-table>
    <back-to-top :visibility-height="300" :back-position="50" transition-name="fade" />
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import UseMgmt from './UseMgmt.vue'
import ObstacleMgmt from './ObstacleMgmt.vue'
import { dashboard } from '../../router/modules/router-constants'
import DashTable from './DashTable.vue'
import BackToTop from '@/components/BackToTop/index.vue'
@Component({
  name: 'Dashboard',
  components: { UseMgmt, ObstacleMgmt, DashTable, BackToTop }
})
export default class extends Vue {}
</script>

<style lang="scss" scoped></style>
