package hometask.core.driver;

import hometask.core.configuration.AppConfig;
import hometask.core.driver.intefaces.ICapabilitiesFactory;
import hometask.core.driver.intefaces.IWebDriverProvider;
import hometask.core.exceptions.TAFRuntimeException;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.vavr.control.Try;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URL;

import static io.vavr.API.Case;
import static io.vavr.API.$;
import static io.vavr.API.Match;

@Component
public class WebDriverProvider implements IWebDriverProvider {

    @Value("${selenideUrl}")
    private String selenideUrl;

    @Value("${browser.type}")
    private String browserType;

    @Autowired
    private ICapabilitiesFactory iCapabilitiesFactory;

    @Autowired
    private AppConfig appConfig;

    @Override
    public WebDriver getWebDriver() {
        return Match(browserType).of(
        Case($("local"), this::getLocalDriverByBrowserName),
        Case($("remote"), () -> Try.of(
                        () -> new RemoteWebDriver(new URL(selenideUrl), iCapabilitiesFactory.getCapabilities(appConfig.getBrowserName())))
                        .getOrElseThrow(exception -> new TAFRuntimeException("Unable to create remote web driver", exception)))
        );
    }

    private WebDriver getLocalDriverByBrowserName() {
        String browser = appConfig.getBrowserName();
        return Match(browser).of(
                Case($("chrome"), () -> {
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver(new ChromeOptions().merge(iCapabilitiesFactory.getCapabilities(browser)));
                }),
                Case($("firefox"), () -> {
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver(new FirefoxOptions().merge(iCapabilitiesFactory.getCapabilities(browser)));
                })
        );
    }

}
