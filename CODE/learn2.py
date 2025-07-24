from tkinter import*
root = Tk()
root.title("Calculator")
operator= ""
calculatorfield=""
def button_click(value):
    
    global operator
    operator += str(value)
    calculatorfield.delete (0,END)
    calculatorfield.insert(END,operator)
def clear():
    global operator
    operator =""
    calculatorfield.delete(0,END)
def calculate():
    global operator
    try:
        result=str(eval(operator))
        calculatorfield.delete(0,END)
        calculatorfield.insert(END,result)
        operator = result
    except:
        calculatorfield.delete(0,END)
        calculatorfield.insert(END,"Error")
        operator =""
calculatorfield= Entry(root,width=30,font=("Times new roman",20),borderwidth=7,relief="solid",justify=RIGHT)
calculatorfield.grid(row=0,column=0,columnspan=5,pady=12)
buttons=[
    ('7', 1, 0), ('8', 1, 1), ('9', 1, 2), ('+', 1, 3), 
    ('4', 2, 0), ('5', 2, 1), ('6', 2, 2), ('-', 2, 3),  
    ('1', 3, 0), ('2', 3, 1), ('3', 3, 2), ('*', 3, 3),  
    ('C', 4, 0), ('0', 4, 1), ('=', 4, 2), ('/', 4, 3),  
]
for(text,row,col) in buttons:
    if text == "=":
      Button(root,text=text,command=calculate,height=3,width=8,bg="red").grid(row=row,column=col,padx=5,pady=5)

    elif text =="C":
      Button(root,text=text,command=clear,height=3,width=8).grid(row=row,column=col,padx=5,pady=5)

    else:
     Button(root, text=text, command=lambda value=text: button_click(value), height=3, width=8).grid(row=row, column=col, padx=5, pady=5)


root.mainloop()