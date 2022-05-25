var express = require('express');
var router = express.Router();

var pool = require('../modules/mysql');

router.get('/', function(req, res){
    pool.query('SELECT * FROM emp', function (error, results, fields) {
        if (error) throw error;
        res.render('mysql/list', { list : results });
    });
});

router.post('/',function(req, res){
    pool.getConnection(function(err, conn){
        conn.beginTransaction(function(err){
            if (err) { throw err; }
            conn.query('INSERT INTO emp (empno, ename, sal) VALUES (?,?,?)', 
                [req.body.empno, req.body.ename, req.body.sal], 
                function (error, results, fields) {
                    if (error) {
                        return conn.rollback(function() { throw error; });
                    }
                    //conn.rollback();
                    conn.commit();
                    res.redirect('./');
                });
        });
    });
});

router.get('/:empno',function(req, res){
    var empno = parseInt(req.params.empno);
    
    pool.query('select * from emp where empno = ?',[empno],function(err, results,fields){
        res.render('mysql/emp', { bean : results[0] })
    });
});

router.put('/:empno',function(req, res){
    console.log(req.body);

    pool.query('UPDATE emp SET ename = ?, sal = ? where empno =?',[req.body.ename, req.body.sal, req.body.empno],function(err, results,fields){
        //console.log(results);
    });

    res.redirect('./');
});

router.delete('/:empno',function(req, res){
    console.log(req.params);

    pool.query('DELETE FROM emp WHERE empno = ? ',[req.params.empno],function(err, results,fields){
        if(err) console.log(err);
    });

    res.send();
});

module.exports = router;