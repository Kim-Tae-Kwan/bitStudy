var express = require('express');
var path = require('path');

var app = express()

// static 폴더 설정.
app.use(express.static(path.resolve(__dirname, '../public')));
// view 폴더 설정.
app.set('views', path.resolve(__dirname, '../views'));
// view template engine 추가.
app.set('view engine', 'ejs');
// json parsing
app.use(express.json());
// req.body
app.use(express.urlencoded({ extended: false }));

// Routing
var emp = require('./routers/emp');
var dept = require('./routers/dept');

app.use('/emp', emp);
app.use('/dept', dept);

app.listen(3000, function () {
  console.log('server start');
})