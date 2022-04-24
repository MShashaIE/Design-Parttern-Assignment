import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transfer implements ActionListener {
    private JTextField textFieldAmount;
    private JList list;
    private JButton transferButton;
    private JPanel panel;
    AccountInterface account;
    User user;
    JFrame frame;
    private final DefaultListModel<String> listModel;

    Transfer(AccountInterface account, User user) {
        this.account = account;
        this.user = user;
        listModel = new DefaultListModel<>();
        refreshListModel();
        frame = new JFrame("Transfer");
        frame.setContentPane(panel);
        frame.pack();
        frame.setSize(300, 200);
        frame.setVisible(true);
        list.setModel(listModel);
        transferButton.addActionListener(this);
        textFieldAmount.addActionListener(this);

    }

    private void refreshListModel() {
        listModel.clear();
        for (AccountInterface accountInterface : user.getAccounts()) {
            listModel.addElement(String.valueOf(accountInterface));
            listModel.removeElement(String.valueOf(account));
        }
    }

    private AccountInterface getAccount() {
        if (!list.isSelectionEmpty()) {
            for (AccountInterface account : user.getAccounts()) {
                if (account.getAccountNumber() == Integer.parseInt((String) list.getSelectedValue())) {
                    return account;
                }
            }
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == transferButton) {
            BankServices bankService = new BankServices();
            try {
                bankService.transfer( account,getAccount(), Integer.parseInt(textFieldAmount.getText()));
                frame.setVisible(false);
                frame.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Transfer Error", "Transfer", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
}