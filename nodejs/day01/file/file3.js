var fs = require('fs');
var ws = fs.createWriteStream('ex18.txt');
ws.write('한번 작성\n');
ws.write('다시 한번 작성');
ws.close();