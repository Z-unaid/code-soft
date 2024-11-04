package codeSoft;

import java.util.Scanner;

public class ATM {
    private Account bankAccount = null;
    private final Scanner scan = new Scanner(System.in);

    public ATM(Account bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void start() {
        int choice;

        while (true) {
            System.out.println("""
                    
                    Choices:\s
                    1. to Withdraw Amount.
                    2. to deposit Amount.
                    3. to check Balance.
                    4. To exit.""");

            System.out.print("Enter Your Choice: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    handleWithdraw();
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    handleCheckBalance();
                    break;
                case 4:
                    System.out.println("Exited");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    private void handleWithdraw() {
        System.out.print("Enter Amount: ");
        int amount = scan.nextInt();

        int response = bankAccount.withdraw(amount);

        if (response == 1) {
            System.out.println(amount + " rupees debited From your account");
            handleCheckBalance();
        } else if (response == 0) {
            System.out.println("Insufficient Funds!");
        } else {
            System.out.println("Invalid Withdraw Amount!");
        }
    }

    public void handleDeposit() {
        System.out.print("Enter Amount: ");
        double amount = scan.nextInt();

        boolean response = bankAccount.deposit(amount);

        if (response) {
            System.out.println(amount + " rupees Credit in Your Account");
            handleCheckBalance();
        } else {
            System.out.println("Invalid Deposit Amount");
        }
    }

    public void handleCheckBalance() {
        System.out.println("Account Balance: " + bankAccount.checkBalance());
    }
}
