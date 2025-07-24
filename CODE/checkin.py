import tkinter as tk
from tkinter import ttk
from tkinter import messagebox


def create_reservation_page():

# Functionality for buttons

    def calculate_bill():
     messagebox.showinfo("Calculate Bill", "Bill calculation functionality goes here.")


def edit_reservation():
    messagebox.showinfo("Edit Reservation", "Edit reservation functionality goes here.")
    
def calculate_bill():
     messagebox.showinfo("Calculate Bill", "Bill calculation functionality goes here.")

    #  clearing 
def display_reservation():
    for widget in reservation_display_frame.winfo_children():
        widget.destroy()  

    # Add new reservation details
    ttk.Label(reservation_display_frame, text="Reservation Details:", font=("Arial", 16, "bold")).grid(
        row=0, column=0, padx=10, pady=10, sticky="w"
    )
    details = [
        "Name: Group work",
        "Room: Suite",
        "Guests: 2",
        "Check-in: Jan 10, 2025",
        "Check-out: Jan 15, 2025",
    ]
    for i, detail in enumerate(details):
        ttk.Label(reservation_display_frame, text=detail, font=("Arial", 14)).grid(
            row=i + 1, column=0, padx=10, pady=5, sticky="w"
        )

# Main application window  -------GUI---------

root = tk.Tk()
# app  name
root.title("Hotel Management System Dashboard")
root.geometry("1600x800")


root.rowconfigure(1, weight=1)
root.columnconfigure(0, weight=1)

# Configuring  styles
style = ttk.Style()
style.configure("TLabel", font=("Arial", 14), padding=5)
style.configure("TEntry", font=("Arial", 14), padding=5)
style.configure("TButton", font=("Arial", 14), padding=5)
style.configure("TCombobox", font=("Arial", 14), padding=5)


# Title
title_label = tk.Label(root, text="Hotel Management System Dashboard", font=("Arial", 20, "bold"))
title_label.grid(row=0, column=0, pady=20)

# Tabs
notebook = ttk.Notebook(root)
notebook.grid(row=1, column=0, sticky="nsew")

# Add Reservation tab
frame_add_reservation = ttk.Frame(notebook)
notebook.add(frame_add_reservation, text="Add Reservation")

# Left Panel: Guest Information
left_frame = ttk.LabelFrame(frame_add_reservation, text="Guest Information", padding=20)
left_frame.grid(row=0, column=0, sticky="nsew", padx=20, pady=20)

# Guest Information Fields
guest_info = [
    ("Name:", ""),
    ("Birthday:", ""),
    ("Gender:", ["Select", "Male", "Female", "Other"]),
    ("Phone Number:", ""),
    ("Email Address:", ""),
    ("Street Address:", ""),
    ("City:", ""),
]

for i, (label, value) in enumerate(guest_info):
    ttk.Label(left_frame, text=label).grid(row=i, column=0, padx=10, pady=10, sticky="w")
    if isinstance(value, list):
        ttk.Combobox(left_frame, values=value, width=30).grid(row=i, column=1, pady=10, sticky="ew")
    else:
        ttk.Entry(left_frame, width=30).grid(row=i, column=1, pady=10, sticky="ew")

# Right Panel: Reservation Details
right_frame = ttk.LabelFrame(frame_add_reservation, text="Reservation Details", padding=20)
right_frame.grid(row=0, column=1, sticky="nsew", padx=20, pady=20)

# Reservation Details Fields
reservation_details = [
    ("Guest Count:", ["Select Guest Number"] + list(range(1, 11))),
    ("Room Type:", ["Single", "Double", "Suite"]),
    ("Entry Date:", ""),
    ("Departure Date:", ""),
]

for i, (label, value) in enumerate(reservation_details):
    ttk.Label(right_frame, text=label).grid(row=i, column=0, padx=10, pady=10, sticky="w")
    if isinstance(value, list):
        ttk.Combobox(right_frame, values=value, width=25).grid(row=i, column=1, pady=10, sticky="ew")
    else:
        ttk.Entry(right_frame, width=25).grid(row=i, column=1, pady=10, sticky="ew")

# Reservation Display Panel
reservation_display_frame = ttk.LabelFrame(
    frame_add_reservation, text="Reservation Display", padding=20
)
reservation_display_frame.grid(row=0, column=2, rowspan=2, sticky="nsew", padx=20, pady=20)
reservation_display_frame.config(relief="solid", borderwidth=2)

# Placeholder Label
ttk.Label(reservation_display_frame, text="No reservation selected.", font=("Arial", 14)).grid(
    row=0, column=0, padx=10, pady=10
)

guest_info_widgets = {}

for i, (label, value) in enumerate(guest_info):
    ttk.Label(left_frame, text=label).grid(row=i, column=0, padx=10, pady=10, sticky="w")
    if isinstance(value, list):
        combobox = ttk.Combobox(left_frame, values=value, width=30)
        combobox.grid(row=i, column=1, pady=10, sticky="ew")
        guest_info_widgets[label] = combobox
    else:
        entry = ttk.Entry(left_frame, width=30)
        entry.grid(row=i, column=1, pady=10, sticky="ew")
        guest_info_widgets[label] = entry

# Reservation Details Fields
reservation_details_widgets = {}

for i, (label, value) in enumerate(reservation_details):
    ttk.Label(right_frame, text=label).grid(row=i, column=0, padx=10, pady=10, sticky="w")
    if isinstance(value, list):
        combobox = ttk.Combobox(right_frame, values=value, width=25)
        combobox.grid(row=i, column=1, pady=10, sticky="ew")
        reservation_details_widgets[label] = combobox
    else:
        entry = ttk.Entry(right_frame, width=25)
        entry.grid(row=i, column=1, pady=10, sticky="ew")
        reservation_details_widgets[label] = entry

# Update the New Reservation function
def new_reservation():
    for widget in reservation_display_frame.winfo_children():
        widget.destroy()  # Clear existing content in the frame

    # Add new reservation details
    ttk.Label(reservation_display_frame, text="Reservation Details:", font=("Arial", 16, "bold")).grid(
        row=0, column=0, padx=10, pady=10, sticky="w"
    )

    details = []

    # Gather guest information
    for label, widget in guest_info_widgets.items():
        value = widget.get()
        if label.endswith(":"):
            label = label[:-1]  # Remove the colon for display
        details.append(f"{label}: {value}")

    # Gather reservation details
    for label, widget in reservation_details_widgets.items():
        value = widget.get()
        if label.endswith(":"):
            label = label[:-1]  # Remove the colon for display
        details.append(f"{label}: {value}")

    # Display the details
    for i, detail in enumerate(details):
        ttk.Label(reservation_display_frame, text=detail, font=("Arial", 14)).grid(
            row=i + 1, column=0, padx=10, pady=5, sticky="w"
        )

#------------------------------------------------ Buttons Frame
buttons_frame = ttk.Frame(frame_add_reservation, padding=20)
buttons_frame.grid(row=1, column=0, columnspan=3, sticky="ew", pady=20)
buttons_frame.columnconfigure([0, 1, 2, 3], weight=1)

# Action Buttons
buttons = [
    ("Calculate Bill", calculate_bill),
    ("New Reservation", new_reservation),
    ("Edit Reservation", edit_reservation),
    ("View Reservation", display_reservation),
]

for i, (text, command) in enumerate(buttons):
    ttk.Button(buttons_frame, text=text, command=command).grid(
        row=0, column=i, padx=10, pady=10, sticky="ew"
    )

# Configure Weights for Frames
frame_add_reservation.columnconfigure([0, 1, 2], weight=1)
frame_add_reservation.rowconfigure(0, weight=1)
frame_add_reservation.rowconfigure(1, weight=0)

# Run the application


root.mainloop()
