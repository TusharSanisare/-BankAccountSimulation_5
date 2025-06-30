# 💳 Bank Account Simulation

### 📌 Task Objective
Simulate basic bank operations using Java and Object-Oriented Programming (OOP) principles.

---

### ✅ Features Implemented
- Account creation
- Deposit and withdrawal functionality
- Balance inquiry
- Account-to-account transfer
- Transaction history tracking with timestamp
- Simple authentication using phone number and password

---

### 🧠 Tech Stack
- Language: Java
- Tools: VS Code, Terminal
- No external libraries used

---

### 📁 File Structure
```
-BankAccountSimulation_5
├── Account.java // Manages balance, deposit, withdraw, transfer
├── AccountTransaction.java // Stores transaction metadata
├── Bank.java // Central controller for user management
├── User.java // Represents a bank user
├── Main.java // CLI-based driver class
```


### 📁 Files
*Bank.java* : Manages a list of users and handles operations like creating users and processing transactions.\
*Account.java*: Represents a bank account with methods for deposits, withdrawals, transfers, and transaction history.\
*AccountTransaction.java*: Stores transaction details (type, amount, balance, timestamp).\
*User.java*: Represents a bank user with attributes like username, password, email, phone number, and an associated account.\
*Main.java*: Provides the console-based interface for interacting with the banking system.\



### 🏃‍♂️ How to Run
1. Clone this repo:
```
git clone https://github.com/your-username/Bank-Account-Simulation.git
```
2. Navigate to the project:
```
cd -BankAccountSimulation_5
```
3. Compile and Run
```
javac *.java
java Main
```


### 📌 Notes
The program uses a simple in-memory list to store users (no persistent database).\
Passwords are stored as plain text, which is not secure for real-world use.\
The withdrawal logic in Account.java has a bug in the condition if (amount <= 0 && amount <= balance). It should be if (amount <= 0 || amount > balance) to prevent invalid withdrawals.\
No datasets or screenshots are included, as the program uses user input via the console.\


