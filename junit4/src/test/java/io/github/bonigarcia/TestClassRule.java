
package io.github.bonigarcia;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

public class TestClassRule {

    private static Resource resource;

    @ClassRule
    public static ExternalResource rule = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            resource = new Resource();
            resource.open();
        }

        @Override
        protected void after() {
            resource.close();
            System.out.println();
        }
    };

    @BeforeClass
    public static void before() {
        System.out.println("before class");
    }

    @Test
    public void someTest() throws Exception {
        System.out.println(resource.get());
    }

    @Test
    public void someTest2() throws Exception {
        System.out.println(resource.get());
    }

}
