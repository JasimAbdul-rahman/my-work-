from tkinter import *

# Initialize the main window
root = Tk()
root.title("Calculator")

# Global variables
operator = ''

# Functions
def buttonclick(numbers):
    global operator
    operator += str(numbers)
    calculatorfield.delete(0, END)
    calculatorfield.insert(END, operator)

def clear():
    global operator
    operator = ''
    calculatorfield.delete(0, END)

def answer():
    global operator
    try:
        result = str(eval(operator))  # Evaluate the expression
        calculatorfield.delete(0, END)
        calculatorfield.insert(END, result)
        operator = ''
    except:
        calculatorfield.delete(0, END)
        calculatorfield.insert(END, "Error")

# Entry field
calculatorfield = Entry(root, width=35, borderwidth=5)
calculatorfield.grid(row=0, column=0, columnspan=4)

# Buttons
button1 = Button(root, text='1', command=lambda: buttonclick(1), height=2, width=7)
button1.grid(row=1, column=0)

button2 = Button(root, text='2', command=lambda: buttonclick(2), height=2, width=7)
button2.grid(row=1, column=1)

button3 = Button(root, text='3', command=lambda: buttonclick(3), height=2, width=7)
button3.grid(row=1, column=2)

button4 = Button(root, text='4', command=lambda: buttonclick(4), height=2, width=7)
button4.grid(row=2, column=0)

button5 = Button(root, text='5', command=lambda: buttonclick(5), height=2, width=7)
button5.grid(row=2, column=1)

button6 = Button(root, text='6', command=lambda: buttonclick(6), height=2, width=7)
button6.grid(row=2, column=2)

button7 = Button(root, text='7', command=lambda: buttonclick(7), height=2, width=7)
button7.grid(row=3, column=0)

button8 = Button(root, text='8', command=lambda: buttonclick(8), height=2, width=7)
button8.grid(row=3, column=1)

button9 = Button(root, text='9', command=lambda: buttonclick(9), height=2, width=7)
button9.grid(row=3, column=2)

button0 = Button(root, text='0', command=lambda: buttonclick(0), height=2, width=7)
button0.grid(row=4, column=1)

button_add = Button(root, text='+', command=lambda: buttonclick('+'), height=2, width=7)
button_add.grid(row=1, column=3)

button_sub = Button(root, text='-', command=lambda: buttonclick('-'), height=2, width=7)
button_sub.grid(row=2, column=3)

button_mul = Button(root, text='*', command=lambda: buttonclick('*'), height=2, width=7)
button_mul.grid(row=3, column=3)

button_div = Button(root, text='/', command=lambda: buttonclick('/'), height=2, width=7)
button_div.grid(row=4, column=3)

button_ans = Button(root, text='=', command=answer, height=2, width=7)
button_ans.grid(row=4, column=0)

button_clear = Button(root, text='Clear', command=clear, height=2, width=7)
button_clear.grid(row=4, column=2)

# Main loop
root.mainloop()