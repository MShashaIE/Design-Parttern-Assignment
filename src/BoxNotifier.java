import javax.swing.*;


public class BoxNotifier extends Notifier {
    public BoxNotifier(AccountInterface bankAccount) {
        super(bankAccount);

    }


    @Override
    public void display(){


        if(event.equals("withdraw")){

            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"you have withdrew "+bankAccount.getAmount(),"Notifier",JOptionPane.INFORMATION_MESSAGE);
        }
        if(event.equals("deposit")){
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"you have deposited "+bankAccount.getAmount(),"Notifier",JOptionPane.INFORMATION_MESSAGE);
        }


    }
}
