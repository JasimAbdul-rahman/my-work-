import tkinter as tk  # Import the tkinter library for GUI creation
from datetime import datetime  # Import the datetime library for working with dates

# Function to calculate age
def agecalculator():
    dob_get = dob.get()  # Get the user input from the Entry widget (expected in 'dd/mm/yyyy' format)

    try:
        # Define the date format we expect
        date_format = "%d/%m/%Y"
        
        # Convert the user input into a datetime object
        date_of_birth = datetime.strptime(dob_get, date_format)
        
        # Get the current date
        current_date = datetime.today()
        
        # Calculate the age in years by subtracting birth year from current year
        age = current_date.year - date_of_birth.year
        
        # Adjust the age if the current month and day are earlier than the birth month and day
        if (current_date.month, current_date.day) < (date_of_birth.month, date_of_birth.day):
            age -= 1  # Decrement age if the birthday hasn't occurred yet in the current year

        # Display the calculated age in the result label with green text
        resultf.config(text=f"You are {age} years old", fg="green")

    except ValueError:
        # Handle invalid input (e.g., incorrect date format)
        resultf.config(text="Invalid entry! Use 'dd/mm/yyyy' format", fg="red")


# Create the main application window
mainage = tk.Tk()    
mainage.title("Age Calculator")  # Set the window title

# You can add an icon if you have one by specifying the path
mainage.iconbitmap("./")  # Placeholder for icon (comment this line if no icon file exists)

mainage.geometry("450x250+50+50")  # Set the window size and position (width x height + x_offset + y_offset)

# Label to prompt the user for their date of birth
dob_label