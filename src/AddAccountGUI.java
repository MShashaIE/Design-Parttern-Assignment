import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AddAccountGUI implements ActionListener {
    private JComboBox comboBox1;
    private JButton selectButton;
    private JPanel panel;
    JFrame frameAdd;
    private final User user;


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
                AccountInterface checkingAccount = myBankingService.createNewAccount(Objects.requireNonNull(comboBox1.getSelectedItem()).toString(), user.getUsername());
                user.addAccount(checkingAccount);
                new BoxNotifier(checkingAccount);
                new AccountGUI(user);
                frameAdd.setVisible(false);
                frameAdd.dispose();
                System.out.println("Track1");
            } else {
                AccountInterface savingAccount = myBankingService.createNewAccount(Objects.requireNonNull(comboBox1.getSelectedItem()).toString(), user.getUsername());
                user.addAccount(savingAccount);
                new BoxNotifier(savingAccount);
                new AccountGUI(user);
                frameAdd.setVisible(false);
                frameAdd.dispose();
                System.out.println("Track2");
            }
        }
    }

}




