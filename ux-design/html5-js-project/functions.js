let showMessage = function(message, anotherMessage){
    alert(message);
    alert(anotherMessage);
    document.getElementById('demoRes').value = getMessage(message);

}

function getMessage(message){
    const returnmsg = "The Message is: " + message;
    return returnmsg;
}


let objectDemo = function(message, anotherMessage){

    let mySymbol = Symbol();

    let person = {
        name: "Santanu",
        age: 31,
        fullTime: true,
        [mySymbol]: 'secrets',

        toString: function() {
            return "Name: "+this.name+", Age: "+this.age+", FullTime: "+this.fullTime;
        }
    }

    person.age = 30;
    person['name'] = 'Santanu Bhattacharyya';

    increaseAge(person)

    alert(person.toString());

    document.getElementById('objRes').value = person.toString();

}

function increaseAge(person){
    person.age += 10;
}