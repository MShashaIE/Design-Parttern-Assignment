public abstract class Notifier implements Observer {
    AccountInterface bankAccount;
    String event;


    public Notifier(AccountInterface bankAccount){
        this.bankAccount = bankAccount;
        bankAccount.registerObserver(this);
    }

    @Override
    public void update(String event){
        this.event = event;
        display();
    }

    public abstract void display();
}
