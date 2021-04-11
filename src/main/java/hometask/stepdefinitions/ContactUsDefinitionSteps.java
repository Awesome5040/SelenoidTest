package hometask.stepdefinitions;

import hometask.pageobject.ContactUsPage;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class ContactUsDefinitionSteps {

    @Autowired
    private ContactUsPage contactUsPage;

    @And("Anonymous user sees the JUST ASK US ANYTHING form on Contact Us Page")
    public void userSeesJustAskUsAnythingFormOnContactUsPage() throws Exception {
        throw new Exception("some exception");
    }

}
