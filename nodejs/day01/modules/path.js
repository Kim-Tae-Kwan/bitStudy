var path = require('path');
console.log(path.sep);
console.log(path.delimiter);

var msg = 'D:\\Development\\bitStudy\\nodejs'
console.log(path.resolve(msg));
console.log(path.parse(msg));
console.log(path.format(path.parse(msg)));
console.log(path.isAbsolute(msg));
console.log(path.isAbsolute('./ex01.js'));
console.log('=================================');
console.log(path.basename(msg));
console.log(path.dirname(msg));
console.log(path.extname(msg));
console.log(path.resolve('./ex01.js'));