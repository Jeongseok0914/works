/** Layout **/
export const Layout = () => import('@/layout/index.vue')

/** Comn **/
export const rediredct = () => import('@/views/redirect/index.vue')
export const login = () => import('@/views/login/index.vue')
export const authRedirect = () => import('@/views/login/auth-redirect.vue')
export const error404Page = () => import('@/views/error-page/404.vue')
export const error401Page = () => import('@/views/error-page/401.vue')

/** Biz */
export const approvedMgmt = () => import('@/views/approved-mgmt/index.vue')
export const approvedWrite = () => import('@/views/approved-write/index.vue')
