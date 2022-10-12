package TestRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions
        (
                features=".//Features/AddCustomer.feature",
              //  features="C:\\Users\\sunco\\IdeaProjects\\Cucumber\\Features",
                glue={"StepDefinitions"},
                dryRun = false,
                monochrome=true,
                //format={"pretty","json:target/"}
                //plugin={"pretty","html:target/HTMLReports"},//for simple html reports
                plugin={"pretty","json:target/JSONReports/report.json",
                "html:target/HTMLReports.html"} //for json reports
                //plugin={"pretty","junit:target/JuniTReports/report.xml"}//for xml reports
        )//Here keep alll the feature file
public class Runner {
}
