import java.util.ArrayList;
import java.util.Hashtable;

public class BankServices {
    private final Hashtable<Integer, Double> bankAccount;
    private AccountInterface checkingAccount;
    private AccountInterface savingAccount;
    private ArrayList<Observer> observers;
    public String event;

    public BankServices () {
        this.bankAccount = new Hashtable<Integer, Double>();
    }

    public AccountInterface createNewAccount (String type, String owner) {

        switch (type) {
            case "Checking Account" -> {
                this.checkingAccount = new CheckingAccount(owner);
                this.bankAccount.put(this.checkingAccount.getAccountNumber(), this.checkingAccount.getBalance());
                return this.checkingAccount;
            }
            case "Saving Account" -> {
                this.savingAccount = new SavingAccount(owner);
                this.bankAccount.put(this.savingAccount.getAccountNumber(), this.savingAccount.getBalance());
                return this.savingAccount;
          }
        }
        return null;
    }


    public void deposit (AccountInterface account, double amount){
        account.deposit(amount);
    }

    public boolean withdraw (AccountInterface account, double amount) throws Exception {
        account.withdraw(amount);
        return true;
    }

    public void transfer (AccountInterface fromAccount, AccountInterface toAccount, double amount) throws Exception {
        if (fromAccount.withdraw(amount)){
            toAccount.deposit(amount);
        }
    }

}