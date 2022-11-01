package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class OrderPage {

    private final By orderHeader = By.xpath(".//div[@class='Order_Header__BZXOb'");
    private final By holderName = By.xpath(".//input[@placeholder='* Имя']");
    private final By holderSurename = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By holderAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By holderMetro = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By holderPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By holderNextPage = By.xpath(".//button[contains(@class,'Button_Button__ra12g Button_Middle__1CSJM')]");
    private final By holderWhere = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By holderTimeToHold = By.xpath(".//div[@class='Dropdown-control']");
    private final By holderTimeToHoldADay = By.xpath(".//div[@class='Dropdown-option' and text()='сутки']");
    private final By holderScootaColor = By.xpath(".//input[@id='black']");
    private final By holderCommentForCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By holderOrder = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    private final By orderModalHeaderFinish = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");
    private final By orderModalHeaderFinishYes = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM'][contains(.,'Да')]");

    public void fillOutTheForm(){
        Robot robot = null;/*from www . j  av a  2s  . co  m*/
        try {
            robot = new Robot();
        } catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String name = "Бубба";
        String surename = "Грязнопилов";
        String placeHolder = "ул. Мира";
        String phoneNum = "+79962437527";
        String timeToHold = "22.11.2022";
        String msgForCourier = "я передумал";

        driver.findElement(holderName).sendKeys(name);
        driver.findElement(holderSurename).sendKeys(surename);
        driver.findElement(holderAddress).sendKeys(placeHolder);
        driver.findElement(holderMetro).sendKeys(Keys.TAB, Keys.ARROW_DOWN, Keys.ENTER);
        driver.findElement(holderPhone).sendKeys(phoneNum);

        driver.findElement(holderNextPage).click();

        driver.findElement(holderWhere).sendKeys(timeToHold);
        driver.findElement(holderTimeToHold).click();
        driver.findElement(holderTimeToHoldADay).click();
        driver.findElement(holderScootaColor).click();
        driver.findElement(holderCommentForCourier).sendKeys(msgForCourier);
    }



    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderHeader() {
        return driver.findElements(orderHeader).size() > 0;
    }

}
