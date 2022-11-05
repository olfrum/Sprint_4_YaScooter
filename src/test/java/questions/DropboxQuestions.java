package questions;

import main.BrowserRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import pom.MainPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DropboxQuestions {
    private final int nubmaImportantQandA;
    private final String importantAnwserTxt;

    private final static String answerHeadingHow = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private final static String answerHeadingMany = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private final static String answerHeadingCost = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private final static String answerHeadingToday = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private final static String answerHeadingEarly = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private final static String answerHeadingCharge = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private final static String answerHeadingCancel = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private final static String answerHeadingMordor = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    public DropboxQuestions(int nubmaImportantQandA, String importantAnwserTxt) {
        this.nubmaImportantQandA = nubmaImportantQandA;
        this.importantAnwserTxt = importantAnwserTxt;
    }

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Parameterized.Parameters
    public static Object[][] getDescription() {
        return new Object[][]{
                {0 ,answerHeadingHow},
                {1, answerHeadingMany},
                {2, answerHeadingCost},
                {3, answerHeadingToday},
                {4, answerHeadingEarly},
                {5, answerHeadingCharge},
                {6, answerHeadingCancel},
                {7, answerHeadingMordor},
        };
    }
    @Test
    public void answersOpenedAfterClick(){
        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage
                .open()
                .scrollToImportantQuestionHeader()
                .clickQuestion(nubmaImportantQandA);

        String answerElement = mainPage.getAnswerNum(nubmaImportantQandA);
        assertEquals(importantAnwserTxt, answerElement );
    }
}
