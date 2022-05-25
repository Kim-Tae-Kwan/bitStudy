var fs = require('fs');

// fs.mkdir('./test01', function(err, path){
//     if(err) console.log(err);
// });

// fs.rmdir('./test01',(err) => {
//     if (err) throw err;
//     console.log('path/file.txt was deleted');
//   });

// fs.open('ex22.js', 'w',function(err, num){
//     if(err) console.log(err);
//     else console.log(num)
// });

// fs.unlink('./ex22.js', function(err){
//     if(err) console.log(err);
// });

// fs.readdir('./',function(err, files){
//     if(err) console.log(err);
//     files.forEach(function(ele){
//         console.log(ele);
//     })
// });

// fs.copyFileSync('ex18.txt','ex19.txt');

fs.rename('ex18.txt', 'ex18New.txt',function(err){
    console.log(err);
});