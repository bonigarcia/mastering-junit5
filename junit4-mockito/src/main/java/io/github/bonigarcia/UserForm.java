
package io.github.bonigarcia;

public class UserForm {

    public String password;
    public String username;

    public UserForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserForm [password=" + password + ", username=" + username
                + "]";
    }

}
