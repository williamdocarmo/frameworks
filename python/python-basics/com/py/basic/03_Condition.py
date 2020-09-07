a = 1==1
if a:
    print("a is True")
else:
    print ("a is False")
    
b = 1==2
if b:
    print("b is True")
else:
    print ("b is False")
    
x=1
if x==0:
    print("X is 0")
elif x==1:
    print("X is 1")
elif x==2:
    print("X is 2")
else:
    print("X is not [0,1,2]")
    
string1 = "Python"
string2 = "Python"
if string1.__eq__(string2):
    print("Both the strings are same")
if string1==string2:
    print("Both the strings are same")
    
string1 = "Python"
string2 = "Java"
if not string1==string2:
    print("The strings are different")

languages = "python, java, scala, perl, golang, groovy, javascript"
if ('python' in languages or 'java' in languages):
    print("This list contains powerful languages")

if not ('html' in languages and 'react' in languages):
    print("This list does not contain UI languages")