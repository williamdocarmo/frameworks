varTrue = True
varFalse = False



print ("Type of varTrue is: %s" %type(varTrue))

print (varTrue + varFalse)
print (varTrue - varFalse)
print (varTrue * varFalse)
print (-varTrue - varFalse)

nullvar = ""
notnullvar = 100
'''
prints True if the objects holds some non-null, non-blank, non-zero value
prints False if the value is blank or null or zero
'''
print (bool (notnullvar))
print (bool (nullvar))