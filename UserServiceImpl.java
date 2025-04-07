import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private List<User> users = new ArrayList<>();
    private int userCounter = 1;

    @Override
    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId().equals("U" + id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User createUser(String name, String phone) {
        String userId = "U" + userCounter++;
        User newUser = new User(userId, name, phone);
        users.add(newUser);
        return newUser;
    }
}
