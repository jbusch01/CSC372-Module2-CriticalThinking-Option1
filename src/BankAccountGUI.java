import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankAccountGUI extends JFrame implements ActionListener {
    private BankAccount userAccount;
    private JTextField amountField;
    private JLabel balanceLabel;

    public BankAccountGUI() {
        userAccount = new BankAccount("John", "Smith", 1234);

        setTitle("Bank Account Information");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton showBalanceButton = new JButton("Show Balance");
        amountField = new JTextField(10);
        balanceLabel = new JLabel("Balance: $" + userAccount.getAccountBalance());

        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        showBalanceButton.addActionListener(this);

        panel.add(new JLabel("Amount:"));
        panel.add(amountField);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(showBalanceButton);

        add(panel, BorderLayout.CENTER);
        add(balanceLabel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        double amount = 0.0;

        try {
            amount = Double.parseDouble(amountField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
            return;
        }

        if (command.equals("Deposit")) {
            userAccount.deposit(amount);
        } else if (command.equals("Withdraw")) {
            userAccount.withdrawal(amount);
        } else if (command.equals("Show Balance")) {
            // no action needed. Refreshes display
        }

        balanceLabel.setText("Balance: $" + String.format("%.2f", userAccount.getAccountBalance()));
    }

    public static void main(String[] args) {
        BankAccountGUI window = new BankAccountGUI();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Final Balance: $" + window.userAccount.getAccountBalance());
        }));
    }    
}