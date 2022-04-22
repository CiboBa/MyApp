package program.users.models;

public abstract class User {

    private String username;
    private String password;
    protected UserRole role;

    protected User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = UserRole.STANDARD;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }
}
