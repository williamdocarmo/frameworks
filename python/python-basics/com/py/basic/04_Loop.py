''' Loop over String '''
string1 = "Hello Python!"
count = 0
for x in string1:
    print("Character in {} is {}".format(count, x))
    count += 1
    
''' Looping over List '''
list1 = [1, 2, 'Three', 4, 'Five', 'Six', 7.0]
for x in list1:
    print(x)
    
print("Size of List: %s" %len(list1))
length = len(list1)
for x in range(length):
    print(list1[x])

for x in range(3): #for (int i=0;i<3;i++)
    print (x)

for x in range (3, 6): #for (int i=3;i<6;i++)
    print (x)
    
for x in range (3, 30, 5): #for (int i=3;i<30;i+=5)
    print (x)