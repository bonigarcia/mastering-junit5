
package io.github.bonigarcia;

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

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
        launcher.registerTestExecutionListeners(listener);

        launcher.execute(request, listener);
    }

}
