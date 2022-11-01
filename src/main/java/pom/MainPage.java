package pom;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage {

    private final String url = "https://qa-scooter.praktikum-services.ru/";

    //private final By orderStatusButton = By.xpath(".//button[@class='Header_Link__1TAG7']");
    private final By orderInput = By.xpath(".//input[contains(@class, 'Header_Input__xIoUq')]");
    private final By goButton = By.xpath(".//button[text()='Go!']");
    private final By importantQuestion = By.xpath(".//div[@class='Home_FourPart__1uthg']/div[@class='Home_SubHeader__zwi_E']");


    private final WebDriver driver;

    public String getUrl() {
        return url;
    }

//    public By getOrderStatusButton() {
//        return orderStatusButton;
//    }

    public By getOrderInput() {
        return orderInput;
    }

    public By getGoButton() {
        return goButton;
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open() {
        driver.get(url);
        return this;
    }

//    public MainPage clickOrderStatusButton() {
//        driver.findElement(orderStatusButton).click();
//        return this;
//    }

    public MainPage inputOrder(String text) {
        driver.findElement(orderInput).sendKeys(text);
        return this;
    }

    public MainPage clickGoButton() {
        driver.findElement(goButton).click();
        return this;
    }

    public OrderPage orderPage() {
        return new OrderPage(driver);
    }

    public void scrollToImportantQuestionHeader(){
        WebElement element = driver.findElement(importantQuestion);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
