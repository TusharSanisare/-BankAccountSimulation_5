import java.util.Scanner;

public class Main {

  private static int option;
  private static Scanner scanner = new Scanner(System.in);
  private static Bank bank = new Bank();

  public static void main(String[] args) {
    System.out.println("Welcome to the Bank System!");

    while (true) {
      printOptionMessage();

      if (option == 0)
        System.exit(0);
      else if (option == 1) {
        creatingAccount();
      } else if (option == 2) {
        withdrawFromAccount();
      } else if (option == 3) {
        depositToAccount();
      } else if (option == 4) {
        transferBetweenAccounts();
      } else if (option == 5) {
        checkAccountBalance();
      } else if (option == 6) {
        viewTransactionHistory();
      }
    }

  }

  private static void viewTransactionHistory() {
    System.out.println("Checking your account history...");
    System.out.print("Enter phone number: ");
    String phoneNumber = scanner.nextLine();
    System.out.print("Enter password: ");
    String password = scanner.nextLine();
    String result = bank.getUserTrasactionHistory(phoneNumber, password);
    System.out.println(result);
  }

  private static void creatingAccount() {

    System.out.println("Creating a new account...");
    System.out.print("Enter username: ");
    String username = scanner.nextLine();
    System.out.print("Enter password: ");
    String password = scanner.nextLine();
    System.out.print("Enter email: ");
    String email = scanner.nextLine();
    System.out.print("Enter phone number: ");
    String phoneNumber = scanner.nextLine();
    String result = bank.createUser(username, password, email, phoneNumber);
    System.out.println(result);

  }

  private static void withdrawFromAccount() {
    System.out.println("Withdrawing from your account...");
    System.out.print("Enter phone number: ");
    String phoneNumber = scanner.nextLine();
    System.out.print("Enter password: ");
    String password = scanner.nextLine();
    System.out.print("Enter amount to withdraw: ");
    double amount = scanner.nextDouble();
    scanner.nextLine();
    String result = bank.withdrawFromUserAccount(phoneNumber, password, amount);
    System.out.println(result);
  }

  private static void depositToAccount() {
    System.out.println("Depositing to your account...");
    System.out.print("Enter phone number: ");
    String phoneNumber = scanner.nextLine();
    System.out.print("Enter password: ");

    String password = scanner.nextLine();
    System.out.print("Enter amount to deposit: ");
    double amount = scanner.nextDouble();
    scanner.nextLine();
    String result = bank.depositToUserAccount(phoneNumber, password, amount);
    System.out.println(result);

  }

  private static void transferBetweenAccounts() {
    System.out.println("Transferring between accounts...");
    System.out.print("Enter your phone number: ");
    String fromPhoneNumber = scanner.nextLine();
    System.out.print("Enter your password: ");
    String fromPassword = scanner.nextLine();
    System.out.print("Enter recipient's phone number: ");
    String toPhoneNumber = scanner.nextLine();
    System.out.print("Enter amount to transfer: ");
    double amount = scanner.nextDouble();
    scanner.nextLine();
    String result = bank.transferBetweenUserAccounts(fromPhoneNumber, fromPassword, toPhoneNumber, amount);
    System.out.println(result);
  }

  private static void checkAccountBalance() {
    System.out.println("Checking your account balance...");
    System.out.print("Enter phone number: ");
    String phoneNumber = scanner.nextLine();
    System.out.print("Enter password: ");
    String password = scanner.nextLine();
    String result = bank.getUserAccountBalance(phoneNumber, password);
    System.out.println(result);
  }

  public static void printOptionMessage() {

    System.out.println("Please choose an option:");
    System.out.println("press '1' to Create a new account");
    System.out.println("press '2' to With draw from your account");
    System.out.println("press '3' to Deposit to your account");
    System.out.println("press '4' to Transfer between accounts");
    System.out.println("press '5' to Check your account balance");
    System.out.println("press '6' to View transaction history");
    System.out.println("press '0' to Exit the system");

    System.out.print("Enter your choice: ");
    option = scanner.nextInt();
    scanner.nextLine();
  }
}
