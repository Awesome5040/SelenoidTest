package hometask.pageobject;

import hometask.core.driver.intefaces.IWebDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AbstractBasePage {

    @Value("${baseUrl}")
    private String baseUrl;

    @Autowired
    private IWebDriverService webDriverService;


    public void openPage() {
        webDriverService.initWebDriver();
        getWebDriver().get(baseUrl);
    }

}
