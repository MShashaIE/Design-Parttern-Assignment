import java.util.ArrayList;
import java.util.LinkedList;

public class SavingAccount implements AccountInterface {


    private double balance;
    private final int accountNumber;
    private final String type;
    private final LinkedList<Card> cards = new LinkedList<Card>();
    private final String owner;
    private final ArrayList<Observer> observers;
    private String event;
    private double amount;


    public SavingAccount(String owner) {
        this.balance = 0;
        this.accountNumber = new Account().generateAccountNumber(Account.checkingAccounts, "2");
        this.type = "Saving Account";
        this.owner = owner;
        observers = new ArrayList<>();
    }

    public final LinkedList<Card> getCards() {
        return cards;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(event);
        }
    }
    void statusChanged(){
        notifyObservers();
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAccountType() {
        return this.type;
    }

    @Override
    public String getUser() {
        return owner;
    }

    public void deposit(double amount) {
        this.balance += amount;
        this.event="deposit";
        setAmount(amount);
        statusChanged();

    }

    public boolean withdraw(double amount) throws Exception {
        if (amount > getBalance()) {
            throw new CustomException();

        } else {
            balance -= amount;
            this.event="withdraw";
            setAmount(amount);
            statusChanged();
            return true;

        }
    }

    @Override
    public String toString() {
        return accountNumber + "";
    }


}
