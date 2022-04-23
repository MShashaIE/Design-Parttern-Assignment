import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAccountGUI implements ActionListener {
    private JComboBox comboBox1;
    private JButton selectButton;
    private JPanel panel;
    JFrame frameAdd;
    private User user;


    public AddAccountGUI(User user) {
        this.user = user;
        frameAdd = new JFrame("Create Account");
        frameAdd.setContentPane(panel);
        frameAdd.pack();
        frameAdd.setSize(300, 200);
        frameAdd.setVisible(true);
        comboBox1.addActionListener(this);
        selectButton.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BankServices myBankingService = new BankServices();

        if (e.getSource() == selectButton) {
            if (comboBox1.getSelectedIndex() == 0) {
                AccountInterface checkingAccount = myBankingService.createNewAccount(comboBox1.getSelectedItem().toString(), user.getUsername());
                user.addAccount(checkingAccount);
                new AccountGUI(user);
                frameAdd.setVisible(false);
                frameAdd.dispose();
                System.out.println("Track");
            } else {
                AccountInterface savingAccount = myBankingService.createNewAccount(comboBox1.getSelectedItem().toString(), user.getUsername());
                user.addAccount(savingAccount);
                new AccountGUI(user);
                frameAdd.setVisible(false);
                frameAdd.dispose();
                System.out.println("Track");
            }
        }
    }

}




