package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;
import pages.PlaceOrderPage;
import pages.ProductPage;
import utils.DriverInit;
import utils.TakeScreenShot;

public class test_2Steps extends DriverInit {
    HomePage home = new HomePage();
    ProductPage productPage = new ProductPage();

    @Then("I click on {string}")
    public void iClickOn(String category) throws InterruptedException {
        System.out.println("Selecting a category");
        home.selectCategory(driver,category);
        System.out.println("Category selected");
    }

    @Given("I select a product to buy")
    public void iSelectAProductToBuy() throws Exception {
        System.out.println("Selecting a product");
        home.selectProduct(driver);
        TakeScreenShot.takeSnapShot(driver,"Product selected.png");
        System.out.println("Product selected");
    }

    @When("I add it to the cart")
    public void iAddItToTheCart() {
        System.out.println("Adding a product to the cart");
        productPage.addProductToCart(driver);
        System.out.println("Product added");
    }

    @And("Add other product to the cart of {string}")
    public void addOtherProductToTheCartOf(String category) throws InterruptedException {
        productPage.goToHomePage(driver);
        System.out.println("adding other product of the category "+category);
        home.selectCategory(driver,category);
        home.selectProduct(driver);
        productPage.addProductToCart(driver);
        System.out.println("producto agregado");
    }


    @And("Remove an item from the cart")
    public void removeAnItemFromTheCart() throws Exception {
        System.out.println("Going to the cart");
        CartPage cartPage= new CartPage();
        productPage.goToCart(driver);
        TakeScreenShot.takeSnapShot(driver,"Cart page.png");
        System.out.println("on cart web page, starting to delete a producto");
        cartPage.deleteItem(driver);
        TakeScreenShot.takeSnapShot(driver,"Product deleted.png");
        System.out.println("Product deleted");

    }


    @Then("I place the order with a {string},{string},{string},{string},{string} and {string}")
    public void iPlaceTheOrderWithAAnd(String name, String country, String city, String creditCard, String month, String year) throws Exception {
        System.out.println("Filling up place order form");
        PlaceOrderPage placeOrderPage= new PlaceOrderPage();
        placeOrderPage.completeForm(driver,name,country,city,creditCard,month,year);
        TakeScreenShot.takeSnapShot(driver,"Place order form filled up.png");
        System.out.println("Filled up and requested");
    }


}
