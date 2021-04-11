package hometask.pageobject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

@Component
@Scope("prototype")
public class ContactUsPage {

    private static final String JUST_ASK_US_ANYTHING_FORM = "//div[@class='form-constructor start']";


    public void engineeringSliderShouldBePresentOnMainPage() {
        $x(JUST_ASK_US_ANYTHING_FORM).shouldBe(visible);
    }

}
