public interface UserService {
    User getUserById(int id);

    User createUser(String name, String phone);
}