package steps;

import io.cucumber.java.en.And;
import pages.PlaceOrderPage;
import utils.DriverInit;

public class test_3Steps extends DriverInit {
    PlaceOrderPage placeOrderPage= new PlaceOrderPage();
    @And("The system show the {string} and {string}")
    public void theSystemShowTheAnd(String creditCard, String name) throws Exception {
        System.out.println("Validating the name and credit card showed");
    placeOrderPage.validateNameAndCreditCard(driver,creditCard,name);

    }
}
