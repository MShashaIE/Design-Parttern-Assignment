import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AddUserGUI implements ActionListener {
    private JPanel panel1;
    private JTextField textField1;
    private JButton createUserButton;
    JFrame frame;

    public AddUserGUI() {
        frame = new JFrame("Create Account");
        frame.setContentPane(panel1);
        frame.pack();
        createUserButton.addActionListener(this);
        frame.setVisible(true);
        frame.setSize(300,200);


    }

    public static void main(String[] args) {
      new AddUserGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!Objects.equals(textField1.getText(), "")){
            User user = new User();
            AppEnvironment.addUser(user);
            user.setUsername(textField1.getText());
            frame.setVisible(false);
            frame.dispose();
            new AccountGUI(user);
        }
        else {
            JOptionPane.showMessageDialog(frame,"Please enter your Name","emptyName",JOptionPane.ERROR_MESSAGE);
        }

    }
}
