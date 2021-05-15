package hometask.stepdefinitions;

import com.codeborne.selenide.Screenshots;
import com.epam.reportportal.message.ReportPortalMessage;
import com.epam.reportportal.service.ReportPortal;
import hometask.core.configuration.AppConfig;
import hometask.core.driver.intefaces.IWebDriverService;
import hometask.core.exceptions.TAFRuntimeException;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Optional;

import static io.qameta.allure.Allure.addAttachment;


@ContextConfiguration(classes = AppConfig.class)
public class CucumberHooks {

    private static final Logger LOG = LogManager.getLogger();


    @Autowired
    private IWebDriverService webDriverService;

    @Before
    public void setScenarioInfoIntoLog(final Scenario scenario) {
        LOG.info(scenario.getName(),"{} was started");
     }

    @After(order = 1, value =  "@ui")
    public void closeDriver() {
        webDriverService.destroyWebDriver();
    }

    @After(order = 2, value =  "@ui")
    public void onTestFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                File screenshot = Optional.ofNullable(Screenshots.takeScreenShotAsFile())
                        .orElseThrow(() -> new TAFRuntimeException("Error while taking a screenshot"));
                InputStream targetStream = new FileInputStream(screenshot);
                addAttachment("Screenshot on fail", "image/png", targetStream, "png");
                ReportPortal.emitLog(new ReportPortalMessage(screenshot, "error"), "error", new Date(screenshot.lastModified()));
            } catch (IOException e) {
                LOG.error(e);
            }
        }
    }

}
