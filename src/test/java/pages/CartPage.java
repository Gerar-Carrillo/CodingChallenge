package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage {
    WebDriverWait wait;

    By btnDeleteBy = By.xpath("//*[text()='Delete']");
    By btnPlaceOrderBy = By.xpath("//*[text()='Place Order']");

    public By getBtnPlaceOrderBy() {
        return btnPlaceOrderBy;
    }

    public void deleteItem(WebDriver driver){

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(btnDeleteBy));
        List<WebElement> elements = new ArrayList<>(driver.findElements(btnDeleteBy));
        elements.get(0).click();
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(btnDeleteBy,2));
    }

}
