module.exports = {
    host: '127.0.0.1',
    user: process.env.MYSQL_USER ? process.env.MYSQL_USER : 'user01',
    password: process.env.MYSQL_PASSWORD ? process.env.MYSQL_PASSWORD : '1234',
    database: 'scott'
}
