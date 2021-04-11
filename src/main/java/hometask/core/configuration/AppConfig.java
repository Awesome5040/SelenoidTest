package hometask.core.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:properties/common.properties")
@PropertySource("classpath:properties/env/${spring.profiles.active}.properties")
@ComponentScan(basePackages = {"hometask"})
@ConfigurationPropertiesScan(basePackages = "hometask")

@EnableAutoConfiguration
public class AppConfig {

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }


    public String getBrowserName() {
        return browserName;
    }

    private String browserName;
}
