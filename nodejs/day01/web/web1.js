var http = require('http');

var server = http.createServer(function(req, resp){
    console.log(req.url, req.method);

    resp.statusCode = 404;
    resp.setHeader('Content-Type','text/html;charset=utf-8');
    resp.write('<h1>Hello World</h1>');
    resp.end();
});

server.listen(7070, function(){
    console.log('서버가 리슨중..');
});
