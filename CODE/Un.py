def get_max(num1,num2):
    if num1>num2:
        print(f"{num1} is the maximum\n")
    elif num2>num1:
        print(f"{num2} is the maximum\n")
    else:
        print("Numbers are equal")
get_max(3,5)
n1=int(input("enter nun 1\n:"))
n2=int(input("Enter num 2\n:"))
get_max(n1,n2)


def my_function(x):
    return 5*x
val=my_function(3)
print(val)
print(my_function(5))
print(my_function(9))