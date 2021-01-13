import { getJsDateFromExcel } from 'excel-date-to-js'

export function excelDateToJs(val: number) {
  return getJsDateFromExcel(val)
}

export function getExcelKey(val: string) {
  const start = val.indexOf('(')
  const end = val.indexOf(')')
  return val.substring(start + 1, end)
}

export function isValidExcelKeyCheck(val: string) {
  const reg = /^[A-Za-z0-9+]*$/
  return reg.test(val)
}

export function setComma(num: number) {
  return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')
}

export function setTooltipStyle(color: any) {
  return '<span style="display:inline-block;margin-right:5px;border-radius:10px;width:9px;height:9px;background-color:' + color + '"></span>'
}

export function changeUnitCost(num: any) {
  return Math.round(Number(num / 10000))
}
export function deleteDecimal(num: any) {
  return Math.round(Number(num))
}

export const chartItemColor = [
  '#5abdbf',
  '#f1ba89',
  '#d57c82',
  '#b7a2de',
  '#3d87c1',
  '#eaabad',
  '#9cc4ab',
  '#f09f74',
  '#d9bfa5',
  '#6d97ab',
  '#387273',
  '#9680a4',
  '#d0a792',
  '#eb8985',
  '#6c8ba7',
  '#969d67',
  '#c2a9bf',
  '#6f8e8b',
  '#eaa69a',
  '#7a9b63',
  '#457f8e',
  '#6182c3',
  '#e17c9d',
  '#8c97b5'
]

export const chartMiddleTransparentColor = [
  'rgba(90, 189, 191, .7)', // base on #5ABDBF
  'rgba(241, 186, 137, .7)', // base on #F1BA89
  'rgba(213, 124, 130, .7)', // base on #D57C82
  'rgba(183, 162, 222, .7)', // base on #B7A2DE
  'rgba(61, 135, 193, .7)', // base on #3D87BF
  'rgba(234, 171, 173, .7)', // base on #EAABAD
  'rgba(156, 196, 171, .7)', // base on #9CC4AB
  'rgba(240, 159, 116, .7)', // base on #F09F74
  'rgba(217, 191, 165, .7)', // base on #D9BFA5
  'rgba(109, 151, 171, .7)', // base on #9BB8D5
  'rgba(56, 114, 115, .7)', // base on #387273
  'rgba(150, 128, 164, .7)', // base on #9680A4
  'rgba(208, 167, 146, .7)', // base on #D0A792
  'rgba(235, 137, 133, .7)', // base on #EB8985
  'rgba(108, 139, 167, .7)', // base on #6C8BA7
  'rgba(150, 157, 103, .7)', // base on #969D67
  'rgba(194, 169, 191, .7)', // base on #C2A9BF
  'rgba(111, 142, 139, .7)', // base on #6F8E8B
  'rgba(234, 166, 154, .7)', // base on #EAA69A
  'rgba(122, 155, 99, .7)', // base on #7A7363
  'rgba(69, 127, 142, .7)', // base on #457F8E
  'rgba(97, 130, 195, .7)', // base on #6182C3
  'rgba(225, 124, 157, .7)', // base on #E17C9D
  'rgba(140, 151, 181, .7)' // base on gray(#8C97B5)
]

export const chartLightTransparentColor = [
  'rgba(90, 189, 191, .4)', // base on #5ABDBF
  'rgba(241, 186, 137, .4)', // base on #F1BA89
  'rgba(213, 124, 130, .4)', // base on #D57C82
  'rgba(183, 162, 222, .4)', // base on #B7A2DE
  'rgba(61, 135, 193, .4)', // base on #3D87BF
  'rgba(234, 171, 173, .4)', // base on #EAABAD
  'rgba(156, 196, 171, .4)', // base on #9CC4AB
  'rgba(240, 159, 116, .4)', // base on #F09F74
  'rgba(217, 191, 165, .4)', // base on #D9BFA5
  'rgba(109, 151, 171, .4)', // base on #9BB8D5
  'rgba(56, 114, 115, .4)', // base on #387273
  'rgba(150, 128, 164, .4)', // base on #9680A4
  'rgba(208, 167, 146, .4)', // base on #D0A792
  'rgba(235, 137, 133, .4)', // base on #EB8985
  'rgba(108, 139, 167, .4)', // base on #6C8BA7
  'rgba(150, 157, 103, .4)', // base on #969D67
  'rgba(194, 169, 191, .4)', // base on #C2A9BF
  'rgba(111, 142, 139, .4)', // base on #6F8E8B
  'rgba(234, 166, 154, .4)', // base on #EAA69A
  'rgba(122, 155, 99, .4)', // base on #7A7363
  'rgba(69, 127, 142, .4)', // base on #457F8E
  'rgba(97, 130, 195, .4)', // base on #6182C3
  'rgba(225, 124, 157, .4)', // base on #E17C9D
  'rgba(140, 151, 181, .4)' // base on gray(#8C97B5)
]
