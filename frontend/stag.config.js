module.exports = {
  apps: [
    {
      name: '4c-dashboard',
      script: 'http-server',
      instances: '1',
      exec_mode: 'cluster',
      wait_ready: true,
      listen_timeout: 50000,
      kill_timeout: 5000,
      env: {
        PORT: '9100'
      }
    }
  ]
}
