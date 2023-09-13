package pages;
import io.cucumber.java.an.E;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.EncriptionHelper;
import utils.TakeScreenShot;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomePage {
    WebDriverWait wait;
    EncriptionHelper encriptionHelper= new EncriptionHelper();

    By sigUpBy = By.id("signin2");
    By txtRegisteruserBy= By.id("sign-username");
    By txtRegisterPasswordBy= By.id("sign-password");
    By btnSignUpBy = By.xpath("//*[@class='btn btn-primary' and text()='Sign up']");
    By btnCloseSignUpBy= By.xpath("//div[@id='signInModal']//parent::*[@class='btn btn-secondary' and text()='Close']");
    By logInBy = By.id("login2");
    By txtLoginUserBy=By.id("loginusername");
    By txtLoginPasswordBy=By.id("loginpassword");
    By btnLogInBy = By.xpath("//*[@class='btn btn-primary' and text()='Log in']");
    By lblUserNameBy = By.id("nameofuser");
    By btnLogOutBy = By.id("logout2");

    By lblproductsBy = By.xpath("//*[@class='card-img-top img-fluid']");

    public By userNameBy (){
        return lblUserNameBy;
    }

    public void clicOnSignUp(WebDriver driver)
    {

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(sigUpBy));
        driver.findElement(sigUpBy).click();
    }
    public void clicOnLogIn(WebDriver driver) {wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(logInBy));
        driver.findElement(logInBy).click();}
    public void registerUserAndPass(WebDriver driver, String user, String pass) throws Exception {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(txtRegisteruserBy));
        driver.findElement(txtRegisteruserBy).sendKeys(user);
        driver.findElement(txtRegisterPasswordBy).sendKeys(encriptionHelper.decrypt(pass));
        TakeScreenShot.takeSnapShot(driver,"Register Form filed up.png");
        driver.findElement(btnSignUpBy).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        driver.findElement(btnCloseSignUpBy).click();
    }
    public void logIn (WebDriver driver, String user, String pass) throws Exception {

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(txtLoginUserBy));
        driver.findElement(txtLoginUserBy).sendKeys(user);
        driver.findElement(txtLoginPasswordBy).sendKeys(encriptionHelper.decrypt(pass));
        TakeScreenShot.takeSnapShot(driver,"Log in form filled up.png");
        driver.findElement(btnLogInBy).click();
        wait.until(ExpectedConditions.elementToBeClickable(lblUserNameBy));
    }
    public void logInWrong (WebDriver driver, String user, String pass) throws Exception {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(txtLoginUserBy));
        driver.findElement(txtLoginUserBy).sendKeys(user);
        driver.findElement(txtLoginPasswordBy).sendKeys(encriptionHelper.decrypt(pass));
        TakeScreenShot.takeSnapShot(driver,"Log in form filled up.png");
        driver.findElement(btnLogInBy).click();
    }
    public void logOut (WebDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(btnLogOutBy));
        driver.findElement(btnLogOutBy).click();
    }

    public void getAlertText(WebDriver driver) throws Exception {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue("usuario si existe",driver.switchTo().alert().getText().contentEquals("User does not exist."));
        TakeScreenShot.takeSnapShot(driver,"Alert geted.png");
        driver.switchTo().alert().dismiss();
    }
    public void selectCategory(WebDriver driver, String category) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By lblCategoryBy = By.xpath("//div[@class='list-group']//descendant::a[contains(text(),'"+category+"')]");
        wait.until(ExpectedConditions.textToBe(lblCategoryBy,category));
        driver.findElement(lblCategoryBy).click();
    }
    public void  selectProduct (WebDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(lblproductsBy));
        List<WebElement> elements = new ArrayList<>(driver.findElements(lblproductsBy));
        elements.get(1).click();
    }

    public void clickOnAllCategories(WebDriver driver) throws Exception {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By lblCategoryBy = By.xpath("//div[@class='list-group']//descendant::a[@id='itemc']");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(lblCategoryBy));
        List<WebElement> categories = new ArrayList<>(driver.findElements(lblCategoryBy));
        for (WebElement element:
             categories) {
            element.click();
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(lblCategoryBy,1));
            TakeScreenShot.takeSnapShot(driver,"Categorie "+element.getText()+" loaded.png");
        }
    }

    public void validateAllCategories(WebDriver driver)
    {   List<String> expectingCategories= new ArrayList<>();
        List<String> getedCategories= new ArrayList<>();
        expectingCategories.add("Phones");
        expectingCategories.add("Laptops");
        expectingCategories.add("Monitors");
        By lblCategoryBy = By.xpath("//div[@class='list-group']//descendant::a");
        List<WebElement> categories = new ArrayList<>(driver.findElements(lblCategoryBy));
        for (WebElement element:
             categories) {
            getedCategories.add(element.getText());
        }
        for (String s:
             expectingCategories) {
            Assert.assertTrue("The system dont show all categories",getedCategories.contains(s));
            
        }
    }

}

