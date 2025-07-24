from tkinter import *

root = Tk()
root.title("Simple Calculator")

# to track our input
operator = ""

# Functions
def button_click(value):
    global operator
    operator += str(value)
    entry.delete(0, END)
    entry.insert(END, operator)

def clear():
    global operator
    operator = ""
    entry.delete(0, END)

def calculate():
    global operator
    try:
        result = str(eval(operator))  # Safely evaluate the expression
        entry.delete(0, END)
        entry.insert(END, result)
        operator = result  # Allow further operations on the result
    except:
        entry.delete(0, END)
        entry.insert(END, "Error")
        operator = ""

# Entry field for displaying input and results
entry = Entry(root, width=20, font=("Arial", 16), borderwidth=5, relief="ridge", justify=RIGHT)
entry.grid(row=0, column=0, columnspan=4, pady=10)

# Button layout
buttons = [
    ('7', 1, 0), ('8', 1, 1), ('9', 1, 2), ('+', 1, 3),
    ('4', 2, 0), ('5', 2, 1), ('6', 2, 2), ('-', 2, 3),
    ('1', 3, 0), ('2', 3, 1), ('3', 3, 2), ('*', 3, 3),
    ('C', 4, 0), ('0', 4, 1), ('=', 4, 2), ('/', 4, 3),
]

# Add buttons 
for (text, row, col) in buttons:
    if text == "=":
        Button(root, text=text, command=calculate, height=2, width=7, bg="lightblue").grid(row=row, column=col, padx=5, pady=5)
    elif text == "C":
        Button(root, text=text, command=clear, height=2, width=7, bg="lightcoral").grid(row=row, column=col, padx=5, pady=5)
    else:
        Button(root, text=text, command=lambda value=text: button_click(value), height=2, width=7).grid(row=row, column=col, padx=5, pady=5)

# Run the application
root.mainloop()