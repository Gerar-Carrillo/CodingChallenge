package steps;

import utils.DriverInit;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends DriverInit{


    @Before
    public void hook()
    {
        System.out.println("Automation Started");

    }

    @After
    public void after()
    {
        driver.quit();
    }
}
