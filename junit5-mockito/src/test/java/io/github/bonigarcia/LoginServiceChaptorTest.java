
package io.github.bonigarcia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LoginServiceChaptorTest {

    @InjectMocks
    LoginService loginService;

    @Mock
    LoginRepository loginRepository;

    @Captor
    ArgumentCaptor<UserForm> argCaptor;

    UserForm userForm = new UserForm("foo", "bar");

    @Test
    void testArgumentCaptor() {
        loginService.login(userForm);
        verify(loginRepository).login(argCaptor.capture());
        assertEquals(userForm, argCaptor.getValue());
    }

}
