from genericpath import isfile
import glob
from nt import listdir
from ntpath import join
from os import path
from os.path import os


FILE = "../../../demofile.txt"
DIR = "../../../"

def listFile(dir):
    filelist = listdir(dir)
    for file in filelist:
        relativePath = dir+file
        if (path.isfile(relativePath)):
            print("File: "+relativePath)
        if (path.isdir(relativePath)):
            print("Directory: "+relativePath)
    
''' Check if File Exists '''
def checkFileExist(file):
    pathExists = path.exists(file)
    isFile = path.isfile(file)
    print("Path Exists {} | Is File {}".format(pathExists,isFile))

''' Create File '''
def createFile(file):
    f = open(file, "x")
    f.write('''Content of the initial file\nCreated Now''')
    f.close()
    print("File created")
    checkFileExist(file)
    
''' Read File Content '''
def readFile(file):
    f = open(file, "r")
    print("Complete content of this file\n" + f.read())
    f.close()

''' Read Lines '''
def readLines(file):
    f = open(file, "r")
    for line in f:
        print("Content of this line: " + line)
    f.close()
    
''' Write Content to a File '''
def writeToFile(file):
    f = open(file, "w")
    f.write("New content of the file")
    f.close()
    print("File written")

''' Append Content to a File '''
def appendToFile(file):
    f = open(file, "a")
    f.write("\nAppending New Content")
    f.close()
    print("Appended Content")
    
''' Delete a file '''
def deleteFile(file):
    os.remove(file)
    print("Removed file")
    checkFileExist(file)

listFile(DIR)

checkFileExist(FILE)

createFile(FILE)

readFile(FILE)

readLines(FILE)

writeToFile(FILE)

appendToFile(FILE)

deleteFile(FILE)