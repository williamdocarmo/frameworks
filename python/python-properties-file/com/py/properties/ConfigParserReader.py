import configparser

''' Read Configuration '''
config = configparser.ConfigParser()
config.read('../../../example.ini')

''' Print Sections from Configuration '''
print(config.sections())
print(type(config.sections()))
''' Check if Sessions Exist '''
print('bitbucket.org' in config)
print('bytebong.com' in config)

''' Fetch Configuration '''
print(config['bitbucket.org']['User'])
print(config['DEFAULT']['Compression'])

topsecret = config['topsecret.server.com']
print(topsecret['ForwardX11'])
print(topsecret['Port'])
for key in config['bitbucket.org']:  
    print(key)
print(config['bitbucket.org']['ForwardX11'])