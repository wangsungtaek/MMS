module.exports = {
  outputDir: '../src/main/resources/static',
  indexPath: '../static/index.html',
  devServer: {
    proxy: 'http://localhost:8080'
  },
  // devServer: {
  //   port: 3000,
  //   proxy: {
  //     '/api': {
  //       target: 'http://localhost:8080',
  //       ws: true,
  //       changeOrigin: true
  //     }
  //   }
  // },
}