package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import utils.DriverInit;
import utils.TakeScreenShot;

import java.time.Duration;

public class test_1Steps extends DriverInit {
    HomePage homePage= new HomePage();
    TakeScreenShot takeScreenShot = new TakeScreenShot();
    WebDriverWait wait;
    @Given("I go to the {string}")
    public void iGoToThe(String webPage) throws Exception {

        driver = new FirefoxDriver();
        driver.get(webPage);
        TakeScreenShot.takeSnapShot(driver,"Page Loaded.png");
        System.out.println("Web page loaded");
    }

    @When("I click on sig up button")
    public void iClickOnSigUpButton() throws Exception {
        System.out.println("clicling on sign up button");
        homePage.clicOnSignUp(driver);
        TakeScreenShot.takeSnapShot(driver,"Sig Up Modal.png");
        System.out.printf("Clicked");

    }

    @And("I register my {string} and {string}")
    public void iRegisterMyAnd(String user, String password) throws Exception {
        System.out.println("Filling up registration form");
        homePage.registerUserAndPass(driver,user,password);
        System.out.println("User created");
    }

    @Then("I login with my {string} and {string}")
    public void iLoginWithMyAnd(String user, String password) throws Exception {
        System.out.println("loging with my credentials");
        TakeScreenShot.takeSnapShot(driver,"Login Modal.png");
        homePage.logIn(driver,user,password);
        TakeScreenShot.takeSnapShot(driver,"User loged in.png");
        Assert.assertEquals("User doesn't name the same","Welcome "+user,driver.findElement(homePage.userNameBy()).getText());
        System.out.printf("User loged");
    }


    @And("I log out")
    public void iLogOut() throws Exception {
        System.out.println("loging out");
        homePage.logOut(driver);
        TakeScreenShot.takeSnapShot(driver,"User loged out.png");
        System.out.println("loged out");
    }


    @When("I click on Login button")
    public void iClickOnLoginButton() throws Exception {
        System.out.println("clicking on login button");
        homePage.clicOnLogIn(driver);
        TakeScreenShot.takeSnapShot(driver,"Log in modal charged.png");
        System.out.println("clicked");
    }

    @And("Try to connect with a wrong {string} and {string}")
    public void tryToConnectWithAWrongAnd(String user, String pass) throws Exception {
        System.out.println("Conecting with my credentials");
        homePage.logIn(driver,user,pass);
        System.out.println("user can't connect");
        TakeScreenShot.takeSnapShot(driver,"User can't log in.png");
    }

    @Then("The system shows an alert")
    public void theSystemShowsAnAlert() throws Exception {
        System.out.println("Validating the alert raised");
        homePage.getAlertText(driver);

        System.out.println("Alert validated");
    }


}
