import { Notification, MessageBox, Message } from 'element-ui'

export const MessageService = {
  notiSuccess: (msg: string) => Notification.success({ title: 'Success', message: msg, position: 'top-right' }),
  notiWarning: (msg: string) => Notification.warning({ title: 'Warning', message: msg, position: 'top-right' }),
  notiInfo: (msg: string) => Notification.info({ title: 'Info', message: msg, position: 'top-right' }),
  notiError: (msg: string) => Notification.error({ title: 'Error', message: msg, position: 'top-right' }),
  MsgBoxConfirm: (msg: string[]) => MessageBox.confirm(msg[0], msg[1], { confirmButtonText: msg[2], cancelButtonText: msg[3], type: 'warning' }),
  MsgError: (msg: string) => Message.error({ message: msg, duration: 5 * 1000 })
}
