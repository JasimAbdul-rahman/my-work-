# ABDUL RAHMAN JASIM	-	VU-BSF-2407-2235-DAY
# NABATANZI NORAH NURU 	-	VU-BSF-2407-1638-DAY     
#  SSERUYANGE MARVIN 	-	VU-BSF-2470-2070-DAY
#KULUMBA DENIS 		VU-BSF-2407-0218-DAY	
#MUGISHA BRAIN 		VU-BAE-2407-2667-DAY

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
dob_label = tk.Label(mainage, font=("Times new roman", 20), text="Enter your date of birth (dd/mm/yyyy)")
dob_label.pack(pady=8, padx=8)  # Add padding for better layout

# Entry widget to input the date of birth
dob = tk.Entry(mainage, font=("Times new roman", 20), justify="center")
dob.pack(pady=8, padx=8)

# Button to trigger the age calculation
calcbutt = tk.Button(mainage, font=("Times new roman", 20), text="Calculate", command=agecalculator)
calcbutt.pack(pady=8, padx=8)

# Label to display the result or error message
resultf = tk.Label(
    mainage, 
    text="",  # Initial text is empty
    width=40,  # Label width
    font=("Times new roman", 20), 
    height=5,  # Label height
    relief="solid",  # Solid border style for a nice effect
    anchor="center"  # Center-align the text
)
resultf.pack(pady=8, padx=8)  # Add padding for better spacing

# Run the main loop of the application (keeps the window running and interactive)
mainage.mainloop()