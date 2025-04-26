// CheckingAccount subclass that inherits from BankAccount and includes an instance-specific interest rate
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
        if (getAccountBalance() - amount < 0) {
            setBalance(getAccountBalance() - amount - overdraftFee);
            System.out.printf("Your account balance is negative. $%.2f overdraft fee applied.%n", overdraftFee);
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