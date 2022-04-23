import java.util.ArrayList;

public class AppEnvironment {

    private static final ArrayList<User> users = new ArrayList<>();


    public static  void addUser(User user) {
        AppEnvironment.users.add(user);
    }
}
