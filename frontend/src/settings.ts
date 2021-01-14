interface ISettings {
  title: string // Overrides the default title
  showSettings: boolean // Controls settings panel display
  showTagsView: boolean // Controls tagsview display
  showSidebarLogo: boolean // Controls siderbar logo display
  fixedHeader: boolean // If true, will fix the header component
  errorLog: string[] // The env to enable the errorlog component, default 'production' only
  sidebarTextTheme: boolean // If true, will change active text color for sidebar based on theme
  devServerPort: number // Port number for webpack-dev-server
  // mockServerPort: number // Port number for mock server
  loginTime: number
}

// You can customize below settings :)
const settings: ISettings = {
  title: 'Jeongseok',
  showSettings: true,
  showTagsView: false,
  fixedHeader: false,
  showSidebarLogo: true,
  errorLog: ['production'],
  sidebarTextTheme: true,
  devServerPort: 9527,
  loginTime: 1800
}

export default settings
