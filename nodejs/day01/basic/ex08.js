var callback = function(){
    console.log('실행');
};

console.log('start');

setTimeout(function(){
    console.log('실행3');
}, 1000);

var call = setImmediate(callback);
clearImmediate(call);
console.log('end');