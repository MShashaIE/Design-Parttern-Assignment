import java.util.ArrayList;

public class User {

    private String username;

    private ArrayList<AccountInterface> accounts = new ArrayList<>();

    public User() {
    }

    public final String getUsername() {
        return username;
    }

    public final void setUsername(String username) {
        this.username = username;
    }

    public final ArrayList<AccountInterface> getAccounts() {
        return accounts;
    }

    public final void setAccounts(ArrayList<AccountInterface> accounts) {
        this.accounts = accounts;
    }

    public final void addAccount(AccountInterface account) {
        this.accounts.add(account);
    }

}