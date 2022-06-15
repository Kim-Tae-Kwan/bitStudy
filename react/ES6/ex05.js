var arr1 = ['item1', 'item2', 'iten3'];

// for(i=0; i<arr1.length; i++){
//     console.log(arr1[i]);
// }

// for(let idx in arr1){
//     console.log(arr1[idx]);
// }

// for(let item of arr1){
//     console.log(item);
// }

// // return -> 없음(undefined)
// let result1 = arr1.forEach(function(ele, idx){
//     console.log(ele, idx);
// });
// console.log('-------------------------------------');

// // return -> Array, undefined 포함.
// let result2 = arr1.map(function(ele, idx){
//     console.log(ele, idx);
//     return ele;
// });
// console.log('-------------------------------------');

// // return -> Array, undefined 미포함.
// let result3 = arr1.filter(function(ele, idx){
//     console.log(ele, idx);
//     return ele;
// });
// console.log('-------------------------------------');

// // return -> First Element
// let result4 = arr1.find(function(ele, idx){
//     console.log(ele, idx);
//     return ele == 'item2';
// });
// console.log('-------------------------------------');

// let result5 = arr1.every(function(ele, idx, arr){
//     console.log(ele, idx, arr)
//     return false;
// });

// let result6 = arr1.some(function(ele, idx, arr){
//     console.log(ele, idx, arr)
//     return true;
// });

// let arr2 = [1,3,5,7,9];
// let result7 = arr2.reduce(function(total,ele,idx,arr){
//     console.log(total,ele,idx,arr);
//     return total + ',' + ele;
// });

console.log(result7);