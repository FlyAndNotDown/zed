require('babel-core/register');
require('./src/index');
require('babel-core').transform('code', {
    plugins: ["transform-runtime"]
});