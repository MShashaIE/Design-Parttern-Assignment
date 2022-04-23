import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Account {

    static ArrayList<Integer> checkingAccounts = new ArrayList<>();
    static ArrayList<Integer> savingAccounts = new ArrayList<>();
    private int accountNumber;

    public Account() {
        this.accountNumber = 0;
    }



    public int generateAccountNumber(ArrayList<Integer> accounts, String leadDigit) {
        int a = new Random().nextInt(100000000);
        while (accounts.contains(a)) {
            a = new Random().nextInt(100000000);
        }
        if (String.valueOf(a).length() < 8) {
            String b = String.format("%08d", a);
            accountNumber = Integer.parseInt(leadDigit + b);
        } else {
            accountNumber = Integer.parseInt(leadDigit + a);
        }
        accounts.add(accountNumber);

        return accountNumber;
    }
}
