var mysql = require('mysql');
var info = require('../myModule/bitmysql');
var express = require('express');

var router = express.Router();

router.get('/list', function (req, res) {
    var p = req.query.p != undefined ? parseInt(req.query.p) : 1;

    var conn = mysql.createConnection(info);
    //ALTER USER 'user01'@'localhost' IDENTIFIED WITH mysql_native_password BY '1234';
    conn.connect(function (err) {
        if (err) console.log(err);
        return;
    });

    var total;
    // 페이징 구현하기 위한 총 row 수.
    conn.query('SELECT count(*) as total from emp', function (error, results, fields) {
        total = results[0].total;
    });
    // 페이징 select
    conn.query('SELECT * from emp limit ?, 5', [5 * (p - 1)], function (error, results, fields) {
        if (error) throw error;
        res.render('emplist', { arr: results, total: total, p: p })
    });
    conn.end();
})

router.get('/add', function (req, res) {
    res.render('empadd', { obj: null })
})

router.post('/add', function (req, res) {
    req.setEncoding('utf-8');
    console.log(req.body)

    var connection = mysql.createConnection(info);

    connection.connect(function (err) {
        if (err) console.log(err);
    });

    //var sql = "INSERT INTO emp (empno, ename, sal, hiredate) VALUES (" + req.body.empno + ",'" +req.body.ename + "'," + req.body.sal + ",now())";
    var sql = "insert into emp (empno, ename, sal, hiredate) VALUES (?,?,?,now())";
    connection.query(sql, [req.body.empno, req.body.ename, req.body.sal], function (err, result) {
        if (err) {
            res.render('empadd', { obj: req.body });
            return;
        }
        connection.end();
        console.log("1 record inserted : ", result);
        res.redirect('list');
    });

})

router.get('/row', function (req, resp) {
    var conn = mysql.createConnection(info);

    conn.connect(function (err) {
        if (err) throw err;
    });
    conn.query('SELECT empno as "empno", ename as "ename", sal as "sal"  FROM emp WHERE empno = ?', [parseInt(req.query.empno)], function (err, result) {
        if (err) {
            console.log(err);
            return;
        };
        conn.end();
        resp.render("emp", { bean: result[0] });
    });

});

router.post('/row', function (req, res) {

    var conn = mysql.createConnection(info);

    conn.connect(function (err) {
        if (err) throw err;
        var sql = "UPDATE emp SET ename = ?, sal=? WHERE empno = ?";
        conn.query(sql, [req.body.ename, req.body.sal, req.body.empno], function (err, result) {
            if (err) throw err;
            console.log(result.affectedRows + " record(s) updated");
            res.redirect('list');
        });
    });
});

router.post('/delete', function (req, res) {
    var con = mysql.createConnection(info);

    con.connect(function (err) {
        if (err) throw err;
        var sql = "DELETE FROM emp WHERE empno = ?";
        con.query(sql, [req.body.empno], function (err, result) {
            if (err) throw err;
            console.log("Number of records deleted: " + result.affectedRows);
            if (result.affectedRows > 0) res.statusCode = 200;
            else res.statusCode = 500;
            res.end();
        });
    });
});

module.exports = router;