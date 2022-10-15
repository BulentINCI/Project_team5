package stepdefinitions.ui;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
    @When("user puts in a ssn {string} and moves to next field")
    public void user_puts_in_a_ssn_and_moves_to_next_field(String ssn) {
        registrationPage.SSN.sendKeys(ssn);
        registrationPage.SSN.sendKeys(Keys.TAB);
    }

    @When("user puts in a first name as {string}")
    public void user_puts_in_a_first_name_as(String firstName) {
        registrationPage.firstName.sendKeys(firstName);
        registrationPage.firstName.sendKeys(Keys.TAB);
    }
    @When("user puts in a last name as {string}")
    public void user_puts_in_a_last_name_as(String lastName) {
        registrationPage.lastName.sendKeys(lastName);
        registrationPage.lastName.sendKeys(Keys.TAB);
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

    @Then("user closes the browser")
    public void user_closes_the_browser() {
       Driver.getDriver().close();
    }

    @Then("user gets a warning of a blank field entry")
    public void user_gets_a_warning_of_a_blank_field_entry() {
        Assert.assertTrue(registrationPage.blankEntryError.isDisplayed());
    }


    @Then("input field does not give any errors")
    public void input_field_does_not_give_any_errors() {
        Assert.assertTrue(registrationPage.validEntryCheck.isDisplayed());
    }

    @Then("user gets a warning of an invalid field entry")
    public void user_gets_a_warning_of_an_invalid_field_entry() {
       Assert.assertTrue(registrationPage.invalidEntryAlert.isDisplayed());
    }


}



//Get all registrant information using swagger and validate them
//Create registrants using api and validate
//Validate registrant SSN ids with DB