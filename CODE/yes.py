usrnm =input(" Enter your username:")
psswd = input(" Enter your password:")
if usrnm == 'user01' and psswd == 'Pass123':
    print("Successful login!!")
elif usrnm!='user01' and psswd == 'Pass123':
    print("Error, incorrect username!!")
elif usrnm == 'user01' and psswd!= 'Pass123':
    print("Error, incorrect password!!")
else:
    print("Error, \n incorrect username and password")