/*
 * (C) Copyright 2017 Boni Garcia (https://bonigarcia.github.io/)
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

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

import java.util.List;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.junit.platform.launcher.listeners.TestExecutionSummary.Failure;

public class LauncherApiExample {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // Discover and filter tests
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
                .request()
                .selectors(selectPackage("io.github.bonigarcia"),
                        selectClass(DummyTest.class))
                .filters(includeClassNamePatterns(".*Test")).build();

        Launcher launcher = LauncherFactory.create();
        TestPlan plan = launcher.discover(request);

        // Executing tests
        TestExecutionListener listener = new SummaryGeneratingListener();
        launcher.execute(request, listener);

        // Results
        TestExecutionSummary summary = ((SummaryGeneratingListener) listener)
                .getSummary();

        List<Failure> failures = summary.getFailures();
        System.out.println("--> Failures test(s): " + failures.size());
        for (Failure failure : failures) {
            System.out.println("\t" + failure.getTestIdentifier());
        }

        System.out.println(
                "--> Success test(s): " + summary.getTestsSucceededCount());

        System.out.println(
                "--> Skipped test(s): " + summary.getTestsSkippedCount());

    }

}
