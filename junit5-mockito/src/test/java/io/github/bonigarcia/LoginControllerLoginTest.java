
package io.github.bonigarcia;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoginControllerLoginTest {

    // Mocking objects
    @InjectMocks
    LoginController loginController;

    @Mock
    LoginService loginService;

    // Test data
    private UserForm userForm = new UserForm("foo", "bar");

    @Test
    void testLoginOk() {
        // Setting expectations (stubbing methods)
        when(loginService.login(userForm)).thenReturn(true);

        // Exercise SUT
        String reseponseLogin = loginController.login(userForm);

        // Verification
        assertEquals("OK", reseponseLogin);
        verify(loginService).login(userForm);
        verifyNoMoreInteractions(loginService);
    }

    @Test
    void testLoginKo() {
        // Setting expectations (stubbing methods)
        when(loginService.login(userForm)).thenReturn(false);

        // Exercise SUT
        String reseponseLogin = loginController.login(userForm);

        // Verification
        assertEquals("KO", reseponseLogin);
        verify(loginService).login(userForm);
        verifyZeroInteractions(loginService);
    }

}
