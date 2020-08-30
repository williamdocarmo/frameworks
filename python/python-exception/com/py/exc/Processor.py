def divide(num1, num2):
    return num1/num2    

try:
    z = divide(10, 0)
except ZeroDivisionError as e:
    print("Cannot Divide by Zero")
