from tkinter import*
root=Tk()
root.geometry("300x150")
root.title('Sign in')
email=StringVar()

def btn_clicked():
    msg=f'You entered email:{email.get()}'
    print(msg)
email_lable = Label(root,text="Email Address:")
email_lable.pack(fill='x',expand=True)

email_entry=Entry(root,textvariable=email)
email_entry.pack(fill='x',expand=True)

subit_button = Button(root,text="Submit", command=btn_clicked)
subit_button.pack(fill='x',expand=True,pady=10)
root.mainloop()