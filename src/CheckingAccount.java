import java.util.ArrayList;
import java.util.LinkedList;

public class  CheckingAccount implements AccountInterface {


    private  double  balance;
    private final int accountNumber;
    private final String type;
    private final LinkedList<Card> cards = new LinkedList<Card>();
    private final String owner;
    private final ArrayList<Observer> observers;
    private String event;
    public  double amount;



    public CheckingAccount(String owner) {
        this.balance = 0;
        this.accountNumber = new Account().generateAccountNumber(Account.checkingAccounts, "1");
        this.type = "Checking Account";
        this.owner = owner;
        observers = new ArrayList<>();


    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

    public String getAccountType() {
        return this.type;
    }


    public String getUser() {
        return owner;
    }

    public void deposit(double amount) {
        balance += amount;
        this.event="deposit";
        setAmount(amount);
        statusChanged();

    }

    public boolean withdraw(double amount) throws Exception {
        if (amount > getBalance()) {
            throw new CustomException();

        } else {
            this.balance -= amount;
            setAmount(amount);
            this.event="withdraw";
            statusChanged();
            return true;

        }
    }

    @Override
    public String toString() {
        return accountNumber + "";
    }


}
