package hometask.core.driver.intefaces;

import org.openqa.selenium.Capabilities;

public interface ICapabilitiesFactory {

    Capabilities getCapabilities(final String browserName);
}
