var fs = require('fs');
var rs = fs.createReadStream('ex18.txt');

rs.on('data', function(fileData){
    console.log('읽기 : ', fileData) ;
})

rs.on('end', function(){
    console.log('읽기 종료') ;
    rs.close();
})