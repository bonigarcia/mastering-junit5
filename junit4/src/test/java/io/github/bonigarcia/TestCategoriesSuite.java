
package io.github.bonigarcia;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(FunctionalTests.class)
@SuiteClasses({ TestCategories.class })
public class TestCategoriesSuite {

    // This suite will run TestCategories.test1 but not TestCategories.test2
}
