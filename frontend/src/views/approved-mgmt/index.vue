<template>
  <div class="approved-mgmt">
    <div class="approved-mgmt-hearder">결재 관리</div>
    <list-form></list-form>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import ListForm from './ListForm.vue'
@Component({
  name: 'ApprovedMgmt',
  components: { ListForm }
})
export default class extends Vue {}
</script>

<style lang="scss" scoped>
.approved-mgmt {
  &-hearder {
    width: 100%;
    height: 100px;
    border: solid 1px grey;
    font-size: 30px;
    font-weight: bold;
    padding-left: 30px;
    line-height: 3;
    color: grey;
  }
}
</style>
