
class Account {
    String customerName;
    int accountNumber;
    double balance;

    Account(String customerName, int accountNumber, double balance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful! Balance: " + balance);
    }

    void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

class SavAcct extends Account {
    SavAcct(String customerName, int accountNumber, double balance) {
        super(customerName, accountNumber, balance);
    }

    void addInterest(double rate) {
        balance += balance * rate / 100;
        System.out.println("Interest added! New Balance: " + balance);
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful! Balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class CurAcct extends Account {
    double minBalance = 500;
    double penalty = 50;

    CurAcct(String customerName, int accountNumber, double balance) {
        super(customerName, accountNumber, balance);
    }

    void checkMinBalance() {
        if (balance < minBalance) {
            balance -= penalty;
            System.out.println("Penalty imposed. Balance: " + balance);
        }
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            checkMinBalance();
            System.out.println("Withdrawal successful! Balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        SavAcct savings = new SavAcct("John Doe", 101, 1000);
        savings.deposit(500);
        savings.addInterest(5);
        savings.withdraw(300);
        savings.displayBalance();

        System.out.println("-----------------------------");

        CurAcct current = new CurAcct("Jane Doe", 102, 600);
        current.deposit(400);
        current.withdraw(900);
        current.displayBalance();
    }
}
