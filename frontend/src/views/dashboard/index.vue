<template>
  <div>
    <dash-table></dash-table>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import DashTable from './DashTable.vue'
@Component({
  name: 'Dashboard',
  components: { DashTable }
})
export default class extends Vue {}
</script>

<style lang="scss" scoped></style>
