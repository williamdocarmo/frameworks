''' List Object '''
list1 = [0,1,2,3]
print("Type of the object is: %s" %type(list1))
print("This list contains: %s" %list1)

''' Accessing Elements in List '''
for n in list1:
    print("Element is: %s" %n)
print("The second item in list is: %s" %list1[1])
print ("Last item in the list is: %s" %list1[-1])
print ("Last item in the list is: %s" %list1[len(list1)-1])

''' Check if an Element is Present '''
if '2' in list1:
    print("List contains String 2")

if 2 in list1:
    print("List contains Integer 2")
    
''' Update List '''
list1[1] = 'One'
print("Updated List: %s" %list1)

''' Remove and Insert '''
if 'One' in list1:
    print("Index of One: %s" %list1.index('One'))
    list1.insert(list1.index('One'), 1)
    print("Before Updating List: %s" %list1)
    list1.remove('One')
    print("After Updating List: %s" %list1)
del list1[0]
print("After removing 0th element %s" %list1)

list1 = [1,2,3,1,7]
for x in list1:
    if x == 1:
        list1.remove(x)

''' Clearing Lists'''
list1 = [1,2,3]
list2 = [4,5,6]
print ("Before Clear {} {}".format(list1, list2))
del list1[:]
list2.clear()
print ("After Clear {} {}".format(list1, list2))

''' List Clear and Delete '''
print('List 2 before delete %s' %list1)
del list1
#print('List 2 after delete %s' %list2) will return error

''' Copy List '''
list1 = [1,2,3]
list2 = []
for x in list2:
    list2.append(x)
del list2
list2 = list1.copy()
print("After copying list4 %s" %list2)


''' List Append '''
list1 = [1,2,3]
list2 = ['One', 'Two', 'Three']

list3 = list1+list2
print("After Addition: %s" %list3)

for x in list2:
    list1.append(x)
print("After Addition: %s" %list1)

list1.extend(list2)
print("After Addition: %s" %list1)

''' List Compare'''
list1 = [1,2,3]
list2 = [1,2,3]
print("List 1 and List 2 are same %s" %(list1==list2))

''' Count '''
list1 = [1,2,3,1,7]
print("Occurrence of 1: %s" %list1.count(1))

''' Reverse '''
print(list1)
list1.reverse()
print(list1)