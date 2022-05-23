var express = require('express');
var app = express();

// 정적 파일 읽기
// path로 파일 명만 주면 댐
// ex) localhost:7070/web.html
app.use(express.static('static'));

// post body 받기
app.use(express.json()) // for parsing application/json
app.use(express.urlencoded({ extended: true })) // for parsing application/x-www-form-urlencoded

//app.set('view engine', 'pug');
app.set('view engine', 'ejs');

app.get('/', function(req, resp){
    resp.setHeader('content-type','text/html; charset=utf-8');
    resp.render('index', { title: 'Hey', kim: 'Hello there!'});
});
app.post('/add.html', function(req, resp){
    console.log(req.body);
    resp.setHeader('content-type','text/html; charset=utf-8');
    resp.end('<h1>새로운 페이지</h1>');
});



app.listen(7070,function(){
    console.log('start...')
});