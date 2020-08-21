var origString = "teacher teaches teachings"
var regex = RegExp('teach', 'g')
console.log(regex.exec(origString)); 
console.log(regex.exec(origString)); 
console.log(regex.exec(origString)); 

/*
[
[
  'teach',
  index: 0,
  input: 'teacher teaches teachings',
  groups: undefined
]
[
  'teach',
  index: 8,
  input: 'teacher teaches teachings',
  groups: undefined
]
[
  'teach',
  index: 16,
  input: 'teacher teaches teachings',
  groups: undefined
]
*/



console.log(regex.test(origString))  //true


console.log(origString.match(regex))
// [ 'teach', 'teach', 'teach' ]

origString = "Saran likes football and programming"
regex = /foot/
console.log(origString.search(regex))  //12

var replacedString = origString.replace(regex, 'basket')
console.log(replacedString)   //Saran likes basketball and programming

console.log(origString.split(' '))   //[ 'Saran', 'likes', 'football', 'and', 'programming' ]