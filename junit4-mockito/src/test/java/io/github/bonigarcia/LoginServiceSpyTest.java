
package io.github.bonigarcia;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceSpyTest {

    @InjectMocks
    private LoginService loginService;

    @Spy
    private LoginRepository loginRepository;

    private UserForm userOk = new UserForm("user1", "p1");
    private UserForm userBad = new UserForm("foo", "bar");

    @Test
    public void testServiceLoginOk() {
        assertTrue(loginService.login(userOk));
    }

    @Test
    public void testServiceLoginBad() {
        assertFalse(loginService.login(userBad));
    }

}
