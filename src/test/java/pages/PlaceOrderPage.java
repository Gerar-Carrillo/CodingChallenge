package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TakeScreenShot;

import java.time.Duration;

public class PlaceOrderPage {
    CartPage cartPage = new CartPage();
    WebDriverWait wait;

    By txtNameBy = By.id("name");
    By txtCountryBy = By.id("country");
    By txtCityBy = By.id("city");
    By txtCreditCardBy = By.id("card");
    By txtMonthBy = By.id("month");
    By txtYearBy = By.id("year");
    By btnPurchaseBy = By.xpath("//*[text()='Purchase']");

    By lblOrderBy = By.xpath("//p[@class='lead text-muted ']");

    public void completeForm (WebDriver driver, String name, String country, String city,String creditCard, String month, String year){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(cartPage.getBtnPlaceOrderBy()));
        driver.findElement(cartPage.getBtnPlaceOrderBy()).click();
        wait.until(ExpectedConditions.elementToBeClickable(txtNameBy));
        driver.findElement(txtNameBy).sendKeys(name);
        driver.findElement(txtCountryBy).sendKeys(country);
        driver.findElement(txtCityBy).sendKeys(city);
        driver.findElement(txtCreditCardBy).sendKeys(creditCard);
        driver.findElement(txtMonthBy).sendKeys(month);
        driver.findElement(txtYearBy).sendKeys(year);

    }

    public void validateNameAndCreditCard(WebDriver driver, String creditCard, String name) throws Exception {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(btnPurchaseBy));
        driver.findElement(btnPurchaseBy).click();
        String[] OutPutOrder = driver.findElement(lblOrderBy).getText().split("\n");
        TakeScreenShot.takeSnapShot(driver,"Voucher geted.png");
        for (String attr:
             OutPutOrder) {
            if(attr.startsWith("Name:"))
            {
                Assert.assertTrue("Wrong name showed",attr.contentEquals("Name: "+name));
            }
            if(attr.startsWith("Card Number:"))
            {
                Assert.assertTrue("Wrong name showed",attr.contentEquals("Card Number: "+creditCard));
            }
            
        }
    }
}
