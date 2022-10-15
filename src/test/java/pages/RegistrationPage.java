package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegistrationPage {

    public RegistrationPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="//*[@id='account-menu']/a")
    public WebElement linkOnHomePage;

    @FindBy(xpath="//*[text()='Register']")
    public WebElement linkRegister;

    @FindBy(id="ssn")
    public WebElement SSN;

    @FindBy(id="firstName")
    public WebElement firstName;

    @FindBy(id="lastName")
    public WebElement lastName;

    @FindBy(id="username")
    public WebElement userName;

    @FindBy(id="email")
    public WebElement email;

    @FindBy(xpath="//input[@name='firstPassword']")
    public WebElement newPassword;

    @FindBy(xpath="//input[@name='secondPassword']")
    public WebElement newPasswordConfirmation;

    @FindBy(id="register-submit")
    public WebElement registerButton;

    @FindBy(xpath="//*[contains(text(), 'Registration Saved')]")
    public WebElement registrationSavedAlert;

    @FindBy(xpath="//*[@class='text-danger form-group']")
    public WebElement nonCompleteFieldsAlert;

    @FindBy(xpath="//div[.='Your SSN is invalid']")
    public WebElement invalidSsnAlert;

    @FindBy(xpath="//*[@class='is-touched is-dirty av-invalid is-invalid form-control']")
    public WebElement invalidEntryAlert;

    @FindBy(xpath="//*[@class='is-touched is-dirty av-valid form-control']")
    public WebElement validEntryCheck;

    @FindBy(xpath="//*[@class='is-touched is-pristine av-invalid is-invalid form-control']")
    public WebElement blankEntryError;





//    @FindBy(xpath="//div[.='Your FirstName is required.']")
//    public WebElement firstNameAlert;
//
//    @FindBy(xpath="//div[.='Your LastName is required.']")
//    public WebElement lastNameAlert;
//
//    @FindBy(xpath="//div[.='Your username is required.']")
//    public WebElement userNameAlert;
//
//    @FindBy(xpath="//div[.='Your email is required.']")
//    public WebElement emailAlert;
//
//    @FindBy(xpath="//div[.='Your password is required.']")
//    public WebElement passwordAlert1;
//    @FindBy(xpath="//div[.='Your password is required to be at least 4 characters.']")
//    public WebElement passwordAlert2;
//    @FindBy(xpath="//div[.='You confirmation password is required.']")
//    public WebElement passwordAlert3;
//    @FindBy(xpath="//div[.='The password and its confirmation do not match!']")
//    public WebElement passwordAlert4;


}
