<<<<<<< HEAD
package com.training.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.training.steps", "com.training.hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "rerun:target/rerun.txt"
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
=======
package com.training.runner; 
 
import io.cucumber.testng.AbstractTestNGCucumberTests; 
import io.cucumber.testng.CucumberOptions; 
 
@CucumberOptions( 
        features = "src/test/resources/features", 
        glue = "com.training.steps", 
        plugin = { 
                "pretty", 
                "html:target/cucumber-reports/cucumber.html", 
                "json:target/cucumber-reports/cucumber.json", 
                "junit:target/cucumber-reports/cucumber.xml" 
        }, 
        monochrome = true 
) 
public class TestRunner extends AbstractTestNGCucumberTests { 
} 
>>>>>>> f2a9d7b5c09bc9a16fda543acfc6a02aeb7fef03
