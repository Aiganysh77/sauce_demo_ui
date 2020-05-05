package step_definitions.sauce_demo_steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {
    @Before
    public void setUp(Scenario scenario) {


    }

    @After
    public void tearDown(Scenario scenario) {

        if(scenario.isFailed() && Driver.getReference() != null) {
            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");

        }

        Driver.quitDriver();
    }


}
