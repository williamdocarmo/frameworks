function mapDemo() {

    /* Declare Map */
    log("Declaring Map");
    let contacts = new Map();

    /* Add element */
    log("Adding elements in a map");
    contacts.set ("Santanu", {phone: "1234", email: "Email_1"})
    contacts.set ("Bhattacharyya", {phone: "5678", email: "Email_2"})
    log("Map: "+contacts);

    /* Check if Element Present */
    let present = contacts.has("Santanu");
    log("Is Present "+ present)

    let keys = contacts.keys();
    log ("Keys "+keys.next().value)

    log("Email of Santanu: "+contacts.get("Santanu").email)

    /* Parsing Map */
    log ("Parsing Map")
    contacts.forEach(
        function (element, key){
            log ("Phone no of "+key+" is "+element.phone)
        }

    );
    
    /* Deleting an Element */
    contacts.delete("Santanu");
    log ("Updated Map: "+contacts.size)

}

function log (content){
    console.log(content);
}