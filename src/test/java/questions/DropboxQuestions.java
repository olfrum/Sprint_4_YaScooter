package questions;

import main.BrowserRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pom.MainPage;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DropboxQuestions {
    private final static By questionHeadingHow = By.xpath(".//div[@id='accordion__heading-0']");
    private final static By questionHeadingMany = By.xpath(".//div[@id='accordion__heading-1']");
    private final static By questionHeadingCost = By.xpath(".//div[@id='accordion__heading-2']");
    private final static By questionHeadingToday = By.xpath(".//div[@id='accordion__heading-3']");
    private final static By questionHeadingEarly = By.xpath(".//div[@id='accordion__heading-4']");
    private final static By questionHeadingCharge = By.xpath(".//div[@id='accordion__heading-5']");
    private final static By questionHeadingCancel = By.xpath(".//div[@id='accordion__heading-6']");
    private final static By questionHeadingMordor = By.xpath(".//div[@id='accordion__heading-7']");

    private final static By pathHeadingNow = By.xpath(".//div[@id='accordion__panel-0']/p");
    private final static By pathHeadingMany = By.xpath(".//div[@id='accordion__panel-1']/p");
    private final static By pathHeadingCost= By.xpath(".//div[@id='accordion__panel-2']/p");
    private final static By pathHeadingToday = By.xpath(".//div[@id='accordion__panel-3']/p");
    private final static By pathHeadingEarly = By.xpath(".//div[@id='accordion__panel-4']/p");
    private final static By pathHeadingCharge = By.xpath(".//div[@id='accordion__panel-5']/p");
    private final static By pathHeadingCancel = By.xpath(".//div[@id='accordion__panel-6']/p");
    private final static By pathHeadingMordor = By.xpath(".//div[@id='accordion__panel-7']/p");


    private final static String answerHeadingHow = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private final static String answerHeadingMany = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private final static String answerHeadingCost = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private final static String answerHeadingToday = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private final static String answerHeadingEarly = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private final static String answerHeadingCharge = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private final static String answerHeadingCancel = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private final static String answerHeadingMordor = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    private final By nubmaImportantQuestion;
    private final By nubmaImportantAnwser;
    private final String importantAnwserTxt;

    public DropboxQuestions(By nubmaImportantQuestion, By nubmaImportantAnwser, String importantAnwserTxt) {
        this.nubmaImportantQuestion = nubmaImportantQuestion;
        this.nubmaImportantAnwser = nubmaImportantAnwser;
        this.importantAnwserTxt = importantAnwserTxt;
    }

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Parameterized.Parameters
    public static Object[][] getDescription() {
        return new Object[][]{
                {questionHeadingHow, pathHeadingNow,answerHeadingHow},
                {questionHeadingMany, pathHeadingMany, answerHeadingMany},
                {questionHeadingCost, pathHeadingCost, answerHeadingCost},
                {questionHeadingToday, pathHeadingToday, answerHeadingToday},
                {questionHeadingEarly, pathHeadingEarly, answerHeadingEarly},
                {questionHeadingCharge, pathHeadingCharge, answerHeadingCharge},
                {questionHeadingCancel, pathHeadingCancel, answerHeadingCancel},
                {questionHeadingMordor, pathHeadingMordor, answerHeadingMordor},
        };
    }
    @Test
    public void answersOpenedAfterClick(){
        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage
                .open()
                .scrollToImportantQuestionHeader();

        browserRule.getDriver().findElement(nubmaImportantQuestion).click();
        String answerElement = browserRule.getDriver().findElement(nubmaImportantAnwser).getText();
        assertEquals(importantAnwserTxt, answerElement );
    }

}
