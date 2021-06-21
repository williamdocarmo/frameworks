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

function builtinObjectDemo(){
    document.getElementById('field1').value = new Date();

    let person = {
        name: "Santanu",
        age: 31,
        fullTime: true
    };

    const el = document.getElementById('field3');
    el.style.color = 'red';
    el.style.fontFamily = 'algerian';
    el.value = JSON.stringify(person);

    let personData = "{\"name\":\"Santanu\",\"age\":31,\"fullTime\":true}";
    let pobj = JSON.parse(personData);

    alert("Person Name is: "+pobj.name);
}
//https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects

//Event Listener
const button = document.getElementById('btn4');
button.addEventListener('click', function(){
    document.getElementById('field4').value = 'Event Listener Worked!';
});

const button5 = document.getElementById('btn5');
button5.addEventListener('click', function(){
    const fieldToHide = document.getElementById('field5');
    alert(fieldToHide.value);
    fieldToHide.classList.remove('custom');
});

