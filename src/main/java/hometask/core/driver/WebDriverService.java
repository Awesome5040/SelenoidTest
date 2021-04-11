package hometask.core.driver;

import com.codeborne.selenide.WebDriverRunner;
import hometask.core.driver.intefaces.IWebDriverProvider;
import hometask.core.driver.intefaces.IWebDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WebDriverService implements IWebDriverService {

    private boolean isFirstInitialize = true;

    @Autowired
    private IWebDriverProvider webDriverProvider;

    @Override
    public void initWebDriver() {
        if (isFirstInitialize) {
            WebDriverRunner.setWebDriver(webDriverProvider.getWebDriver());
            WebDriverRunner.getWebDriver().manage().deleteAllCookies();
            WebDriverRunner.clearBrowserCache();
            WebDriverRunner.getWebDriver().manage().window().maximize();
            isFirstInitialize = false;
        }
    }

    @Override
    public void destroyWebDriver() {
        WebDriverRunner.closeWebDriver();
        isFirstInitialize = true;
    }
}
