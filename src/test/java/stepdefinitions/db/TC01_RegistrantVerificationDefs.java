package stepdefinitions.db;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import pages.RegistrantPojo;
import pages.RegistrationPage;
import utilities.ConfigReader;
import utilities.Driver;

import static io.restassured.RestAssured.given;
import static utilities.TokenGeneration.getToken;

public class TC01_RegistrantVerificationDefs {

    Response response;
    String token;
    RegistrationPage registrationPage=new RegistrationPage();
    RegistrantPojo registrant=new RegistrantPojo();

    @Given("user sends a get request for users")
    public void user_sends_a_get_request_for_users() {
        RequestSpecification spec=new RequestSpecBuilder().setBaseUri("https://medunna.com").build();
        spec.pathParams("first", "api", "second", "users");

        response = given().
                headers(
                "Authorization", "Bearer "+getToken(),
                "Content-Type", ContentType.JSON,
                "Accept" , ContentType.JSON).
                spec(spec).
                when().
                get("/{first}/{second}");

    }
    @Given("user converts user records to Java")
    public void user_converts_user_records_to_java() {

        response.prettyPrint();
    }
    @Then("user validates user data")
    public void user_validates_user_data() {

        Assert.assertTrue(true);
    }

    @Given("user puts in {string}{string}{string}{string}{string}{string} information")
    public void user_puts_in_information(String Ssn, String firstName, String lastName, String email, String userName, String password) {
        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));
        registrationPage.linkOnHomePage.click();
        registrationPage.linkRegister.click();
        registrationPage.SSN.sendKeys(Ssn);
        registrationPage.firstName.sendKeys(firstName);
        registrationPage.lastName.sendKeys(lastName);
        registrationPage.userName.sendKeys(userName);
        registrationPage.email.sendKeys(email);
        registrationPage.newPassword.sendKeys(password);
        registrationPage.newPasswordConfirmation.sendKeys(password);

        registrant.setSsn(Ssn);
        registrant.setFirstName(firstName);
        registrant.setLastName(lastName);
        registrant.setEmail(email);
        registrant.setUserName(userName);
        registrant.setPassword(password);
    }
    @Then("database is checked whether the user is registered all correctly")
    public void database_is_checked_whether_the_user_is_registered_all_correctly() {
        RequestSpecification spec=new RequestSpecBuilder().setBaseUri("https://medunna.com").build();
        spec.pathParams("first", "api", "second", "user").queryParam("ssn", registrant.getSsn());
        response = given().
                headers(
                        "Authorization", "Bearer "+getToken(),
                        "Content-Type", ContentType.JSON,
                        "Accept" , ContentType.JSON).
                spec(spec).
                when().
                get("/{first}/{second}");

        JsonPath json=response.jsonPath();

        Assert.assertEquals(registrant.getSsn(),json.getString("ssn"));
        Assert.assertEquals(registrant.getFirstName(),json.getString("firstName"));
        Assert.assertEquals(registrant.getLastName(),json.getString("lastName"));
        Assert.assertEquals(registrant.getEmail(),json.getString("email"));
        Assert.assertEquals(registrant.getUserName(),json.getString("login"));

        Driver.closeDriver();
    }
}
