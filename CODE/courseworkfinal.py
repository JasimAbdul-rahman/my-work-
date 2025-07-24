


from tkinter import *

# Initialize the main window
root = Tk()
root.title("Simple Calculator")  # Set the title of the window

# Initialize a global variable to track the user input and operations
operator = "" # operator serves as a container to store the mathematical expression as the user inputs numbers and operators (e.g., 2+3*4).


# Functions:
def button_click(value):
    """
    Handles button clicks. Updates the global 'operator' variable 
    and displays the current input in the entry field.
    """
    global operator
    operator += str(value)  # Append the button value to the operator string
    entry.delete(0, END)    # Clear the entry field
    entry.insert(END, operator)  # Insert the updated operator string

def clear():
    """
    Clears the entry field and resets the global 'operator' variable.
    """
    global operator
    operator = ""  # Reset the operator string
    entry.delete(0, END)  # Clear the entry field

def calculate():
    """
    Evaluates the mathematical expression in the 'operator' variable.
    Displays the result or 'Error' if the expression is invalid.
    """
    global operator
    try:
        # Evaluate the expression safely
        result = str(eval(operator))
        entry.delete(0, END)  # Clear the entry field
        entry.insert(END, result)  # Display the result
        operator = result  # Update the operator with the result for further calculations
    except:
        # Handle invalid expressions
        entry.delete(0, END)
        entry.insert(END, "Error")
        operator = ""

# Create an entry widget to display input and results
entry = Entry(root, width=20, font=("Arial", 17), borderwidth=5, relief="ridge", justify=RIGHT)
# Position the entry widget at the top, spanning 4 columns
entry.grid(row=0, column=0, columnspan=4, pady=10)

# Define the layout of calculator buttons with their labels, positions, and commands
buttons = [
    ('7', 1, 0), ('8', 1, 1), ('9', 1, 2), ('+', 1, 3),  # Row 1 buttons
    ('4', 2, 0), ('5', 2, 1), ('6', 2, 2), ('-', 2, 3),  # Row 2 buttons
    ('1', 3, 0), ('2', 3, 1), ('3', 3, 2), ('*', 3, 3),  # Row 3 buttons
    ('C', 4, 0), ('0', 4, 1), ('=', 4, 2), ('/', 4, 3),  # Row 4 buttons
]

# Create and position the buttons 
for (text, row, col) in buttons:
    if text == "=":
        # '=' button calls the calculate function
        Button(root, text=text, command=calculate, height=2, width=7, bg="red").grid(row=row, column=col, padx=5, pady=5)
    elif text == "C":
        # 'C' button calls the clear function
        Button(root, text=text, command=clear, height=2, width=7, bg="orange").grid(row=row, column=col, padx=5, pady=5)
    else:
        # Other buttons call the button_click function with their value
        Button(root, text=text, command=lambda value=text: button_click(value), height=2, width=7).grid(row=row, column=col, padx=5, pady=5)

# Run the application event loop
root.mainloop()
