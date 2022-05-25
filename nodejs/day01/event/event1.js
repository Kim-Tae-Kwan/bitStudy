var evn = require('events');
var emit = new evn.EventEmitter();
emit.on('event1', function(e){
    console.log('이벤트1 발생');
});
emit.on('event2', function(e){
    console.log('이벤트2 발생');
});

var callback = function(e){
    console.log('이벤트3 발생');
}
emit.addListener('event3', callback);

console.log(emit.eventNames(), emit.listenerCount('event1'));
emit.emit('event1');
emit.emit('event2');

emit.removeListener('event3', callback);
emit.emit('event3');