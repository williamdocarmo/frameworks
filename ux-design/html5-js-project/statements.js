function printObject() {
    let value1 = document.getElementById('value1').value;
    document.getElementById('demoRes').value = value1.length;

    let person = {
        firstname: 'Santanu',
        lastname: 'Bhattacharyya',
        age: 31
    }

    if (person.age > 30) {
        console.log("Age is more than 30")
    }

    if (person.age === 31) {
        console.log("Age is 31")
    }

    if (person.firstname == 'Santanu') {
        console.log("Hello, Santanu")
    }

    let n1 = 1.3;
    let n2 = 1.1;
    let n3 = 2.4;
    if ((n1 + n2).toFixed(2) == n3) {
        console.log('The sum is equal');
    } else {
        console.log('The sum is not equal');
    }

    console.log("Object is: " + typeof person)

    let value = '';
    for (let i = 1; i <= 5; i++) {
        value += i;
        console.log("Printing from For: " + i);
    }
    console.log("Final Value: " + value)

    let i = 5;
    while (i > 0) {
        console.log("Printing from While: " + i);
        i--;
    }

    i = 1;
    do {
        console.log("Printing from Do-While: " + i);
        i++;
    } while (i <= 5);



    document.getElementById('demoRes').value = person.firstname + ',' + person.lastname + ',' + person.age;
}

