<template>
  <div v-if="!item.meta || !item.meta.hidden" class="full-mode">
    <template v-if="!alwaysShowRootMenu && theOnlyOneChild && !theOnlyOneChild.children">
      <sidebar-item-link v-if="theOnlyOneChild.meta" :to="resolvePath(theOnlyOneChild.path)">
        <el-menu-item :index="resolvePath(theOnlyOneChild.path)" :class="{ 'submenu-title-noDropdown': isFirstLevel }">
          <svg-icon v-if="theOnlyOneChild.meta.icon" :name="theOnlyOneChild.meta.icon" />
          <span v-if="theOnlyOneChild.meta.title" slot="title">{{ $t('route.' + theOnlyOneChild.meta.title) }}</span>
        </el-menu-item>
      </sidebar-item-link>
    </template>
    <el-submenu v-else :index="resolvePath(item.path)" popper-append-to-body>
      <template slot="title">
        <svg-icon v-if="item.meta && item.meta.icon" :name="item.meta.icon" />
        <span v-if="item.meta && item.meta.title" slot="title">{{ $t('route.' + item.meta.title) }}</span>
      </template>
      <template v-if="item.children">
        <sidebar-item v-for="child in item.children" :key="child.path" :item="child" :is-collapse="isCollapse" :is-first-level="false" :base-path="resolvePath(child.path)" class="nest-menu" />
      </template>
    </el-submenu>
  </div>
</template>

<script lang="ts">
import path from 'path'
import { Component, Prop, Vue } from 'vue-property-decorator'
import { Route, RouteConfig } from 'vue-router'
import { isExternal } from '@/utils/validate'
import SidebarItemLink from './SidebarItemLink.vue'

@Component({
  name: 'SidebarItem',
  components: {
    SidebarItemLink
  }
})
export default class extends Vue {
  @Prop({ required: true }) private item!: RouteConfig
  @Prop({ default: false }) private isCollapse!: boolean
  @Prop({ default: true }) private isFirstLevel!: boolean
  @Prop({ default: '' }) private basePath!: string

  get alwaysShowRootMenu() {
    if (this.item.meta && this.item.meta.alwaysShow) {
      return true
    }
    return false
  }

  get showingChildNumber() {
    if (this.item.children) {
      const showingChildren = this.item.children.filter(item => {
        if (item.meta && item.meta.hidden) {
          return false
        } else {
          return true
        }
      })
      return showingChildren.length
    }
    return 0
  }

  get theOnlyOneChild() {
    if (this.showingChildNumber > 1) {
      return null
    }
    if (this.item.children) {
      for (let child of this.item.children) {
        if (!child.meta || !child.meta.hidden) {
          return child
        }
      }
    }

    return { ...this.item, path: '' }
  }

  private resolvePath(routePath: string) {
    if (isExternal(routePath)) {
      return routePath
    }
    if (isExternal(this.basePath)) {
      return this.basePath
    }
    return path.resolve(this.basePath, routePath)
  }
}
</script>

<style lang="scss">
.full-mode {
  .el-menu-item {
    font-size: 16px;
    &:hover {
      background-color: #323640;
      font-size: 18px;
    }
  }
  .el-menu-item.is-active {
    background-color: #323640;
    border-left: solid 10px #358ed7;
    font-weight: bold;
    font-size: 20px;
  }
  .el-submenu {
    &__title {
      font-size: 16px;
      &:hover {
        background-color: #323640;
        font-size: 18px;
      }
    }
  }
  .el-menu {
    background-color: #323640;
    .nest-menu {
      .el-menu-item {
        font-size: unset;
        font-size: 14px;
        &:hover {
          background-color: #3d424f;
          font-size: 16px;
        }
      }

      .el-menu-item.is-active {
        background-color: unset;
        border-left: unset;
        font-weight: unset;
        font-size: unset;
        color: unset;
        background-color: #323640;
        font-weight: bold;
        font-size: 16px;
        color: #358ed7 !important;
      }
    }
  }

  .el-submenu.is-active .el-submenu__title {
    font-size: 20px;
    border-left: solid 10px #358ed7;
  }
}
</style>

<style lang="scss" scoped>
.svg-icon {
  margin-right: 16px;
}
</style>
