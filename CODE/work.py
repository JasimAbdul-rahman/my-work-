x= float(input("Enter any number"))
ex2 = x**2
fd2= x//2
rm2=x%2
print(f"the square of {x} is {ex2}")
print(f"the floor division of {x} by 2 is {fd2}")
print(f"the remainder of {x} divid by 2 is {rm2}")

cost=float(input("enter cost of the meal"))
vat =cost*0.05
cost+=vat
print("Total cost is",cost)

x=5
y=5
if x==y:
    print("x is equal to y")
x=5
y=10
if x<=y:
    print("x is less thsn or equal to y")