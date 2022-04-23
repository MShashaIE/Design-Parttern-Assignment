import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountGUI implements ActionListener, ListSelectionListener {
    private  JFrame frame;
    private JButton transferButton;
    private JButton loanRequestButton;
    public JButton withDrawButton;
    public JButton addCardButton;
    private JTextPane textPane1;
    private JPanel panel;
    private JList<String> listAccounts;
    private JButton depositButton;
    private JButton addAccount;
    private JPanel panel1;
    private JLabel labelAccounts;
    private JLabel labelDetails;

    private final User user;
    private final DefaultListModel<String> listModel;


    public AccountGUI(User user) {

        this.user = user;
        listModel = new DefaultListModel<>();
        refreshListModel();

        labelAccounts.setText(user.getUsername() + " Account");
        labelDetails.setText(user.getUsername() + " Account Details");
        frame = new JFrame("Account");


        panel1.setLayout(new GridLayout(6, 1, 10, 5));

        panel1.add(new CoolDecorator(addAccount));
        panel1.add(new CoolDecorator(addCardButton));
        panel1.add(new CoolDecorator(depositButton));
        panel1.add(new CoolDecorator(withDrawButton));
        panel1.add(new CoolDecorator(transferButton));
        panel1.add(new CoolDecorator(loanRequestButton));


        listAccounts.setModel(listModel);

        frame.getContentPane().add(panel);
        frame.setTitle("Welcome to Menu " + user.getUsername());
        frame.setSize(700, 350);
        frame.setVisible(true);

        addCardButton.addActionListener(this);
        transferButton.addActionListener(this);
        depositButton.addActionListener(this);
        addAccount.addActionListener(this);
        withDrawButton.addActionListener(this);
        listAccounts.addListSelectionListener(this);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addCardButton) {

            new AddCard(getAccount(), user);
        }

        if (e.getSource() == transferButton) {
            new Transfer(getAccount(), user);
        }
        if (e.getSource() == withDrawButton) {
            double amount = Double.parseDouble(JOptionPane.showInputDialog(frame, " amount to withdraw"));
            try {
                getAccount().withdraw(amount);
                refreshListModel();
            } catch (CustomException exception) {
                JOptionPane.showMessageDialog(frame, "Attempted to withdraw " + amount + " > in Account: " + getAccount().getBalance(), "withdraw money outOfBound", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }
        if (e.getSource() == depositButton) {
            double amount = Double.parseDouble(JOptionPane.showInputDialog(frame, " amount to deposit"));
            getAccount().deposit(amount);
            refreshListModel();

        }
        if (e.getSource() == addAccount) {
            frame.setVisible(false);
            frame.dispose();
            new AddAccountGUI(user);


        }
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!listAccounts.isSelectionEmpty()) {

            AccountInterface account = getAccount();

            assert account != null;
            StringBuilder accountInfo = new StringBuilder("Account Type: " + account.getAccountType() + "\n\nCards:\n");

            if (account.getCards().size() == 0)
                accountInfo.append("None\n");
            else {
                for (Card card : account.getCards()) {
                    accountInfo.append(card.getCardType()).append(" Number ").append(card.getCardNum()).append("\n");
                }
            }

            accountInfo.append("\nBalance: ").append(account.getBalance());

            textPane1.setText(accountInfo.toString());
        }

    }


    private void refreshListModel() {
        listModel.clear();
        for (AccountInterface accountInterface : user.getAccounts()) {
            listModel.addElement(String.valueOf(accountInterface));

        }
    }

    private AccountInterface getAccount() {
        if (!listAccounts.isSelectionEmpty()) {
            for (AccountInterface account : user.getAccounts()) {
                if (account.getAccountNumber() == Integer.parseInt((String) listAccounts.getSelectedValue())) {
                    return account;
                }
            }
        }
        return null;
    }

}
