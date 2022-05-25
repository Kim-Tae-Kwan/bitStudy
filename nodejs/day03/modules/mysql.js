var mysql = require('mysql');
var pool  = mysql.createPool({
connectionLimit : 10,
host            : 'localhost',
user            : 'user01',
password        : '1234',
database        : 'scott'
});

module.exports = pool;