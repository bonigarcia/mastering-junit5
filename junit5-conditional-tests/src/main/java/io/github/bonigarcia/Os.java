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

public enum Os {

    WINDOWS, MAC, LINUX, OTHER;

    public static Os determine() {
        // Default option: other OS
        Os out = OTHER;

        // Read my OS
        String myOs = System.getProperty("os.name").toLowerCase();
        if (myOs.indexOf("win") >= 0) {
            out = WINDOWS;
        } else if (myOs.indexOf("mac") >= 0) {
            out = MAC;
        } else if (myOs.indexOf("nux") >= 0) {
            out = LINUX;
        }
        return out;
    }

}
