thislist = ["apple", "banana","cherry"]
print(thislist)

thislist = ["apple","banana","cherry"]
print(thislist[-1])

thislist=["apple","banana","cherry","kiwi","melone","mango"]
print(thislist[2:5])

thislist=["apple","banana","cherry"]
if "apple" in thislist:
    print("Yes, 'apple' is in the fruits list ")


thislist=[True,12,7.5,"mark",2]
print(thislist[2:])
if 4 in thislist:
    print("yes,4 is in this list")
else:
    print("number 4 does not exist in this list")
thislist.append("orange")
print(thislist)
thislist.insert(1,"chicken")
print(thislist)
thislist.clear()
print(thislist)

# tupple is a read only
thistuple=("apple","banana","cherry","apple")
print(thistuple)
print(thistuple[1])
print(thistuple[1:])
print(thistuple[2:5])
if "apple" in thistuple:
    print("Yes, 'apple' is in th fruits tuple")

thistuple=(1,2,3,4,5)
print(thistuple)
templist=list(thistuple)
templist[2]=6
templist.remove(1)
templist.append(7)
newtuple = tuple(templist)
print(newtuple)

# sets
thisset={"apple","banana","cherry",1, True,2}
print(thisset)
print("banana" in thisset)
print("banana" not in thisset)
thisset.add("monkey")
print(thisset)
thisset.remove("cherry")
print(thisset)
thisset.discard(2)
print(thisset)
# dictionary dict
thisdict={
    "brand": "ford",
    "model":"mustung",
    "year": 1964
}
x= thisdict["model"]
print(x)
thisdict["color"]="red"
print(thisdict)
thisdict.pop("model")
print(thisdict)
thisdict.popitem()
print(thisdict)