from tkinter import*
parent=Tk()
redbutton =Button(parent, text ="Red",fg ="red")
redbutton.pack(side=LEFT,padx=90)
greenbutton=Button(parent,text="Black",fg="black")
greenbutton.pack(side=RIGHT,padx=60)
parent.mainloop() 

from _tkinter import*
parent = Tk()
name = Label(parent,text="Name").grid(row=0,column=0)
e1=Entry(parent).grid(row=0,column=1)
submit=Button(parent,text="Submit").grid(row=1,column=0)
parent.mainloop()

from tkinter import*
top=Tk()
top.geometry("400x250")
name = Label(top,text='Name').place(x=30,y=50)
email= Label(top,text="Email").place(x=30,y=90)
password=Label(top,text="Password").place(x=30,y=130)
e1=Entry(top).place(x=80,y=50)
e2=Entry(top).place(x=80,y=90)
e3=Entry(top).place(x=95,y=130)
top.mainloop()

