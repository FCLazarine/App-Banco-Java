public class Main {
    public static void main(String[] args) {
        BankSystem bankSystem = new BankSystem();

        bankSystem.createAccount("123456", "John Doe", 1000.0);
        bankSystem.createAccount("789012", "Jane Doe", 500.0);

        bankSystem.deposit("123456", 500.0);
        bankSystem.withdraw("123456", 200.0);
        bankSystem.checkBalance("123456");

        bankSystem.transfer("123456", "789012", 300.0);
        bankSystem.checkBalance("789012");
    }
}