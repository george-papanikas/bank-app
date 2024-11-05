package gr.aueb.cf.exceptions;

public class InsufficientBalanceException extends Exception {
    /* πρεπει να μοναδικοποιείται η κλαση μας μέσω της μεταβλητης αυτής γιατί υπάρχουν διάφορα version της ίδιας κλασης
      ..θα το δούμε στη πορεία αναλύτικότερα*/
    private static final long serialVersionUID  = 1L;

    public InsufficientBalanceException() {} // προβληματικο γιατι δεν εχει πληροφορια

    public InsufficientBalanceException (double balance, double amount) {
        super("Insufficient balance " + balance + " for amount " + amount);
        // η .getMessage() οταν κληθει θα δώσει το παραπάνω μήνυμα
        // H Exception εχει υπερφορτωμένο constructor με String για αυτό καλούμε την super με String
    }

}
