import java.util.ArrayList;
import java.util.List;

public class BankSystem {
    private List<Account> accounts;

    public BankSystem() {
        this.accounts = new ArrayList<>();
    }

    public void createAccount(String accountNumber, String accountHolder, double initialBalance) {
        Account account = new Account(accountNumber, accountHolder, initialBalance);
        accounts.add(account);
        System.out.println("Conta criada com sucesso!");
    }

    public void deposit(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account!= null) {
            account.deposit(amount);
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account!= null) {
            if (account.getBalance() >= amount) {
                account.withdraw(amount);
                System.out.println("Saque realizado com sucesso!");
            } else {
                System.out.println("Saldo insuficiente!");
            }
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public void checkBalance(String accountNumber) {
        Account account = findAccount(accountNumber);
        if (account!= null) {
            System.out.println("Saldo atual: " + account.getBalance());
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);
        if (fromAccount!= null && toAccount!= null) {
            if (fromAccount.getBalance() >= amount) {
                fromAccount.withdraw(amount);
                toAccount.deposit(amount);
                System.out.println("Transferência realizada com sucesso!");
            } else {
                System.out.println("Saldo insuficiente!");
            }
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    private Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}