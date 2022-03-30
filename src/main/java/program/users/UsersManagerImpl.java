package program.users;

import program.users.models.AdminUser;
import program.users.models.StandardUser;
import program.users.models.User;
import program.users.models.UserRole;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

//import static program.ui.InitialView.USERS_MANAGER;

public class UsersManagerImpl implements UsersManager {

    public static List<User> users = new ArrayList<>();

    public static final User admin = new AdminUser("admin", "1111");

    public static final User user1 = new StandardUser("ja", "123");

    public UsersManagerImpl() {
        users.add(admin);
        users.add(user1);
    }

    @Override
    public void addUser(User newUser) {
        users.add(newUser);
    }

    @Override
    public void updateUser(String currentUsername, String newUsername, String newPassword) {
        var u = findUser(currentUsername);
        users.remove(u);

        u.setUsername(newUsername);
        u.setPassword(newPassword);

        users.add(u);
    }

    @Override
    public User findUser(String username) {
        return users.stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("User not found - " + username));
    }

    @Override
    public boolean deleteUser(String username) {
        var u = findUser(username);
        return users.remove(u);
    }

    @Override
    public boolean authentication(User user) {
        User u = findUser(user.getUsername());
        return u.getPassword().equals(user.getPassword());
    }

    @Override
    public boolean authorize(User user) {
        User u = findUser(user.getUsername());
        return u.getRole().equals(UserRole.ADMIN); // trywialna implementacja,
    }

    @Override
    public boolean isPresent(User user) {
        return users.stream()
                .anyMatch(u -> u.getUsername().equalsIgnoreCase(user.getUsername()));
    }
}
