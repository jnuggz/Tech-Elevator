
function multiplyWithSpread(x, y, z) {
    return x + y + z;
}

const numsToMultiply = [1, 2, 3];

console.log( multiplyWithSpread( ...numsToMultiply) );

const largerArray = [1,2,3,4,5,6];
multiplyWithSpread( ...largerArray );

console.log( multiplyWithSpread(..."Hello"));

/*
      Anonymous Functions
*/

const doubleSum = function (x, y) {
    return (x + y) * 2;
}

doubleSum(2, 4);
let x = doubleSum;
x(2,4);

const tripleSum = (x, y) => {
    return (x + y) * 3;
}

function addSomething(x, y, func) {
    return 5 * func(x, y);
}

console.log( addSomething(2, 3, doubleSum) );
console.log( addSomething(2, 3, tripleSum) );
console.log( addSomething(2, 3, (x, y) => { 
    return (x + y) * 4;
}));

const arr = [1,2,3,4,5,6,7,8,9,10];

/*
 Array forEach()
*/
arr.forEach( (val) => {
    console.log(val);
});

let sum = 0;
arr.forEach( (val) => {
    sum += val;
});
console.log(sum);

/*
  Array reduce()
  */
let reducedSum = arr.reduce( (sum, currentValue) => {
    return sum + currentValue;
});

console.log(reducedSum);


const stringArr = ["A", "B", "C", "D", "E"];
let reducedString = stringArr.reduce( (newStr, currentValue) => {
    return newStr + " - " + currentValue;
});

console.log(reducedString);

/*
    Array.filter()
*/

let oddsOnly = arr.filter( (currentValue) => {
    // Return TRUE to keep the value and FALSE to reject it
    return currentValue % 2 !== 0;
});

console.log(oddsOnly);

const arrayOfObjects = [
    {
        name: 'A',
        value: 10
    },
    {
        name: 'B',
        value: 20
    },
    {
        name: 'C',
        value: 30
    },
    {
        name: 'D',
        value: 40
    },
    {
        name: 'E',
        value: 50
    }
]

const filteredArrayOfObjects = arrayOfObjects.filter( (currentObj) => {
    if (currentObj.value > 25) {
        return true;  // Keep the object in the new array 
    } 
    return false;  // Otherwise, do not keep the object
});

console.table(filteredArrayOfObjects);

/*
    Array.map() 
*/
let multipliedByTwo = arr.map( currentNumber => {
    return currentNumber * 2;
});
console.log(multipliedByTwo);


const numbersForFizzBuzz = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15];
let fizzArr = numbersForFizzBuzz.map( value => {
    if (!(value % 3) && !(value % 5)) {
        return 'FizzBuzz';
    }
    if ( !(value % 3)) {
        return 'Fizz';
    }
    if ( !(value % 5)) {
        return 'Buzz';
    }
    return value;
});
console.table(fizzArr);


/*
 Can use functions stored in variables as arguments to other functions, like filter(), map(), etc.
*/
const filterMultiplesOf3 = (x) => { 
    return x % 3;
};

let noMultiplesOf3 = numbersForFizzBuzz.filter(filterMultiplesOf3);

console.table(noMultiplesOf3);

function passThroughFunction( filterFunc ) {
    console.log( numbersForFizzBuzz.filter(filterFunc) );
}

/*
    find the sum of all numbers in the array multiplied by 10, for only numbers that are not multiples of 3
*/
const sumOfTheFinalArray = numbersForFizzBuzz.filter( val => {
    return val % 3;
}).map( val => { 
    return val * 10; 
}).reduce( (sum, val) => {
    return sum + val;
});

console.table(sumOfTheFinalArray)


let theArray = [1,2,3,4,5,6,7,8,9]; 
let filteredArray = theArray.filter( 
    (element) => { return element % 2 === 0; } 
);
console.log(filteredArray)
// newArray = [2, 4, 6, 8]

// ( cumulatedValue, currentValue)
function reduceExample() {
    console.table(theArray);
    let reducedValue = theArray.reduce( (cumulatedValue, currentValue) => {
        return cumulatedValue + currentValue;
    }, 0);
    console.log(reducedValue);

    console.table(arrayOfObjects);

    let reducedArrayOfObjects = arrayOfObjects.reduce( (cumulated, current) => {
        return cumulated += current.name;
    }, '');
    console.log(reducedArrayOfObjects);

}