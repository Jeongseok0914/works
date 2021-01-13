<template>
  <div class="login-container">
    <div class="login-container-sub">
      <el-form ref="loginForm" :model="loginForm" class="login-form" autocomplete="on" label-position="left">
        <div class="title-container">
          <!-- <img src="@/assets/images/icon-logo-yi.png" /> -->
          <h3 class="title"></h3>
        </div>

        <el-form-item prop="userId">
          <span class="svg-container">
            <svg-icon name="user" />
          </span>
          <el-input ref="userId" v-model="loginForm.userId" name="userId" type="text" autocomplete="on" />
        </el-form-item>

        <el-form-item prop="userPwd">
          <span class="svg-container">
            <svg-icon name="password" />
          </span>
          <el-input :key="passwordType" ref="userPwd" v-model="loginForm.userPwd" :type="passwordType" name="userPwd" autocomplete="on" @keyup.enter.native="handleLogin" />
        </el-form-item>

        <el-button class="login-btn" type="primary" @click.native="handleLogin">{{ $t('login.login') }}</el-button>
      </el-form>
    </div>

    <div class="version-btn-warpper">
      <el-button type="text" @click.native="showVersionDialog = true" style="color: #898b98;">Version Info</el-button>
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue, Watch } from 'vue-property-decorator'
import { Route } from 'vue-router'
import { Dictionary } from 'vue-router/types/router'
import { Form as ElForm, Input } from 'element-ui'
import { UserStoreModule } from '@/store/modules/user/store'
import { isValidUsername } from '@/utils/validate'
import VersionPopup from './VersionPopup.vue'

@Component({
  name: 'Login',
  components: {}
})
export default class extends Vue {
  private loginForm = {
    userId: 'test1',
    userPassword: 'asdf'
  }
  private passwordType = 'password'
  private showDialog = false
  private redirect?: string
  private otherQuery: Dictionary<string> = {}

  @Watch('$route', { immediate: true })
  private onRouteChange(route: Route) {
    const query = route.query as Dictionary<string>
    if (query) {
      this.redirect = query.redirect
      this.otherQuery = this.getOtherQuery(query)
    }
  }
  mounted() {}

  private handleLogin() {
    ;(this.$refs.loginForm as ElForm).validate(async (valid: boolean) => {
      if (valid) {
        await UserStoreModule.Login(this.loginForm).then(async (resolve: any) => {
          if (resolve === 200) {
            await this.$router.push(
              {
                path: '/'
              },
              () => {}
            )
          }
        })
      } else {
        return false
      }
    })
  }

  private getOtherQuery(query: Dictionary<string>) {
    return Object.keys(query).reduce((acc, cur) => {
      if (cur !== 'redirect') {
        acc[cur] = query[cur]
      }
      return acc
    }, {} as Dictionary<string>)
  }
}
</script>

<style lang="scss">
.login-container {
  .login-container-sub {
    width: 510px;
    height: 516px;
    margin-top: 110px;
    border-radius: 21px;
    margin-left: 35vw;
    background-color: #000000;
    .el-input {
      display: inline-block;
      height: 60px;
      width: 85%;
      input {
        height: 60px;
        background: transparent;
        border: 0px;
        border-radius: 0px;
        padding: 12px 5px 12px 15px;
        color: $lightGray;
        caret-color: $loginCursorColor;
        -webkit-appearance: none;
        &:-webkit-autofill {
          box-shadow: 0 0 0px 1000px $loginBg inset !important;
          -webkit-text-fill-color: #fff !important;
        }
      }
      input::first-line {
        color: $lightGray;
      }
    }
    .el-form-item {
      border: 1px solid rgba(255, 255, 255, 0.1);
      background: rgba(0, 0, 0, 0.1);
      border-radius: 5px;
      color: #454545;
    }
  }
  .login-container-dig {
    .el-form-item {
      margin-top: 2%;
      label {
        font-size: 14px;
        width: 100px;
      }
      .el-input {
        input {
          color: #000000;
          background: transparent;
          -webkit-appearance: none;
        }
      }
    }
  }
}
</style>

<style lang="scss" scoped>
.login-container {
  height: 100%;
  width: 100%;
  overflow: hidden;
  background-color: $loginBg;
  // background-image: url('~@/assets/images/bg.png');
  background-repeat: no-repeat; /* 반복 안함 */
  background-size: cover;
  .login-form {
    position: relative;
    width: 520px;
    max-width: 100%;
    padding: 70px 35px 0;
    margin: 0 auto;
    overflow: hidden;
    .login-btn {
      width: 100%;
      margin-bottom: 30px;
      margin-top: 30px;
      height: 60px;
      border-radius: 30px;
      background-color: #ff7200;
      border-color: transparent;
    }
  }

  .tips {
    font-size: 14px;
    color: #fff;
    margin-bottom: 10px;

    span {
      &:first-of-type {
        margin-right: 16px;
      }
    }
  }

  .svg-container {
    padding: 6px 5px 6px 15px;
    color: $darkGray;
    vertical-align: middle;
    width: 30px;
    display: inline-block;
  }

  .title-container {
    position: relative;
    width: 100%;
    background-color: #000000;
    text-align: center;
    .title {
      font-size: 26px;
      color: white;
      text-shadow: offset-x offset-y blur-radius color inherit;
      margin: 80px auto 40px auto;
      text-align: center;
      font-weight: 800;
    }

    .set-language {
      color: #fff;
      position: absolute;
      top: 3px;
      font-size: 18px;
      right: 0px;
      cursor: pointer;
    }
  }

  .show-pwd {
    position: absolute;
    right: 10px;
    top: 7px;
    font-size: 16px;
    color: $darkGray;
    cursor: pointer;
    user-select: none;
  }
  .thirdparty-button-group {
    position: relative;
    height: 30px;
    .el-button {
      border-color: transparent;
      background-color: transparent;
    }
  }
  .thirdparty-button-left {
    position: absolute;
    left: 0;
    bottom: 6px;
  }
  .thirdparty-button-right {
    position: absolute;
    right: 0;
    bottom: 6px;
  }

  .version-btn-warpper {
    position: absolute;
    right: 20px;
    bottom: 5px;
  }

  @media only screen and (max-width: 470px) {
    .thirdparty-button {
      display: none;
    }
  }
}
</style>
