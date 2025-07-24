Temperature = float(input("enter the temperature:"))
Units = str(input("the units are Celsius and Fahrenheit :"))

if Units =="c" :
    res = (Temperature * (9/5) )+ 32
    print(f"the units of cel are {res}")
          
elif Units == "F" :
   res= (Temperature - 32) * 5/9 
   print(f"the units of Farh are {res}")
else:
   print("incorrect units")

