module.exports = {
  configureWebpack: {
    resolve: {
      alias: {
        '@': '/home/lucas/Projects/pi-chat/client/src'
      },
      extensions: [
        '.js',
        '.vue',
        '.json'
      ]
    },
    output: {
      libraryExport: 'default'
    }
  },
  transpileDependencies: [
    'vuetify'
  ]
}
