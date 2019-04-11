
package io.github.bonigarcia;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class LoginControllerBDDTest {

    @InjectMocks
    LoginController loginController;

    @Mock
    LoginService loginService;

    private UserForm userForm = new UserForm("foo", "bar");

    @Test
    void testLoginOk() {
        given(loginService.login(userForm)).willReturn(true);
        assertEquals("OK", loginController.login(userForm));
    }

    @Test
    void testLoginKo() {
        given(loginService.login(userForm)).willReturn(false);
        assertEquals("KO", loginController.login(userForm));
    }

    @Test
    void testLoginError() {
        assertEquals("ERROR", loginController.login(null));
    }

    @Test
    void testLoginException() {
        given(loginService.login(any(UserForm.class)))
                .willThrow(IllegalArgumentException.class);
        assertEquals("ERROR", loginController.login(userForm));
    }

}
