// CheckingAccount subclass that inherits from BankAccount and includes an instance-specific interest rate

import javax.swing.JOptionPane;

public class CheckingAccount extends BankAccount {
    private double interestRate;
    private double overdraftFee = 30.0;

    // Constructor for CheckingAccount

    public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
        super(firstName, lastName, accountID); 
        this.interestRate = interestRate;
    }

    // Withdrawal method. Includes logic for applying overdraft fee

    public void processWithdrawal(double amount) {
        double availableFunds = getAccountBalance() + 200.0; // Allow overraft up to $200

        if (amount > availableFunds) {
            JOptionPane.showMessageDialog(null,
                "Withdrawal denied.\nInsufficient funds.\n(Including $200 overdraft protection)",
                "Transaction error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (getAccountBalance() - amount < 0) {
            // First overdraft event applies overdraft fee
            setBalance(getAccountBalance() - amount - overdraftFee);
            JOptionPane.showMessageDialog(null,
                String.format("Your account balance is negative.\nA %.2f overdraft fee has been applied.", overdraftFee),
                "Overdraft Notice",
                JOptionPane.WARNING_MESSAGE);
        } else {
            withdrawal(amount);
        }
    }

    // Display method that calls accountSummary from BankAccount, then adds interest rate

    public void displayAccountInfo() {
        accountSummary();
        System.out.printf("Interest Rate: %.2f%%%n", interestRate);
    }
}