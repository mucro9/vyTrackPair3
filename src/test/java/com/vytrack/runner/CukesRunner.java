package com.vytrack.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//Run with Cucumber Class
@CucumberOptions(//Cucumber Options
        features = "src/test/resources/features",//feature files path
        glue = "com/vytrack/step_definitions",//step definitions path
        dryRun = false,//pre-inspection, generating snippets without running
        tags = "@wip",//Include and Exclude testing suites
        plugin = {"html:target/cucumber-report.html",//report type
                "rerun:target/rerun.txt",//adding failed test to the text file
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"//pretty report
        }

)
public class CukesRunner {

}
