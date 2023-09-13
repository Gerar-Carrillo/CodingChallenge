package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.HomePage;
import utils.DriverInit;

public class test_4Steps extends DriverInit {
    HomePage homePage = new HomePage();
    @And("I click on all categories")
    public void iClickOnAllCategories() throws Exception {
        System.out.println("Clicking on all categories");
        homePage.clickOnAllCategories(driver);
        System.out.println("All categories clicked");
    }

    @Then("The system will have all categories")
    public void theSystemWillHaveAllCategories() {
        System.out.println("Validating categories");
        homePage.validateAllCategories(driver);
        System.out.println("Categories validated");
    }
}
