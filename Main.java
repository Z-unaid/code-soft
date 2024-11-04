package codeSoft;

public class Main {
    public static void main(String[] args) {
        Account user = new Account(500);
        ATM atm = new ATM(user);

        atm.start();
    }
}
