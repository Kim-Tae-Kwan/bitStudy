let obj = { 'key1' : 'val1' };
let obj2 = { key1 : 'val1' };
let obj3 = { ['key3'] : 'val1' };

//
var key4 = 'val4';
let obj4 = {key4};

//
let obj6 = {key1:1111, key2:2222}
obj6.key3 = 3333
obj6.key2 = 2

//
let obj7 = {...obj6, key1 : 1}
let obj8 = JSON.stringify(obj6);
let obj9 = JSON.parse(obj8);

//
let obj10 = { key1 : 123, key2 : 456}
let obj11 = { key1 : 789, key3 : 654}
let obj12 = Object.assign(obj10, obj11)

//
let obj13 = {function(){console.log('func01');}}
let obj14 = {func01 : function(){console.log('func01');}}
obj14.func01();

//console.log(obj12);