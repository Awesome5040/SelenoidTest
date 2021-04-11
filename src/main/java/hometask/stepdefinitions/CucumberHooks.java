package hometask.stepdefinitions;

import com.codeborne.selenide.Screenshots;
import hometask.core.configuration.AppConfig;
import hometask.core.driver.intefaces.IWebDriverService;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static io.qameta.allure.Allure.addAttachment;

@ContextConfiguration(classes = AppConfig.class)
public class CucumberHooks {

    @Autowired
    IWebDriverService webDriverService;

    @Before
    public void setScenarioInfoIntoLog() {
        System.out.println("");
    }

    @After(order = 1, value =  "@ui")
    public void closeDriver() {
        webDriverService.destroyWebDriver();
    }

    @After(order = 2)
    public void onTestFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                File screenshot = Screenshots.takeScreenShotAsFile();
                InputStream targetStream = new FileInputStream(screenshot);
                addAttachment("Screenshot on fail", "image/png", targetStream, "png");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
