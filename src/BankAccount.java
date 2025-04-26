class BankAccount {
    String firstName;
    String lastName;
    int accountID;
    double balance;

    // Constructor
    
    public BankAccount(String firstName, String lastName, int accountID) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.accountID = accountID;
       this.balance = 0.0;
    }

    // Increment/Decrement methods for deposits and withdrawals

    public void deposit(double depositAmount) {
        balance += depositAmount;
    }

    public void withdrawal(double withdrawalAmount) {
        balance -= withdrawalAmount; 
    }

    // Account summary method that outputs the account information for the user

    public void accountSummary() {
        System.out.println("Account Summary:");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Account ID: " + accountID);
        System.out.println("Current Balance: " + balance);
    }

    // === Getters/Setters ===

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAccountID() {
        return accountID;
    }

    public double getAccountBalance() {
        return balance;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}