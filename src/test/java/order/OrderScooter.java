package order;

import main.BrowserRule;
import org.junit.Rule;
import org.junit.Test;
import pom.MainPage;
import pom.OrderPage;

public class OrderScooter {
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void tryToOrderFirstButton(){
        OrderPage orderPage = new OrderPage(browserRule.getDriver());
        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage
                .open()
                .clickFirstOrderButton();
        orderPage
                .fillOutTheForm();

    }
}
