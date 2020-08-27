var = 'Hello, Python!'

print (var)              # Prints complete var

''' Strings are Array '''
print ("Zeroeth Index %s" %var[0])                                     # Prints first character of the var
print ("Zeroeth Index 3 to 5 %s" %var[2:5])                            # Prints characters starting from 3rd to 5th
print ("Index 5th Last to Last %s" %var[-5:-1])                        # Prints characters from last to 5th to last
print ("Index 3 to last %s" %var[2:])                                  # Prints var starting from 3rd character
print ("Index 0 to 5th %s" %var[:5])                                   # Prints var ending in 5th character
print ("Copy the String thrice %s" %var*3)                             # Prints var two times
''' String Concatenation '''
print ("Concateneated String: %s" %var+" Test")                        # Prints concatenated var

''' Other objects can be coverted to String '''
x = True
print ("String of X "+x.__str__())

x = 10
print ("String of X "+str(x))

''' Multiline String '''
str2 = '''I am printing
a multiline string
which I am going to test'''
print ("Printing multiline string \n%s" %str2)

''' Calculate length of a String '''
print ("Length of the String is %s" %var.__len__())
print ("Length of the String is %s" %len(var))

''' Change case of a String '''
print ("Is it in Lower Case? %s" %var.islower())
print ("Is it in Lower Case? %s" %var.lower().islower())    #Prints True
print ("Is it in Upper Case? %s" %var.isupper())
print ("Is it in Upper Case? %s" %var.upper().isupper())    #Prints True

''' Replace something in a String (Original object still remains same)'''
print ("Replacing Python with Java %s" %var.replace('Python', 'Java'))
print ("Printing Original Object %s" %var)

''' Split and Trim '''
splittedArray = var.split(',');
print ("Zeroeth Element of Splitted Array: %s" %splittedArray[0])
print ("First Element of Splitted Array: %s" %splittedArray[1])
print ("First Element of Splitted Array After Strip: %s" %splittedArray[1].strip())

''' Check 'Contains' logic'''
print ("String Contains 'Python'? %s" %("Python" in var))    # Returns True
print ("String Contains 'Java'? %s" %('Java' in var))    # Returns False

''' String formatting '''
name = 'Santanu'
age = 30
experience = 8.1
description = "My name is {}, my age is {} and total experience is {}."
print (description.format(name, age, experience))

''' Check type of String '''
var = 'Hello123'
print ("Hello123 is Alphabetic? %s" %var.isalpha())
print ("Hello123 is Digit String? %s" %var.isdigit())
print ("Hello123 is Alpha-Numeric? %s" %var.isalnum())

''' Iteration over String '''
string1 = "Hello Python!"
count = 0
for char in string1:
    print("Character in Index {} is {}".format(count, char))
    count = count + 1
print("Length of String is %s" %count)

string1 = "Hello"
string2 = "Hello"
if (string1 == string2):
    print("Strings are same")
else:
    print("Strings are not same")