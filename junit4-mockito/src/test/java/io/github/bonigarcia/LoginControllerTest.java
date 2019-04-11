
package io.github.bonigarcia;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

    @InjectMocks
    private LoginController loginController;

    @Mock
    private LoginService loginService;

    private UserForm userForm = new UserForm("foo", "bar");

    @Test
    public void testLogin() {
        loginController.login(userForm);
        verify(loginService).login(userForm);
        verifyNoMoreInteractions(loginService);
    }

    @Test
    public void testLoginOk() {
        when(loginService.login(userForm)).thenReturn(true);
        assertEquals("OK", loginController.login(userForm));

        verify(loginService).login(userForm);
        verifyNoMoreInteractions(loginService);
    }

    @Test
    public void testLoginKo() {
        when(loginService.login(userForm)).thenReturn(false);
        assertEquals("KO", loginController.login(userForm));
    }

    @Test
    public void testLoginError() {
        assertEquals("ERROR", loginController.login(null));
    }

    @Test
    public void testLoginWithException() {
        when(loginService.login(userForm))
                .thenThrow(IllegalArgumentException.class);
        assertEquals("ERROR", loginController.login(userForm));
    }

    @Test
    public void testLogout() {
        loginController.logout(userForm);

        verify(loginService).logout(userForm);
        verifyNoMoreInteractions(loginService);
    }

}
