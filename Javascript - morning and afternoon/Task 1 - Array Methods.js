//NOTE: For each method output is specified in comments next to the console.log for the respective method


var myArray = [1,2,3,4,5]
var concatArray = myArray.concat([6,7,8])
console.log(concatArray)   // [1, 2, 3, 4, 5, 6, 7, 8]

var evenArray = [2,4,6,8]
console.log(evenArray.every((element) => (element%2===0)))   // true

myArray = [1,2,3,4,5,6,7,8,9,10]
var filteredArray = myArray.filter((element) => (element%3===0))
console.log(filteredArray)    // [ 3, 6, 9 ]

evenArray.forEach((element, index, array) => (console.log(element,index,array)))
/* 2 0 [ 2, 4, 6, 8 ]
4 1 [ 2, 4, 6, 8 ]
6 2 [ 2, 4, 6, 8 ]
8 3 [ 2, 4, 6, 8 ] */

console.log(myArray.indexOf(4))    //3

console.log(myArray.join())        //1,2,3,4,5,6,7,8,9,10

myArray = [1,2,3,4,1,2]
console.log(myArray.lastIndexOf(1))   //4

var mappedArray = myArray.map((element) => element*2)
console.log(mappedArray)              //[ 2, 4, 6, 8, 2, 4 ]

console.log(myArray.pop(), myArray)  //2 [ 1, 2, 3, 4, 1 ]

console.log(myArray.push(2), myArray)  //6 [ 1, 2, 3, 4, 1, 2 ]

reducedValue = myArray.reduce((total, element) => total+element)
console.log(reducedValue)    //13

reducedValue = myArray.reduceRight((total, element) => total-element)
console.log(reducedValue)  //-9

myArray.reverse()
console.log(myArray)                //[ 2, 1, 4, 3, 2, 1 ]

console.log(myArray.shift(), myArray)   //2 [ 1, 4, 3, 2, 1 ]

console.log(myArray.slice(3), myArray)  //[ 2, 1 ] [ 1, 4, 3, 2, 1 ]

console.log(evenArray.some((element) => (element%2===0)))   //true

// console.log(myArray.toSource());    //Expected Output: [1,4,3,2,1]  -> however mde obsolete and doesnt work nowadays

myArray.sort()
console.log(myArray)          //[ 1, 1, 2, 3, 4 ]

console.log(myArray.splice(3), myArray)             //[ 3, 4 ] [ 1, 1, 2 ]

console.log(myArray.toString())                     //1,1,2

console.log(myArray.unshift(5), myArray)             //4 [ 5, 1, 1, 2 ]