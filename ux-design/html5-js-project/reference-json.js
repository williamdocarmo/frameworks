function jsonDemo() {

    let person = {
        name: "Santanu",
        email: "Email_1",
        phone: "9903"
    }

    log ("JSON String is: "+JSON.stringify(person))

    let jsonString = "{\"username\":\"santanu\", \"password\":\"secret\", \"role\":\"3\"}";
    let userObj = JSON.parse(jsonString);
    log("Object: "+userObj.password)

}

function log (content){
    console.log(content);
}