package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage = new LoginPage(DriverFactory.getPage());

    @Given("^user navigates to \"([^\"]*)\"$")
    public void navigateToUrl(String url) {loginPage.navigateToUrl(url);}

    @When("^user enters \"([^\"]*)\" username$")
    public void enterUsername(String username) {
        loginPage.enterUsername(username);
    }

    @When("^user enters \"([^\"]*)\" password$")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("^user clicks Login button$")
    public void clickLogin() {
        loginPage.clickLogin();
    }

    @When("^user clicks Continue button$")
    public void clickContinue() {
        loginPage.clickContinueButton();
    }

    @When("^user clicks Hudl option$")
    public void clickHudl() {
        loginPage.clickHudl();
    }

    @When("^user clicks on Hudl icon in main page")
    public void clickOnIcon() {loginPage.clickOnIcon();}

    @Then("verify that user is navigated to main page for log in")
    public void verifyMainPage() {
        Assert.assertTrue(loginPage.verifyMainPage());
    }

    @Then("verify that user is logged in and navigated to user Profile page")
    public void verifyUserProfilePage() {
        Assert.assertTrue(loginPage.verifyUserProfilePage());
    }

    @When("^user clicks Logout button$")
    public void clickLoginout() {loginPage.clickLoginOut();}

    @Then("verify the error text for invalid credentials")
    public void verifyErrorTextForInvalidCredentials() {
        Assert.assertEquals("Error message text does not match.",
            loginPage.verifyErrorMessage(), "We don't recognize that email and/or password");
    }

    @Then("verify the blank error text for credentials")
    public void verifyBlankErrorTextForEmailOrPassword() {
        Assert.assertEquals("Error message text does not match.",
            loginPage.verifyBlankErrorMessage(), "Please fill in all of the required fields");
    }
}
