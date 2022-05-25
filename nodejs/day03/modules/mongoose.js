var mongoose = require('mongoose');
mongoose.connect('mongodb://localhost:27017/testDB');
var db = mongoose.connection;
db.on('error', function(){
    console.log('Connection Failed!');
});
db.once('open', function() {
    console.log('Connected!');
});

var emp = mongoose.Schema({
    empno : 'number',
    ename : 'string',
    sal : 'number'
});

var Emp = mongoose.model('Schema', emp);

module.exports = Emp;