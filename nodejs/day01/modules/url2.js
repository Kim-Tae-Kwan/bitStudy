var url = require('url');
var myUrl = new url.URL('https://www.google.com/search?sxsrf=ALiCzsbE73Z4mhVnl6yTn7AXSikpscknWQ:1653273528413&q=eol&spell=1&sa=X&ved=2ahUKEwi3r4Lry_T3AhUMIIgKHe6iD20QBSgAegQIARA2&biw=960&bih=968&dpr=1');
console.log(myUrl.origin);
console.log(myUrl.pathname);
console.log(myUrl.searchParams);
console.log(myUrl.searchParams.keys());
for(var key of myUrl.searchParams.keys()){
    console.log(key,' : ', myUrl.searchParams.get(key));
}