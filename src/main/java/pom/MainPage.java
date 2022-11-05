package pom;

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

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open() {
        driver.get(url);
        return this;
    }

    public void clickOrderButton (boolean numberOfButton) {
        if (numberOfButton) {
            driver.findElement(firstOrderButton).click();
        } else {
            WebElement element = driver.findElement(secondOrderButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            driver.findElement(secondOrderButton).click();
        }
    }

    public String getAnswerNum(int pathNum){
        By setAnswer = By.xpath(".//div[@id='accordion__panel-" + pathNum + "']/p");
        return driver.findElement(setAnswer).getText();
    }

    public  MainPage clickQuestion(int questionNum){
        By questionNumba = By.xpath(".//div[@id='accordion__heading-" + questionNum + "']");
        driver.findElement(questionNumba).click();
        return this;
    }

    public MainPage scrollToImportantQuestionHeader(){
        WebElement element = driver.findElement(importantQuestion);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }
}
