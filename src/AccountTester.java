// Test Class with hardcoded user data to demonstrate BankAccount and CheckingAccount functionality

public class AccountTester {
    public static void main(String[] args) {
        System.out.println("--- Testing BankAccount ---");
        BankAccount user1 = new BankAccount("Alice", "Johnson", 1001);
        user1.deposit(200.00);
        user1.withdrawal(50);
        user1.accountSummary();

        System.out.println();

        System.out.println("--- Testing CheckingAccount ---");
        CheckingAccount user2= new CheckingAccount("Bob", "Smith", 2002, 2.5);
        user2.deposit(100.00);
        user2.processWithdrawal(101.00);
        user2.displayAccountInfo();

        System.out.println();

        CheckingAccount user3 = new CheckingAccount("Carol", "Baker", 2003, 1.75);
        user3.deposit(300.00);
        user3.processWithdrawal(100.00);
        user3.displayAccountInfo();
    }
}