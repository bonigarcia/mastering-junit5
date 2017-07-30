/*
 * (C) Copyright 2017 Boni Garcia (http://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package io.github.bonigarcia;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
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

    @Before
    public void setUp() {
        initMocks(this);
    }

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
        verify(loginService).logout(userForm);

        loginController.logout(userForm);

        verify(loginService).logout(userForm);
        verifyNoMoreInteractions(loginService);
    }

}