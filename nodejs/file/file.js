var fs = require('fs');

console.log(fs);
var obj;
var callback = function(){
    console.log('비동기', obj);
};

// 비동기
fs.readFile('./ex01.js', function(err, data){
    // console.log(data);
    // console.log(data.toString());
    obj = data.toString();
    callback();
});

//동기
console.time('동기');
obj = fs.readFileSync('./ex01.js');
console.log('동기', obj.toString());
console.timeEnd('동기');



