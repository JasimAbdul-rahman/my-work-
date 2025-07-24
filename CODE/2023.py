# loop 
i = 2
while i<=10:
    print("value of i is", i)
    i= i+2

strg = input("Enter a string \n")
index = 0
while index< len(strg):
    print(strg[index])
    index +=1

a = 26
while a<65:
    print(a)
    a = a+1

n = int(input("Enter a positive integer greater than zero \n"))
sum = 0
i = 1
while i<=n:
    sum +=i
    i +=1
print(f"The sum of numbers from 1 to {n} is {sum}")


fruits = ["apple", "banana", "cherry"]
for item in fruits:
    print(item)

my_list = [1,2,3,4,5]
for num in my_list:
    print(num*num)

for x in range (30):
    print (x)