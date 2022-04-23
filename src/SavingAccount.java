import java.util.LinkedList;

public class SavingAccount implements AccountInterface {


    private double balance;
    private int accountNumber;
    private String type;
    private LinkedList<Card> cards = new LinkedList<Card>();
    private String owner;

    public SavingAccount(String owner) {
        this.balance = 0;
        this.accountNumber = new Account().generateAccountNumber(Account.savingAccounts, "2");
        this.type = "Saving Account";
        this.owner = owner;
    }

    public final LinkedList<Card> getCards() {
        return cards;
    }

    public void setCard(Card card) {
        cards.add(card);
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getAccountType() {
        return this.type;
    }

    public void deposit(double amount) {
        this.balance += amount;

    }

    public boolean withdraw(double amount) {
        if (amount > getBalance()) {

            return false;
        } else {
            balance -= amount;
            return true;
        }
    }

    @Override
    public String toString() {
        return ""+accountNumber;
    }
}

