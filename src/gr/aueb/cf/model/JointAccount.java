package gr.aueb.cf.model;

public class JointAccount extends Account{
    private User secondHolder = new User(); // καλο ειναι να γινεται new για να μην εχω nulls αλλα δεν ειναι απαραιτητο

    public JointAccount() {}

    public JointAccount(User holder, String iban, double balance, User secondHolder) {
        super(holder, iban, balance);
        this.secondHolder = secondHolder;
    }

    public User getSecondHolder() {
        return secondHolder;
    }

    public void setSecondHolder(User secondHolder) {
        this.secondHolder = secondHolder;
    }

    @Override
    public String toString() {
        return "JointAccount{" + "First Holder=" + getHolder() +
                ", secondHolder=" + secondHolder + ", iban=" + getIban() +
                ", balance=" + getBalance() + '}';
    }

    @Override
    protected boolean isSsnValid(String ssn) {
        return super.isSsnValid(ssn) || secondHolder.getSsn().equals(ssn); // βεβαια θα μπορουσε να ναι null το secondHolder.getSsn()
        // το οποιο θεωρουμε οτι δεν ειναι null
    }
}
