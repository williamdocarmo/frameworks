dict = {}
configFile = "../../../Configuration.properties"
f = open(configFile, "r")                   #Open file
for x in f:                                 #Read line by line
    key = x.split("=")[0].strip()           #Read key
    value = x.split("=")[1].strip()         #Read value
    dict[key] = value                       #Put key-value in Dictionary
        
def getConfig(key):
    return dict.get(key, None)              #Return value for a key