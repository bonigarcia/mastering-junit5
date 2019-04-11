
package io.github.bonigarcia;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerBDDTest {

    @InjectMocks
    private LoginController loginController;

    @Mock
    private LoginService loginService;

    private UserForm userForm = new UserForm("foo", "bar");

    @Test
    public void testLoginOk() {
        given(loginService.login(userForm)).willReturn(true);
        assertEquals("OK", loginController.login(userForm));
    }

    @Test
    public void testLoginKo() {
        given(loginService.login(userForm)).willReturn(false);
        assertEquals("KO", loginController.login(userForm));
    }

    @Test
    public void testLoginError() {
        assertEquals("ERROR", loginController.login(null));
    }

    @Test
    public void testLoginWithException() {
        given(loginService.login(userForm))
                .willThrow(IllegalArgumentException.class);
        assertEquals("ERROR", loginController.login(userForm));
    }

}
