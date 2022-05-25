var express = require('express');
var router = express.Router();

var Emp  = require('../modules/mongoose')

router.get('/', function(req, res){
    Emp.find(function(error,results){
        if (error) throw error;
        res.render('mongoose/list', { list : results });
    });
});

router.post('/',function(req, res){
    var newEmp = new Emp(req.body);

    newEmp.save(function(){
        res.redirect('./');
    });
});

router.get('/add.html', function(req, res){
    res.render('mongoose/add');
});

router.get('/:_id',function(req, res){
    Emp.findOne({_id: req.params._id}, function(error,result){
        res.render('mongoose/emp', {bean : result})
    });
});

router.put('/:_id',function(req, res){
    Emp.findById({_id : req.params._id}, function(error,emp){
        if(error){
            console.log(error);
        }else{
            emp.empno = req.body.empno;
            emp.ename = req.body.ename;
            emp.sal = req.body.sal;
            emp.save();
        }
    });

    res.redirect('./');
});

router.delete('/:_id',function(req, res){
    console.log(req.params);

    Emp.deleteOne({_id:req.params._id}, function(error,output){
        if(error){
            console.log(error);
        }
    });

    res.send();
});

module.exports = router;