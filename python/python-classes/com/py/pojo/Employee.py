class Employee:
    employee = {}
    def __init__(self, empname, empsalary):        
        Employee.employee[empname] = empsalary
   
    def printEmployee(self):
        print("Employee Data: ", Employee.employee)
