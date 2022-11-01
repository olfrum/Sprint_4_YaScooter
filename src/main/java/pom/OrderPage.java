package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    private final By orderHeader = By.xpath(".//div[@class='Order_Header__BZXOb' and text()='Для кого самокат']");
    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderHeader() {
        return driver.findElements(orderHeader).size() > 0;
    }

}
