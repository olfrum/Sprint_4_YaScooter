package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.startsWith;

public class OrderPage {

    private final By holderName = By.xpath(".//input[@placeholder='* Имя']");
    private final By holderSurename = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By holderAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By holderMetro = By.xpath(".//input[@class='select-search__input']");
    private final By holderPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By holderNextPage = By.xpath(".//button[contains(@class,'Button_Button__ra12g Button_Middle__1CSJM')]");
    private final By holderWhere = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By holderTimeToHold = By.xpath(".//div[@class='Dropdown-control']");
    private final By holderCommentForCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By holderOrder = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    private final By orderModalHeaderFinishYes = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM'][contains(.,'Да')]");
    private final By orderIsAccepted = By.xpath(".//div[contains(text(),'Заказ оформлен')]");

    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderPage inputName(String name) {
        driver.findElement(holderName).sendKeys(name);
        return this;
    }

    public OrderPage inputSurename(String surename) {
        driver.findElement(holderSurename).sendKeys();
        return this;
    }

    public OrderPage inputAddress(String address) {
        driver.findElement(holderAddress).sendKeys();
        return this;
    }

    public OrderPage inputMetro(String metro) {
        driver.findElement(holderMetro).click();
        driver.findElement(holderMetro).sendKeys(metro);
        driver.findElement(holderMetro).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        return this;
    }

    public OrderPage inputPhoneNumber(String phone) {
        driver.findElement(holderPhone).sendKeys(phone);
        return this;
    }

    public OrderPage clickNext() {
        driver.findElement(holderNextPage).click();
        return this;
    }

    public OrderPage inputWhereDate(String date) {
        driver.findElement(holderWhere).click();
        driver.findElement(holderWhere).sendKeys(date, Keys.ENTER);
        return this;
    }

    public OrderPage inputTimeToHold(String period) {
        driver.findElement(holderTimeToHold).click();
        driver.findElement(By.xpath(".//div[@class='Dropdown-menu']/div[text()='" + period + "']")).click();
        return this;
    }

    public OrderPage inputScootaColor(String color) {
        driver.findElement(By.id(color)).click();
        return this;
    }

    public OrderPage inputComment(String comment) {
        driver.findElement(holderCommentForCourier).sendKeys(comment);
        return this;
    }

    public OrderPage clickFinalOrderHeaderButton() {
        driver.findElement(holderOrder).click();
        return this;
    }

    public OrderPage clickOrderHeaderYesButton() {
        driver.findElement(orderModalHeaderFinishYes).click();
        return this;
    }

    public OrderPage checkOrderIsAccepted() {
        String textOfAccepted = driver.findElement(orderIsAccepted).getText();
        Assert.assertThat("Ошибка в оформлении заказа", textOfAccepted, startsWith("Заказ оформлен"));
        return this;
    }
}
