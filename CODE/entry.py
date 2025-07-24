from tkinter import*
parent = Tk()

name = Label(parent,text = "Name").grid(row = 0, column = 0)
el = Entry(parent).grid(row = 0, column = 1)

submit =  Button(parent, text = "Submit").grid(row = 1, column = 0)

parent.mainloop()