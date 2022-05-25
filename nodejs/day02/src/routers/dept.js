
var express = require('express');
const res = require('express/lib/response');
var mongo = require('mongodb')

var router = express.Router();

router.get('/list', function(req, res){
    var p = req.query.p != undefined ? parseInt(req.query.p) : 1;

    var MongoClient = mongo.MongoClient;
    var url = "mongodb://localhost:27017/";

    MongoClient.connect(url, function(err, db) {
        if (err) throw err;
        
        var total;
        var dbo = db.db("testDB");
        var coll = dbo.collection("emp");

        coll.count({}, function(err, tot){
            total = tot;
        });

        var cur = coll.find({}).skip(5 * (p - 1)).limit(5);
        cur.toArray(function(err, result) {
            if (err) throw err;
            res.render('dept/list', {p : p, total : total, arr : result});
            db.close();
        });
    });
    
});

router.get('/add', function(req, res){
    res.render('dept/add');
});

router.post('/add', function(req, res){
    var MongoClient = require('mongodb').MongoClient;
    var url = "mongodb://localhost:27017/";
    
    MongoClient.connect(url, function(err, db) {
      if (err) throw err;
      var dbo = db.db("testDB");
      var myobj = { empno: req.body.empno, ename: req.body.ename, sal : req.body.sal };

      dbo.collection("emp").insertOne(myobj, function(err, result) {
        if (err) throw err;
        console.log("1 document inserted", result);
        db.close();
        res.redirect('list');
      });
    });
});

router.get('/row', function(req, res){
    var empno = req.query.empno;

    var MongoClient = require('mongodb').MongoClient;
    var url = "mongodb://localhost:27017/";

    MongoClient.connect(url, function(err, db) {
        if (err) throw err;
        var dbo = db.db("testDB");
        dbo.collection("emp").findOne({_id : new mongo.ObjectId(empno)}, function(err, result) {
            if (err) throw err;
            db.close();
            res.render('dept/emp', { bean : result })
        });
    });
});

router.post('/row', function(req, res){
    var MongoClient = require('mongodb').MongoClient;
    var url = "mongodb://127.0.0.1:27017/";

    MongoClient.connect(url, function(err, db) {
        if (err) throw err;
        var dbo = db.db("testDB");
        var myquery = { _id: new mongo.ObjectId(req.body._id) };

        var newvalues = { $set: {empno: parseInt(req.body.empno), ename: req.body.ename } };
        if(req.body.sal){
            newvalues[$set].sal = parseInt(req.body.sal);
        }

        dbo.collection("emp").updateOne(myquery, newvalues, function(err, res) {
            if (err) throw err;
            console.log("1 document updated");
            db.close();
        });
    });

    res.redirect('list');
});

module.exports = router;