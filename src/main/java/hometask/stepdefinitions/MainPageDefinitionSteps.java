package hometask.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import hometask.pageobject.MainPage;

public class MainPageDefinitionSteps {

    @Autowired
    private MainPage mainPage;

    @Given("Anonymous user opens Epam main page")
    public void userOpensMainPage() {
        mainPage.openPage();
    }

    @And("Anonymous user sees the Video slider on Main page")
    public void userOpensEpamMainPage() {
        mainPage.engineeringSliderShouldBePresentOnMainPage();
    }

    @And("Anonymous user sees the {} text on Video slider")
    public void userOpensMainPage(final String message) {
        mainPage.engineeringSliderShouldHaveText(message);
    }

    @And("Anonymous user opens Contact Us Page")
    public void userOpensContactUsPage() {
        mainPage.openContactUsPage();
    }

}
