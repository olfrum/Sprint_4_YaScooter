package pom;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage {

    private final String url = "https://qa-scooter.praktikum-services.ru/";
    private final By importantQuestion = By.xpath(".//div[@class='Home_FourPart__1uthg']/div[@class='Home_SubHeader__zwi_E']");
    private final By firstOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");
    private final By secondOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    private final WebDriver driver;

    public String getUrl() {
        return url;
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open() {
        driver.get(url);
        return this;
    }

    public OrderPage orderPage() {
        return new OrderPage(driver);
    }

    public MainPage clickFirstOrderButton(){
        driver.findElement(firstOrderButton).click();
        return this;
    }

    public MainPage clickSecondOrderButton(){
        driver.findElement(secondOrderButton).click();
        return this;
    }

    public void scrollToImportantQuestionHeader(){
        WebElement element = driver.findElement(importantQuestion);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
