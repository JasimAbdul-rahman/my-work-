b="hello, world!"
print(b[2:5])
print(b[:5])
print(b[2:])

w=("wanteds")
print(len(w))
print(w[2:3])

a = "Hello, world!"
print(a.strip())


a = "Hello world "
print (a.replace("H","w"))


a= "Hello"
b="world"
c= a + "     " + b
print(c)

a= "minE disConNecTEd"

print(a.capitalize() )
print(a.replace("i","y"))

age = 36
txt = f"My name is JOHN, i am {age} years old"
print(txt)


a=200
b=33
if b>a:
    print("b is greater than a")
else:
    print("b is not greater than a")


prc=int(input("Enter price of item:"))
qty=int(input("Enter number of item:"))
print(f"your total bill for {qty} items is {qty*prc}")


sum = 12
txt=f"the sum of 4 and 8 is \n = {sum}"
print(txt)

x=int(input("entrt first number"))
y=int(input("enter second number"))
print(f"the total is {x+y}")