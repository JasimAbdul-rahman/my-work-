def show_main_menu():
    print(" Personal Finance Tracker: ")
    print("1. Add Transaction: ")
    print("2. View Transactions: ")
    print("3. Generate Report; ")
    print("4. Exit")

def add_transaction(transactions):
    print(" Add Transaction ")
    date = input("Enter transaction date (YYYY-MM-DD): ")
    description = input("Enter transaction description: ")
    amount = input("Enter transaction amount: ")
    transactions.append({"date": date, "description": description, "amount": amount})
    print("Transaction added successfully!")

def view_transactions(transactions):
    print(" View Transactions ")
    if not transactions:
        print("No transactions available.")
    else:
        for i, t in enumerate(transactions, start=1):
            print(f"{i}. Date: {t['date']}, Description: {t['description']}, Amount: {t['amount']}")

def generate_report(transactions):
    print(" Generate Report ")
    if not transactions:
        print("No transactions to report.")
        return
    total_amount = sum(float(t['amount']) for t in transactions)
    print(f"Total Transactions: {len(transactions)}")
    print(f"Total Amount: {total_amount:.2f}")

def main():
    transactions = []
    while True:
        show_main_menu()
        choice = input("Enter your choice (1-4): ")
        
        if choice == "1":
            add_transaction(transactions)
        elif choice == "2":
            view_transactions(transactions)
        elif choice == "3":
            generate_report(transactions)
        elif choice == "4":
            print("Exiting... Thank you for using the Personal Finance Tracker!")
            break
        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
 main()