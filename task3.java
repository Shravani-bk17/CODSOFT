
    import java.util.Scanner;

// 4. Create a class to represent the user's bank account
class BankAccount {
    private double balance;

    // Constructor to initialize the starting balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // 3. Method to check balance
    public double getBalance() {
        return balance;
    }

    // 3. Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Error: Deposit amount must be positive.");
        }
    }

    // 3. Method to withdraw money with input validation
    public boolean withdraw(double amount) {
        // 6. Validate user input (check for sufficient balance)
        if (amount > balance) {
            System.out.println("Error: Insufficient balance! Your current balance is: $" + balance);
            return false; // Transaction failed
        } else if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be positive.");
            return false; // Transaction failed
        } else {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
            return true; // Transaction succeeded
        }
    }
}

// 1. Create a class to represent the ATM machine
public class task3 {
    // 5. Connect the ATM class with the user's bank account class
    private BankAccount account;

    public task3(BankAccount account) {
        this.account = account;
    }

    // 2. Design the user interface for the ATM
    public void startInterface() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=========================================");
            System.out.println("             ATM INTERFACE               ");
            System.out.println("=========================================");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            
            int choice = scanner.nextInt();

            // 7. Display appropriate messages based on chosen options
            switch (choice) {
                case 1:
                    System.out.println("Current Balance: $" + account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option! Please pick a number between 1 and 4.");
                    break;
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        // Initialize a bank account with a starting balance of $1000.00
        BankAccount userAccount = new BankAccount(1000.00);
        
        // Pass the account into the ATM and start the interface
        task3 atmMachine = new task3(userAccount);
        atmMachine.startInterface();
    }
}

