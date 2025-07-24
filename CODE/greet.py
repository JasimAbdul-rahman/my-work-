import os
os.system('cls')

from tkinter import*
from tkinter import messagebox

def greet_user():
    name = name_entry.get()
    if name:
        messagebox.showinfo("Greeting", f"Hello, {name}!") 
        messagebox.askquestion("Confirm","Are you alright?")
    else:
        messagebox.showwarning("Input Error", "Please enter your name.")

app = Tk()
app.title("Greeting App")
app.geometry("300x200")

greeting_label = Label(app, text="Enter your name:")
greeting_label.pack(pady=10)

name_entry = Entry(app, width=30)
name_entry.pack(pady=5)

greet_button = Button(app, text="Greet Me!", command=greet_user)
greet_button.pack(pady=20)

app.mainloop()
