

import tkinter as tk

from tkinter import messagebox
from tkinter.simpledialog import askstring

def add_transaction():
    date = askstring("Add Transaction", "Enter transaction date (YYYY-MM-DD):")
    if not date:
        return
    description = askstring("Add Transaction", "Enter transaction description:")
    if not description:
        return
    amount = askstring("Add Transaction", "Enter transaction amount:")
    if not amount:
        return
    try:
        amount = float(amount)
        transactions.append({"date": date, "description": description, "amount": amount})
        messagebox.showinfo("Success", "Transaction added successfully!")
    except ValueError:
        messagebox.showerror("Error", "Invalid amount entered. Please try again.")

def view_transactions():
    if not transactions:
        messagebox.showinfo("Transactions", "No transactions available.")
        return
    transactions_window = tk.Toplevel(root)
    transactions_window.title("View Transactions")
    transactions_text = tk.Text(transactions_window, width=60, height=20)
    transactions_text.pack()
    for i, t in enumerate(transactions, start=1):
        transactions_text.insert(
            tk.END, 
            f"{i}. Date: {t['date']}, Description: {t['description']}, Amount: {t['amount']:.2f}\n"
        )

def generate_report():
    if not transactions:
        messagebox.showinfo("Report", "No transactions to report.")
        return
    total_amount = sum(t['amount'] for t in transactions)
    report_text = f"Total Transactions: {len(transactions)}\nTotal Amount: {total_amount:.2f}"
    messagebox.showinfo("Report", report_text)

def exit_program():
    if messagebox.askyesno("Exit", "Are you sure you want to exit?"):
        root.destroy()

# Main GUI Setup
root = tk.Tk()
root.title("Personal Finance Tracker")

transactions = []

# Buttons for main menu
tk.Label(root, text="Personal Finance Tracker", font=("Arial", 16)).pack(pady=10)

tk.Button(root, text="Add Transaction", command=add_transaction, width=30).pack(pady=5)
tk.Button(root, text="View Transactions", command=view_transactions, width=30).pack(pady=5)
tk.Button(root, text="Generate Report", command=generate_report, width=30).pack(pady=5)
tk.Button(root, text="Exit", command=exit_program, width=30).pack(pady=5)

root.mainloop()

