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

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestParameterizedConstructor {

    public int input1;
    public int input2;
    public int sum;

    public TestParameterizedConstructor(int input1, int input2, int sum) {
        this.input1 = input1;
        this.input2 = input2;
        this.sum = sum;
    }

    @Parameters(name = "{index}: input1={0} input2={1} sum={2}?")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][] { { 1, 1, 2 }, { 2, 2, 4 }, { 3, 3, 6 } });
    }

    @Test
    public void testSum() {
        assertTrue(input1 + "+" + input2 + " is not " + sum,
                input1 + input2 == sum);
    }

}
