''' Declaration '''
from filecmp import cmp
tup = ()    #Empty Tuple
print (tup)

#NOT a tuple
thistuple = ("apple")
print(type(thistuple))

tup1 = 'Zero', 'One'
print (tup1)

tup2 = ('Two', 'Three')
print (tup2)

''' Addition '''
tup = tup1 + tup2
print (tup)

''' Accessing Tuple Elements '''
tup = ('One', 'Two', 'Three', 'Four', 'Five')
print("Zeroth element is %s" %tup[0])
print("Last element is %s" %tup[-1])
tuplen = len(tup)
for x in range(tuplen):
    print ("Element in count {} is {}".format(x, tup[x]))
    
''' Check Contains '''
tup = (1,2,3)
print ("Is 3 Present? %s" %(3 in tup))

''' Slicing '''
tuple1 = (0 ,1, 2, 3) 
print(tuple1[1:]) 
print(tuple1[::-1]) 
print(tuple1[2:4])

''' Conversion to Tuple '''
list1 = [0, 1, 2] 
print(tuple(list1)) 
print(tuple('python')) # string 'python' 

tuple1 = (1,2,3)
tuple2 = (1,2,3,4,1)
if (tuple1 == tuple2):
    print ("Tuples are same")
else:
    print("Not Same")

tuple2 = (1,2,3,4,1,7,3,1,8)
''' Finding Count of an Element '''
print("Count using inbuilt method %s" %tuple2.count(1))
count = 0
for x in tuple2:
    if (x == 1):
        count = count + 1
print("Count using custom method %s" %count)

''' Finding Index of an Element'''
print("Index using inbuilt method %s" %tuple2.index(3))
index = -1
for x in tuple2:
    index = index + 1
    if (x == 3):
        break;
print("Index using custom method %s" %index)

''' Tupple Assignment '''
tup = ("Santanu", 10)
print ("Name of the user is %s and experience is %s" %tup)

user = ("Santanu", "Bhattacharyya", 30)
(firstname, lastname, age) = user
print(firstname)