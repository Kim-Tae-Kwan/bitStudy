var http = require('http');
var fs = require('fs');
var url = require('url');
var qs = require('querystring');

var arr = [];

var callback = function(req, res){
    if (req.url == '/'){
        res.statusCode = 200;
        res.setHeader('Content-Type','text/html;charset=utf-8');
        res.write('<h1>리스트 페이지</h1>');
        res.write('<table>');
        res.write('<tr>');
        res.write('<th>empno</th>');
        res.write('<th>ename</th>');
        res.write('<th>sal</th>');
        
        for(var emp of arr){
            res.write('</tr>');
            res.write('<td>' + emp.empno + '</td>');
            res.write('<td>' + emp.ename + '</td>');
            res.write('<td>' + emp.sal + '</td>');
            res.write('</tr>');
        }
        
        res.write('</table>');
        res.end('<a href="add.html">입력</a>');

    }else if(req.url.startsWith('/add.html')){
        res.statusCode = 200;
        res.setHeader('Content-Type','text/html;charset=utf-8');

        fs.readFile('web.html', function(err, data){
            if(err) console.log(err);
            res.end(data.toString());
        });
    }else if(req.url.startsWith('/result.html')){
        var q = url.parse(req.url).query;
        var params = qs.parse(q);

        console.log(params);
        arr.push(params);
        res.statusCode = 200;
        res.setHeader('Content-Type','text/html;charset=utf-8');
        res.write('<h1>성공</h1>')
        res.end(`
            <script>
                setTimeout(function(){location.href='./'},1000);
            </script>
        `);
    }else{
        res.statusCode = 404;
        res.end();
    }
};

http.createServer(callback).listen(7070,'localhost',function(err){
    console.log('서비스 중...');
});