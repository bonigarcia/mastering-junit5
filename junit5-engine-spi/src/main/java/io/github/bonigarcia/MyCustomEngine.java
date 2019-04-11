
package io.github.bonigarcia;

import org.junit.platform.engine.EngineDiscoveryRequest;
import org.junit.platform.engine.ExecutionRequest;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.TestEngine;
import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.support.descriptor.EngineDescriptor;

public class MyCustomEngine implements TestEngine {

    public static final String ENGINE_ID = "my-custom-engine";

    @Override
    public String getId() {
        return ENGINE_ID;
    }

    @Override
    public TestDescriptor discover(EngineDiscoveryRequest discoveryRequest,
            UniqueId uniqueId) {
        // Discover test(s) and return a TestDescriptor object
        TestDescriptor testDescriptor = new EngineDescriptor(uniqueId,
                "My test");
        return testDescriptor;
    }

    @Override
    public void execute(ExecutionRequest request) {
        // Use ExecutionRequest to execute TestDescriptor
        TestDescriptor rootTestDescriptor = request.getRootTestDescriptor();
        request.getEngineExecutionListener()
                .executionStarted(rootTestDescriptor);
    }

}
