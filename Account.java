import java.util.ArrayList;
import java.util.List;

public class Account {
  private double balance;
  private List<AccountTransaction> transactions = new ArrayList<>();

  public Account() {
    this.balance = 0.0;
  }

  public double getBalance() {
    return balance;
  }

  public String deposit(double amount) {
    if (amount <= 0)
      return "Deposit amount must be positive";

    AccountTransaction transaction = new AccountTransaction();
    transaction.setTransactionType("Deposit");
    transaction.setInitialBalance(balance);
    transaction.setTransactionAmount(amount);
    balance += amount;
    transaction.setFinalBalance(balance);
    transaction.setTransactionDateTime(java.time.LocalDateTime.now());

    transactions.add(transaction);

    return "Deposit successful, new balance: " + balance;

  }

  public String withdraw(double amount) {
    if (amount <= 0 && amount <= balance)
      return "Withdrawal amount must be positive and less than or equal to the balance";

    AccountTransaction transaction = new AccountTransaction();
    transaction.setTransactionType("Withdrawal");
    transaction.setInitialBalance(balance);
    transaction.setTransactionAmount(amount);
    balance -= amount;
    transaction.setFinalBalance(balance);
    transaction.setTransactionDateTime(java.time.LocalDateTime.now());
    transactions.add(transaction);

    return "Withdrawal successful, new balance: " + balance;
  }

  public void transfer(Account toAccount, double amount) {
    if (toAccount == null) {
      throw new IllegalArgumentException("Target account cannot be null");
    }

    if (amount > 0 && amount <= balance) {
      this.withdraw(amount);
      toAccount.deposit(amount);
    }

    else {
      throw new IllegalArgumentException("Transfer amount must be positive and less than or equal to the balance");
    }
  }

  public String getTransactionHistory() {
    StringBuilder history = new StringBuilder();
    for (AccountTransaction transaction : transactions) {
      history.append("Type: ").append(transaction.getTransactionType())
          .append(", Amount: ").append(transaction.getTransactionAmount())
          .append(", Initial Balance: ").append(transaction.getInitialBalance())
          .append(", Final Balance: ").append(transaction.getFinalBalance())
          .append(", Date: ").append(transaction.getTransactionDateTime())
          .append("\n");
    }
    return history.toString();
  }

}
