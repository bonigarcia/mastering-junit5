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