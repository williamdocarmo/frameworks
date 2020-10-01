def sum(num1, num2):
    return num1 + num2
    
def subtract(num1, num2):
    return num1 - num2;
    
def multiply(num1, num2):
    return num1 * num2;
    
def divide(num1, num2):
    return num1 / num2;

def fibonacci(n):
    a,b = 0,1
    fib = []
    while (b<n):
        fib.append(b)
        a, b = b, a+b
    return fib