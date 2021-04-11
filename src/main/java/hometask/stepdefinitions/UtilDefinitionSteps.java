package hometask.stepdefinitions;

import hometask.core.configuration.AppConfig;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class UtilDefinitionSteps {

    @Autowired
    private AppConfig appConfig;

    @And("Configure {string} for scenario")
    public void configureBrowser(final String browserName) {
        appConfig.setBrowserName(browserName);
    }
}
