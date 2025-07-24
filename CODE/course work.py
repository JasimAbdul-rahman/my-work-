# GROUP MEMBERS
# ABDUL RAHMAN JASIM	-	VU-BSF-2407-2235-DAY
# NABATANZI NORAH NURU 	-	VU-BSF-2407-1638-DAY     
#  SSERUYANGE MARVIN 	-	VU-BSF-2470-2070-DAY
#KULUMBA DENIS 		VU-BSF-2407-0218-DAY	
#MUGISHA BRAIN 		VU-BAE-2407-2667-DAY

import tkinter as tk  # Import the tkinter library to create GUI applications
from datetime import datetime  # Import datetime to work with dates

# Function to calculate age
def agecalculator():
    dob_get = dob.get()  # Retrieve the date of birth entered by the user from the input field
    try:
        # Define the expected date format (day/month/year)
        date_format = "%d/%m/%Y"
        date_of_birth = datetime.strptime(dob_get, date_format)  # Parse the input date into a datetime object
        current_date = datetime.today()  # Get the current date and time
        
        # Calculate the age in years by subtracting birth year from the current year
        age = current_date.year - date_of_birth.year

        # If the current month and day are earlier than the birth month and day,
        # subtract one year from the calculated age
        if (current_date.month, current_date.day) < (date_of_birth.month, date_of_birth.day):
            age -= 1

        # Update the result label to display the calculated age in green text
        result_label.config(text=f"You are {age} years old!", fg="green")
    except ValueError:
        # Handle invalid input: If the date format is incorrect, display an error message in red
        result_label.config(text="Invalid entry! Use 'dd/mm/yyyy' format.", fg="red")

# Function to clear the input and reset the result
def clear():
    dob.delete(0, tk.END)  # Clear the input field by removing all text
    result_label.config(text="")  # Clear the result label text

# Function to exit/close the application
def exit_app():
    root.destroy()  # Destroy the main window, effectively closing the application

# Main application window setup
root = tk.Tk()  # Create the main application window
root.title("Age Calculator")  # Set the title of the window
root.geometry("500x350")  # Set the size of the window (width x height)
root.config(bg="light blue")  # Set the background color to light blue

# Header: A label at the top of the window with a bold welcome message
header_label = tk.Label(
    root, 
    text="Welcome to the Age Calculator!", 
    font=("Times new roman", 20, "bold"),  # Set font style, size, and weight
    bg="red",  # Background color of the label
    fg="white",  # Text color
    pady=10  # Add vertical padding
)
header_label.pack(fill="x")  # Make the label stretch horizontally to fill the window

# Input label: A label to prompt the user to enter their date of birth
dob_label = tk.Label(
    root, 
    text="Enter your date of birth (dd/mm/yyyy):", 
    font=("Arial", 12), 
    bg="sky blue"  # Set a distinct background color
)
dob_label.pack(pady=10)  # Add vertical padding around the label

# Input field: An Entry widget where the user can type their date of birth
dob = tk.Entry(
    root, 
    font=("Times new roman", 20),  # Larger font size for better visibility
    justify="center",  # Align text to the center of the input field
    width=30  # Set the width of the input field
)
dob.pack(pady=5)  # Add vertical padding around the input field

# Buttons frame: A container (frame) to group the buttons together
button_frame = tk.Frame(root, bg="lightblue")  # Set background color to match the main window
button_frame.pack(pady=10)  # Add vertical padding around the frame

# Calculate button: Button to trigger the age calculation function
calculate_button = tk.Button(
    button_frame, 
    text="Calculate", 
    font=("times new roman", 12),  # Set font style and size
    bg="orange",  # Set button background color
    fg="white",  # Set button text color
    width=10,  # Set button width
    command=agecalculator  # Link the button to the agecalculator function
)
calculate_button.grid(row=0, column=0, padx=10)  # Place the button in the grid with horizontal padding

# Clear button: Button to clear the input and result
clear_button = tk.Button(
    button_frame, 
    text="Clear", 
    font=("Times new roman", 12), 
    bg="yellow",  # Set button background color
    fg="white",  # Set button text color
    width=10, 
    command=clear  # Link the button to the clear function
)
clear_button.grid(row=0, column=1, padx=10)  # Place the button in the grid next to the calculate button

# Exit button: Button to close the application
exit_button = tk.Button(
    button_frame, 
    text="Exit", 
    font=("times new roman", 12), 
    bg="red",  # Set button background color
    fg="white",  # Set button text color
    width=10, 
    command=exit_app  # Link the button to the exit_app function
)
exit_button.grid(row=0, column=2, padx=10)  # Place the button in the grid next to the clear button

# Result label: A label to display the calculated age or error messages
result_label = tk.Label(
    root, 
    text="",  # Initially, the text is empty
    font=("times new roman", 14),  # Font style and size
    bg="pink",  # Set a distinct background color for the result area
    relief="solid",  # Add a solid border around the label
    width=40,  # Set the width of the label
    height=3,  # Set the height of the label
    anchor="center"  # Align text to the center of the label
)
result_label.pack(pady=15)  # Add vertical padding around the result label

# Footer: A label at the bottom of the window with a thank-you message
footer_label = tk.Label(
    root, 
    text="Thank you for using the Age Calculator!", 
    font=("times new roman", 10, "italic"),  # Font style and size
    bg="sky blue",  # Background color
    fg="white",  # Text color
    pady=5  # Add vertical padding
)
footer_label.pack(fill="x", side="bottom")  # Make the footer stretch horizontally and place it at the bottom

# Run the application
root.mainloop()  # Start the application's main event loop