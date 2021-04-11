package hometask.pageobject;

import com.codeborne.selenide.Condition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import static com.codeborne.selenide.Condition.visible;

import static com.codeborne.selenide.Selenide.$x;
import static hometask.utils.WaitingUtils.waitForPageLoad;

@Scope("prototype")
@Component
public class MainPage extends AbstractBasePage {

    private static final String VIDEO_SLIDER = "//div[contains(@class,'background-video ')]";
    private static final String VIDEO_SLIDER_MESSAGE = VIDEO_SLIDER + "//span";
    private static final String CONTACT_US_BUTTON = "//a[contains(@class,'cta-button-ui')]";

    public void engineeringSliderShouldBePresentOnMainPage() {
        $x(VIDEO_SLIDER).shouldBe(visible);
    }

    public void engineeringSliderShouldHaveText(final String expectedMessage) {
        $x(VIDEO_SLIDER_MESSAGE).shouldHave(Condition.text(expectedMessage));
    }

    public void openContactUsPage(){
        $x(CONTACT_US_BUTTON).should(visible).click();
        waitForPageLoad();
    }

}
