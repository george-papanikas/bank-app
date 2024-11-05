package gr.aueb.cf;

import gr.aueb.cf.exceptions.InsufficientBalanceException;
import gr.aueb.cf.exceptions.NegativeAmountException;
import gr.aueb.cf.exceptions.SsnNotValidException;
import gr.aueb.cf.model.Account;
import gr.aueb.cf.model.OverdraftAccount;
import gr.aueb.cf.model.OverdraftJointAccount;
import gr.aueb.cf.model.User;

public class Main {

    public static void main(String[] args) {
        User a8an = new User("Ath.", "A.", "12345");
        User anna = new User("Anna", "G.", "56789");
        Account account = new Account(a8an, "GR12345", 100);
        Account overA8an = new OverdraftAccount(a8an, "GR23456", 50);
        Account overJointAccount = new OverdraftJointAccount(a8an, "GR256789", 200.5, anna);

        try {
            System.out.println("Account: \n" + account); // .toString() is applied here (note it should be overloaded)
            System.out.println("Overdraft: \n" + overA8an );
            System.out.println("Overdraft joint: \n" + overJointAccount);

            overJointAccount.deposit(100);
            overJointAccount.withdraw(50, "56789");

        } catch (NegativeAmountException | InsufficientBalanceException | SsnNotValidException e) {
            System.out.println(e.getMessage());
        }

    }
}
