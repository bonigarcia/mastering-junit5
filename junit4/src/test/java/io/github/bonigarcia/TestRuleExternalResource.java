
package io.github.bonigarcia;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.junit.rules.TestName;

public class TestRuleExternalResource {

    private Resource resource;

    @Rule
    public TestName name = new TestName();

    @Rule
    public ExternalResource rule = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            resource = new Resource();
            resource.open();
            System.out.println(name.getMethodName());
        }

        @Override
        protected void after() {
            resource.close();
            System.out.println();
        }
    };

    @Test
    public void someTest() throws Exception {
        System.out.println(resource.get());
    }

    @Test
    public void someTest2() throws Exception {
        System.out.println(resource.get());
    }

}

class Resource {
    public void open() {
        System.out.println("Opened");
    }

    public void close() {
        System.out.println("Closed");
    }

    public double get() {
        return Math.random();
    }
}
