package hometask.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class WaitingUtils {

    public static void waitForPageLoad() {
        new WebDriverWait(getWebDriver(), 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }
}
