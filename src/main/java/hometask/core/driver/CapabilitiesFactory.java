package hometask.core.driver;


import hometask.core.driver.intefaces.ICapabilitiesFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;

@Component
public class CapabilitiesFactory implements ICapabilitiesFactory {


    @Override
    public Capabilities getCapabilities(final String browserName) {
        return Match(browserName).of(
                Case($("chrome"), this::getChromeCapabilities),
                Case($("firefox"), this::getFirefoxCapabilities));
    }


    private Capabilities getChromeCapabilities() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions chromeOptions = new ChromeOptions();
        capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability("enableVNC", true);
        chromeOptions.addArguments(Arrays.asList("--allow-running-insecure-content", "--ignore-certificate-errors",
                "--disable-popup-blocking", "--disable-dev-shm-usage", "--no-sandbox", "--disable-gpu"));
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        return capabilities;
    }

    private Capabilities getFirefoxCapabilities() {
        FirefoxProfile profile = new FirefoxProfile();
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
        return capabilities;
    }

}
