var myArray = [12,13,14,15,16,17,18,19]

console.log("Filtering")
myArray = myArray.filter((element) => (element >= 15))
console.log(myArray)


console.log("Print array value with index")
myArray.forEach((element, index) => {
    console.log(element, index)
})

console.log("Multiply each element by 10 and print")
myArray.map((element) => {
    element = element*10
    console.log(element)
})

/*
//Output:

Filtering
[ 15, 16, 17, 18, 19 ]
Print array value with index
15 0
16 1
17 2
18 3
19 4
Multiply each element by 10 and print
150
160
170
180
190

*/