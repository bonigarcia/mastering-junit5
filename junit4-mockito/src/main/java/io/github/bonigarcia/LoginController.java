
package io.github.bonigarcia;

class LoginController {
    private LoginService loginService;

    public String login(UserForm userForm) {
        System.out.println("LoginController.login " + userForm);

        try {
            if (userForm == null) {
                return "ERROR";
            } else if (loginService.login(userForm)) {
                return "OK";
            } else {
                return "KO";
            }
        } catch (Exception e) {
            return "ERROR";
        }
    }

    public void logout(UserForm userForm) {
        System.out.println("LoginController.logout " + userForm);

        loginService.logout(userForm);
    }

}
