from tkinter import *

root= Tk()
root.title('My Demo App')
root.geometry("600x400")
root.resizable()
root.iconbitmap('images.ico')
def btn_click():
    print("Button has been clicked")

b=Button(root, text='simple button',bg="blue",font=12,height=7,width=15,command=btn_click)
b.pack()

root.mainloop()