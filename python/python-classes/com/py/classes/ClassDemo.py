from com.py.classes.Computer import Computer
from com.py.classes.Employee import Employee
from com.py.classes import Calculator, Constants

# Demonstration of POJO
pc1 = Computer("AMD Ryzen 5", "AMD Radeon", "Corsair 16 GB DDR4", "Crucial MX 8")
pc1.printComputerDetails()

# Data will be stored in Class level variable
emp = Employee("Employee1", 90000)
emp = Employee("Employee2", 80000)
emp = Employee("Employee3", 120000)
Employee.printEmployee("")

# Invoking Method in Utils
print ("Sum :",Calculator.sum(10, 5))
print ("Subtract :",Calculator.subtract(10, 5))
print ("Multiply :",Calculator.multiply(10, 5))
print ("Division :",Calculator.divide(10, 5))

# Reading Value from Constant Classes
print(Constants.LANGUAGE_NAME, Constants.VERSION)

print("Concatenation: ", Calculator.sum("Hello ", "Python"))