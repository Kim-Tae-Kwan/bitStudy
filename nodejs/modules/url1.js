var url = require('url');
var myUrl = 'https://www.google.com/search?sxsrf=ALiCzsbE73Z4mhVnl6yTn7AXSikpscknWQ:1653273528413&q=eol&spell=1&sa=X&ved=2ahUKEwi3r4Lry_T3AhUMIIgKHe6iD20QBSgAegQIARA2&biw=960&bih=968&dpr=1';

console.log(url.parse(myUrl));
console.log(url.parse(myUrl).pathname);
console.log(url.parse(myUrl).query);

var q = querystring.parse(url.parse(myUrl).query);
//console.log(q.where);