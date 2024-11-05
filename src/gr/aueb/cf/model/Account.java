package gr.aueb.cf.model;

import gr.aueb.cf.exceptions.InsufficientBalanceException;
import gr.aueb.cf.exceptions.NegativeAmountException;
import gr.aueb.cf.exceptions.SsnNotValidException;
public class Account extends IdentifiableEntity {
    private User holder = new User(); // composition
    private String iban;
    private double balance;

    public Account() {}
        // super() is implied as long as all other variables

    public Account(User holder, String iban, double balance) {
        this.holder = holder;
        this.iban = iban;
        this.balance = balance;
    }

    public User getHolder() {
        return holder;
    }

    public void setHolder(User holder) {
        this.holder = holder;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "holder=" + holder + // toString() is called here but it is not stated
                ", iban='" + iban + '\'' +
                ", balance=" + balance +
                '}';
    }

    // Public API

    /**
     * deposits a certain amount of money
     * @param amount
     * @throws NegativeAmountException
     */
    public void deposit(double amount) throws NegativeAmountException {
        try {
            if (amount < 0) {
                throw new NegativeAmountException(amount);
            }
            balance += amount;
        } catch (NegativeAmountException e) {
            System.err.println("Error: Negative amount"); // logging μνμ, όχι για τον χρήστη
            throw e;
        }
    }

    /**
     *
     * @param amount
     * @param ssn
     * @throws InsufficientBalanceException
     * @throws SsnNotValidException
     * @throws NegativeAmountException
     */
    public void withdraw(double amount, String ssn)
            throws InsufficientBalanceException, SsnNotValidException, NegativeAmountException {
        try {
            if (amount < 0) throw new NegativeAmountException(amount);
            if (amount > balance) throw new InsufficientBalanceException(balance, amount);
            if (!isSsnValid(ssn)) throw new SsnNotValidException(ssn);

            balance -=  amount;
        } catch (InsufficientBalanceException | SsnNotValidException | NegativeAmountException e) {
            System.err.println("Error: withdrawal");
            throw e;
        }
    }

    protected boolean isSsnValid(String ssn) {
        if (ssn == null || holder.getSsn() == null) {
            return false;
        }
        return holder.getSsn().equals(ssn);
    }

}
