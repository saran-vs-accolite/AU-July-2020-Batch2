var string1 = prompt("Enter a string: ")
regex1 = /^The.*hello$/
if(regex1.test(string1) == true) {
    console.log(string1, "passed Test1")
} else {
    console.log(string1, "failed Test1")
}

regex2 = /h[aeiou]?.t/
if(regex2.test(string1) == true) {
    console.log(string1, "passed Test2")
} else {
    console.log(string1, "failed Test2")
}

/*
Input: The sun is hoat and says hello
Output:
The sun is hoat and says hello passed Test1
VM1447:11 The sun is hoat and says hello passed Test2
*/