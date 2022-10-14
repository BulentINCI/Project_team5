package stepdefinitions.ui;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.RegistrationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class RegistrationStepDefs {

    RegistrationPage registrationPage=new RegistrationPage();
    @Given("user is on the registration page")
    public void user_is_on_the_registration_page() {
        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));
        registrationPage.linkOnHomePage.click();
        registrationPage.linkRegister.click();
    }
    @When("user puts in a ssn {string}")
    public void user_puts_in_his_her(String ssn) {
        registrationPage.SSN.sendKeys(ssn);
    }

    @When("user puts in a first name as {string}")
    public void user_puts_in_a_first_name_as(String firstName) {
        registrationPage.firstName.sendKeys(firstName);
    }
    @When("user puts in a last name as {string}")
    public void user_puts_in_a_last_name_as(String lastName) {
        registrationPage.lastName.sendKeys(lastName);
    }
    @When("user puts in a username as {string}")
    public void user_puts_in_a_username_as(String userName) {
        registrationPage.userName.sendKeys(userName);
    }
    @When("user puts in an email as {string}")
    public void user_puts_in_an_email_as(String email) {
       registrationPage.email.sendKeys(email);
    }
    @When("user puts in {string} and confirm the new password")
    public void user_puts_in_and_confirm_the_new_password(String password) {
     registrationPage.newPassword.sendKeys(password);
     registrationPage.newPasswordConfirmation.sendKeys(password);
    }
    @When("user registers the information")
    public void user_registers_the_information() {
        Driver.clickWithJS(registrationPage.registerButton);
    }
    @Then("registration is complete")
    public void registration_is_complete() throws IOException {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(registrationPage.registrationSavedAlert.isDisplayed());
        ReusableMethods.getScreenshot("registrationSaved");
    }

    @Then("registration is not completed successfully")
    public void registration_is_not_completed_successfully() throws IOException {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(registrationPage.nonCompleteFieldsAlert.isDisplayed());
        Driver.getDriver().navigate().refresh();
    }

}



//Get all registrant information using swagger and validate them
//Create registrants using api and validate
//Validate registrant SSN ids with DB