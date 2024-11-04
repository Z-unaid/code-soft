package codeSoft;

public class Account {
    private double balance = 0;

    public Account(double amount) {
        this.balance = amount;
    }

    public int withdraw(double amount) {
        if (amount > balance) {
            return 0;
        } else if(amount < 0){
            return -1;
        }

        balance -= amount;
        return 1;
    }

    public boolean deposit(double amount){
        if(amount <= 0){
            return false;
        }

        balance += amount;
        return true;
    }

    public double checkBalance(){
        return this.balance;
    }
}