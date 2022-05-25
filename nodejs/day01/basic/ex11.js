var callback = function(){
    console.log(process.pid, 'running...');
};
setInterval(callback, 1000);