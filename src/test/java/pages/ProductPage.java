package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriverWait wait;
    By btnHomePageBy = By.id("nava");
    By btnAddtoCartBy = By.xpath("//*[@class='btn btn-success btn-lg']");
    By btnGoToCartBy = By.id("cartur");

    public void addProductToCart(WebDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(btnAddtoCartBy));
        driver.findElement(btnAddtoCartBy).click();
        wait.until(ExpectedConditions.alertIsPresent());
        String msg = driver.switchTo().alert().getText();
        Assert.assertTrue("Producto no se agrego correctamente",msg.contentEquals("Product added."));
        driver.switchTo().alert().accept();
    }
    public void goToHomePage (WebDriver driver){
        driver.findElement(btnHomePageBy).click();
    }

    public void goToCart(WebDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(btnGoToCartBy));
        driver.findElement(btnGoToCartBy).click();
    }
}
