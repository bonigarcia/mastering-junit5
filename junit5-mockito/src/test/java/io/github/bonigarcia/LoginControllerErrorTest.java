
package io.github.bonigarcia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LoginControllerErrorTest {

    @InjectMocks
    LoginController loginController;

    @Mock
    LoginService loginService;

    UserForm userForm = new UserForm("foo", "bar");

    @Test
    void testLoginError() {
        // Exercise
        String response = loginController.login(null);

        // Verify
        assertEquals("ERROR", response);
    }

    @Test
    void testLoginException() {
        // Expectation
        when(loginService.login(any(UserForm.class)))
                .thenThrow(IllegalArgumentException.class);

        // Exercise
        String response = loginController.login(userForm);

        // Verify
        assertEquals("ERROR", response);
    }

}
