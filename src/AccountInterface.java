import java.util.LinkedList;

public interface AccountInterface {
    void deposit(double amount);

    boolean withdraw(double amount) throws Exception;

    int getAccountNumber();

    String getAccountType();

    String getUser();

    double getBalance();
    double getAmount();


    void setCard(Card card);

    LinkedList<Card> getCards();


    void registerObserver(Observer o);

    void notifyObservers();
}

