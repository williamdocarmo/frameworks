function updateFirstline () {
    document.getElementById('firstLine').textContent = 'Set from JS ';
}

function printName() {
    let x = document.getElementById('firstName').value;
    let y = document.getElementById('lastName').value;
    document.getElementById('fullName').value = x+y;
}

function printFullname() {
    let fname = document.getElementById('fname').value;
    let lname = document.getElementById('lname').value;
    document.getElementById('completeName').value = fname + ' ' + lname;
}


function variableDemo() {
    let num1 = 10.50;

    let name = "Santanu";

    let isDiscounted = true;
}

function printFinalPrice() {
    const discount = 10;

    var mrp = document.getElementById('mrp').value; 
    document.getElementById('finalPrice').value = mrp - discount;

    document.getElementById('result').textContent = typeof discount;

}

function printLength() {
    let str1 = document.getElementById('value1').value;
    document.getElementById('demoRes').value = str1.length;
}

function upperCase() {
    let str1 = document.getElementById('value1').value;
    document.getElementById('demoRes').value = str1.toUpperCase();
}


function substring(index) {
    let str1 = document.getElementById('value1').value;
    document.getElementById('demoRes').value = typeof str1;
}

function printSum(){
    let n1 = document.getElementById('number1').value;
    let n2 = document.getElementById('number2').value;
    document.getElementById('sum').textContent = Number.parseFloat(n1) + Number.parseFloat(n2);
}

function checkEquality(){
    let n1 = document.getElementById('x').value;
    let n2 = document.getElementById('y').value;
    document.getElementById('checkEquality').textContent = (n1 == n2);
}