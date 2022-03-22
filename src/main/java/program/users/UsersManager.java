package program.users;

import program.users.models.User;

public interface UsersManager {

    User createUser(String username, String password);

    void addUser(User newUser);

    void updateUser(String user, String newUsername, String newPassword);

    User findUser(String username);

    boolean deleteUser(String username);

    boolean authorize(User user);

    boolean authentication(User user);

    boolean isPresent(User user);
}
