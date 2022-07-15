package com.cydeo.library.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

    @CucumberOptions(
            plugin = {
                    "pretty" ,
                    "html:target/cucumber-report.html",  //html type of plugin, next where is it going to be displayed
                    "rerun:target/rerun.txt" ,
                    "me.jvt.cucumber.report.PrettyReports:target/cucumber"
            } ,
            features = "src/test/resources/features" ,      //get it from content root
            glue = "com/cydeo/library/step_definitions" ,   //get it from source root
            dryRun = true ,
            tags = "@SearchResults"
    )
public class CukesRunner {
}
