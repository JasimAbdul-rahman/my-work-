num1 = float(input("enter the first number :"))
num2 = float(input("enter the second number:"))

print(f"floor division of {num1} and {num2} is {num1//num2}")
print(f"remainder of division of {num1} and {num2} is {num1%num2}")

num=float(input("enter any number:"))
if num%2 == 0 :
    print("this an even number")
    x=5
    y=12
    if x>y:
        print("x is greater than y")
    if x<y: 
        print("x is less than y")

num= int(input("enter an even number:"))
cube = num**3
if num%2==0:
    print(f"the cube of the even number:",{cube})
else:
  print(f"{num} is not an even number")  