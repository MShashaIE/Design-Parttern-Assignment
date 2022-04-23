import java.util.LinkedList;

public interface AccountInterface {
    public void deposit(double amount);

    public boolean withdraw(double amount) throws Exception;

    public int getAccountNumber();

    public String getAccountType();

    public double getBalance();


    void setCard(Card card);

    LinkedList<Card> getCards();
}

