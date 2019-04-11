
package io.github.bonigarcia;

import java.util.HashMap;
import java.util.Map;

class LoginRepository {

    Map<String, String> users;

    public LoginRepository() {
        // Users of the system are stored in this map (key=username,
        // value=password)
        users = new HashMap<>();
        users.put("user1", "p1");
        users.put("user2", "p3");
        users.put("user3", "p4");
    }

    public boolean login(UserForm userForm) {
        System.out.println("LoginRepository.login " + userForm);

        String username = userForm.getUsername();
        String password = userForm.getPassword();

        return users.keySet().contains(username)
                && users.get(username).equals(password);
    }

}
