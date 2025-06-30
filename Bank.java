import java.util.ArrayList;
import java.util.List;

public class Bank {

  private List<User> user = new ArrayList<>();

  public void addUser(User user) {
    this.user.add(user);
  }

  public User getUserPhoneAndPass(String phoneNumber, String password) {
    for (User u : user) {
      if (u.getPhoneNumber().equals(phoneNumber) && u.getPassword().equals(password)) {
        return u;
      }
    }
    return null;
  }

  public User getUserPhone(String phoneNumber) {
    for (User u : user) {
      if (u.getPhoneNumber().equals(phoneNumber))
        return u;
    }
    return null;
  }

  public List<User> getAllUsers() {
    return user;
  }

  public String createUser(String username, String password, String email, String phoneNumber) {
    for (User u : user) {
      if (u.getEmail().equals(email) || u.getPhoneNumber().equals(phoneNumber)) {
        return "User already exists";
      }
    }
    User newUser = new User(username, password, email, phoneNumber);
    addUser(newUser);
    return "User created successfully";
  }

  public String getUserAccountBalance(String phoneNumber, String password) {
    User user = getUserPhoneAndPass(phoneNumber, password);
    if (user != null) {
      return "Your account balance is: " + user.getAccount().getBalance();
    }
    return "Invalid phone number or password";
  }

  public String getUserTrasactionHistory(String phoneNumber, String password) {
    User user = getUserPhoneAndPass(phoneNumber, password);
    if (user != null) {
      return user.getAccount().getTransactionHistory();
    }
    return "Invalid phone number or password";
  }

  public String depositToUserAccount(String phoneNumber, String password, double amount) {
    User user = getUserPhoneAndPass(phoneNumber, password);
    if (user != null) {
      return user.getAccount().deposit(amount);
    }
    return "Invalid phone number or password";
  }

  public String withdrawFromUserAccount(String phoneNumber, String password, double amount) {
    User user = getUserPhoneAndPass(phoneNumber, password);
    if (user != null) {
      return user.getAccount().withdraw(amount);
    }
    return "Invalid phone number or password";
  }

  public String transferBetweenUserAccounts(String fromPhoneNumber, String fromPassword, String toPhoneNumber,
      double amount) {
    User fromUser = getUserPhoneAndPass(fromPhoneNumber, fromPassword);
    User toUser = getUserPhone(toPhoneNumber); // Password not needed for recipient
    if (fromUser != null && toUser != null) {
      if (fromUser.getAccount().getBalance() >= amount) {
        fromUser.getAccount().transfer(toUser.getAccount(), amount);
        return "Transfer successful, new balance: " + fromUser.getAccount().getBalance();
      } else {
        return "Insufficient balance for transfer";
      }
    }
    return "Invalid phone number or password for sender or recipient";
  }

}
