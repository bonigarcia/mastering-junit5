/*
 * (C) Copyright 2020 Boni Garcia (http://bonigarcia.github.io/)
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

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.Closeable;
import java.util.UUID;
import java.util.stream.IntStream;

import org.slf4j.Logger;

public class MySUT implements Closeable {

    static final Logger log = getLogger(lookup().lookupClass());

    String name;
    String id;

    public MySUT(String name) {
        this.name = name;
        log.info("{} created", name);
    }

    public void initId() {
        id = UUID.randomUUID().toString();
        log.info("Id created: {}", id);
    }

    public void releaseId() {
        log.info("Id released: {}", id);
        id = null;
    }

    public int sum(int... numbers) {
        return IntStream.of(numbers).sum();
    }

    public String concatenate(String... words) {
        return String.join(" ", words);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void close() {
        log.info("{} closed", name);
    }

}
