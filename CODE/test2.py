def my_function():
    print("Hello from a function")
my_function()

def input_function():
    name=input("Enter your surname:\n")
    if len(name) >10:
        print('name is too long')
    elif len(name)<4:
        print("name is too short")
    else:
        print("name is ok")
print("Welcome player one!")
input_function()
print("Welcome player two!")
input_function()



def my_function(fname):
    print(fname + "Paker")
my_function("Emil")
my_function("Tommy")
my_function("linus")


def my_function(fname,lname):
    print(fname +"" + lname)
my_function("jasim")