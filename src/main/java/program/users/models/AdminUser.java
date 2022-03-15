package program.users.models;

public class AdminUser extends User {

    public AdminUser() {
    }

    public AdminUser(String username, String password) {
        super(username,password);
        role = UserRole.ADMIN;
    }

}
