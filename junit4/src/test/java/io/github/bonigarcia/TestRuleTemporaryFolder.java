
package io.github.bonigarcia;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

public class TestRuleTemporaryFolder {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testUsingTempFolder() throws IOException {
        File file = folder.newFile("myfile.txt");
        System.out.println(file);
    }
}
