const path = require('path');

module.exports = {
  mode: 'development', // Set the mode to 'development' or 'production'
  entry: './src/js/main.js',
  output: {
    filename: 'bundle.js',
    path: path.resolve(__dirname, 'dist'),
  },
};
