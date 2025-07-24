import tkinter as tk
from tkinter import ttk
from tkinter import messagebox

def submit_booking():
    name = name_entry.get()
    email = email_entry.get()
    phone = phone_entry.get()
    room_type = room_type_var.get()
    check_in = check_in_entry.get()
    check_out = check_out_entry.get()
    
    if not all([name, email, phone, room_type, check_in, check_out]):
        messagebox.showwarning("Incomplete Data", "Please fill all the fields.")
        return

    messagebox.showinfo("Booking Confirmed", f"Thank you, {name}!\nYour booking for a {room_type} room is confirmed.")
    
# Initialize the main window
root = tk.Tk()
root.title("Hotel Booking Page")
root.geometry("600x500")
root.configure(bg="#f8f8f8")

# Header Label
header_label = tk.Label(root, text="Hotel Booking", font=("Arial", 24, "bold"), bg="#f8f8f8", fg="#333")
header_label.pack(pady=20)

# Frame for the form
form_frame = tk.Frame(root, bg="#ffffff", bd=2, relief="groove")
form_frame.pack(pady=10, padx=20, fill="both", expand=True)

# Name Field
name_label = tk.Label(form_frame, text="Full Name:", font=("Arial", 12), bg="#ffffff")
name_label.grid(row=0, column=0, padx=10, pady=10, sticky="w")
name_entry = tk.Entry(form_frame, font=("Arial", 12), width=30)
name_entry.grid(row=0, column=1, padx=10, pady=10)

# Email Field
email_label = tk.Label(form_frame, text="Email Address:", font=("Arial", 12), bg="#ffffff")
email_label.grid(row=1, column=0, padx=10, pady=10, sticky="w")
email_entry = tk.Entry(form_frame, font=("Arial", 12), width=30)
email_entry.grid(row=1, column=1, padx=10, pady=10)

# Phone Field
phone_label = tk.Label(form_frame, text="Phone Number:", font=("Arial", 12), bg="#ffffff")
phone_label.grid(row=2, column=0, padx=10, pady=10, sticky="w")
phone_entry = tk.Entry(form_frame, font=("Arial", 12), width=30)
phone_entry.grid(row=2, column=1, padx=10, pady=10)

# Room Type Dropdown
room_type_label = tk.Label(form_frame, text="Room Type:", font=("Arial", 12), bg="#ffffff")
room_type_label.grid(row=3, column=0, padx=10, pady=10, sticky="w")
room_type_var = tk.StringVar()
room_type_dropdown = ttk.Combobox(form_frame, textvariable=room_type_var, font=("Arial", 12), width=28)
room_type_dropdown['values'] = ["Single", "Double", "Suite", "Family"]
room_type_dropdown.grid(row=3, column=1, padx=10, pady=10)

# Check-in Date Field
check_in_label = tk.Label(form_frame, text="Check-in Date:", font=("Arial", 12), bg="#ffffff")
check_in_label.grid(row=4, column=0, padx=10, pady=10, sticky="w")
check_in_entry = tk.Entry(form_frame, font=("Arial", 12), width=30)
check_in_entry.grid(row=4, column=1, padx=10, pady=10)

# Check-out Date Field
check_out_label = tk.Label(form_frame, text="Check-out Date:", font=("Arial", 12), bg="#ffffff")
check_out_label.grid(row=5, column=0, padx=10, pady=10, sticky="w")
check_out_entry = tk.Entry(form_frame, font=("Arial", 12), width=30)
check_out_entry.grid(row=5, column=1, padx=10, pady=10)

# Submit Button
submit_button = tk.Button(root, text="Submit Booking", font=("Arial", 14, "bold"), bg="#4CAF50", fg="#ffffff", command=submit_booking)
submit_button.pack(pady=20)

# Run the application
root.mainloop()
