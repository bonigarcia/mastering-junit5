
package io.github.bonigarcia;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

    @InjectMocks
    private LoginService loginService;

    @Mock
    private LoginRepository loginRepository;

    private UserForm userForm = new UserForm("foo", "bar");

    @Test
    public void testServiceLoginOk() {
        when(loginRepository.login(any(UserForm.class))).thenReturn(true);
        assertTrue(loginService.login(userForm));

        verify(loginRepository, atLeast(1)).login(userForm);
        verifyNoMoreInteractions(loginRepository);
    }

    @Test
    public void testServiceLoginBad() {
        when(loginRepository.login(any(UserForm.class))).thenReturn(false);
        assertFalse(loginService.login(userForm));

        verify(loginRepository, times(1)).login(userForm);
        verifyNoMoreInteractions(loginRepository);
    }

    @Test(expected = LoginException.class)
    public void testServiceLoginTwice() {
        when(loginRepository.login(userForm)).thenReturn(true);
        loginService.login(userForm);
        loginService.login(userForm);
    }

}
