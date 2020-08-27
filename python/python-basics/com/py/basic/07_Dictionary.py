''' Declaration '''
thisdict = {
  "fname": "Santanu",
  "lname": "Bhattacharyya",
  "age": 30
}

print("thisdict Dictionary After Creation: ", thisdict)
print("Length of the thisdict Dictionary: ",len(thisdict))

d = dict()
d["param1"] = "value1"
d["param2"] = "value2"
print("The d dictionary : ",d)

''' Insert Key '''
thisdict["location"] = "Kolkata"
print("Dictionary After Data Add: ", thisdict)
''' Read using Key '''
if "age" in thisdict:
    print("Age is present as a key and value is ",thisdict["age"])
print("Reading Age: ", thisdict["age"])
print("Reading fname: ", thisdict.get("fname"))

print("Going to print all keys and values")
for x in thisdict: # Prints all keys and corresponding values
    print(x, ":", thisdict[x])
   
print("Dictionary Items ",thisdict.items()) 
for x, y in thisdict.items():
    print(x, ":", y)

for x in thisdict.values():
    print("Value: " ,x)

''' Update Value '''
thisdict["age"] = 1990
print("Dictionary After Update: ", thisdict)

''' Delete Key '''
thisdict.pop("lname")
print("Dictionary After Delete: ", thisdict)
del thisdict["age"]
print("Dictionary After Delete: ", thisdict)

''' Clear, Copy '''
thisdict.clear()
print("Dictionary After Clear: ", thisdict)

thisdict = {
    "fname" : "Santanu",
    "lname" : "Bhattacharyya",
    "age" : 30
    }
thisdict1 = thisdict.copy()
print("Copied Dictionary : ",thisdict1)
thisdict2 = dict(thisdict)
print("Copied Dictionary : ",thisdict2)

##########################################################################
#clear: Clears the dictionary                                            #
#copy: Returns a copy of the dictionary                                  #
#get: Returns value for a key                                            #
#items: Returns a list of tuples with key-value                          #
#keys: Returns a list with all the keys                                  #
#values: Returns a list with all the values                              #                              #
##########################################################################