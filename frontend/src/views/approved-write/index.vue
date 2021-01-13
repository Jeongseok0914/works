<template>
  <div class="approved-write">
    <div class="approved-write-hearder">문서 작성</div>
    <write-form></write-form>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import WriteForm from './WriteForm.vue'
@Component({
  name: 'ApprovedWrite',
  components: { WriteForm }
})
export default class extends Vue {}
</script>

<style lang="scss" scoped>
.approved-write {
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
