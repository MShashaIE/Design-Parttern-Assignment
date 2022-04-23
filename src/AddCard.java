import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCard implements ActionListener {
    private JPanel panel1;
    private JButton addCard;
    private JComboBox cardType;
    AccountInterface account;
    JFrame frame;
    private User user;

    public AddCard(AccountInterface account, User user) {
        this.account = account;
        this.user = user;
        frame = new JFrame("Card Type");
        frame.setContentPane(panel1);
        frame.pack();
        frame.setSize(300, 200);
        frame.setVisible(true);
        this.account = account;
        cardType.addActionListener(this);
        addCard.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addCard) {
            if (cardType.getSelectedIndex() == 0) {
                try {
                    Card card1 = CreateCard.createCard("Debit");
                    account.setCard(card1);
                    new AccountGUI(user);
                    frame.setVisible(false);
                    frame.dispose();
                } catch (CustomException ex) {
                    JOptionPane.showMessageDialog(frame, "Only One DebitCard Allowed", "handle", JOptionPane.ERROR_MESSAGE);
                    new AccountGUI(user);
                    frame.setVisible(false);
                    frame.dispose();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        } else if (cardType.getSelectedIndex() == 1) {
            try {
                Card card1 = CreateCard.createCard("credit");
                account.setCard(card1);
                new AccountGUI(user);
                frame.setVisible(false);
                frame.dispose();
            } catch (CustomException ex) {
                JOptionPane.showMessageDialog(frame, "Only One CreditCard Allowed", "handle", JOptionPane.ERROR_MESSAGE);
                new AccountGUI(user);
                frame.setVisible(false);
                frame.dispose();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
}


