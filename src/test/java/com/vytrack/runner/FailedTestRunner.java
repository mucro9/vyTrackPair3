package com.vytrack.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/vytrack/step_definitions",//step definitions path,
        features = "@target/rerun.txt" //path of failed test cases, will only run failed ones
)
public class FailedTestRunner {

}
