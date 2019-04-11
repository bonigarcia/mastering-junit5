
package io.github.bonigarcia;

public class UserForm {

    public String username;
    public String password;

    public UserForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters

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

    @Override
    public String toString() {
        return "UserForm [username=" + username + ", password=" + password
                + "]";
    }

}
