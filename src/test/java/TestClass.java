import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

@RunWith((Parameterized.class))
public class TestClass {

    private static By questionHeadingHow = By.id("accordion__heading-0");
    private static By questionHeadingMany = By.id("accordion__heading-1");
    private static By questionHeadingCost = By.id("accordion__heading-2");
    private static By questionHeadingToday = By.id("accordion__heading-3");
    private static By questionHeadingEarly = By.id("accordion__heading-4");
    private static By questionHeadingCharge = By.id("accordion__heading-5");
    private static By questionHeadingCancel = By.id("accordion__heading-6");
    private static By questionHeadingMordor = By.id("accordion__heading-7");

    private static String answerHeadingHow = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private static String answerHeadingMany = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private static String answerHeadingCost = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private static String answerHeadingToday = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private static String answerHeadingEarly = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private static String answerHeadingCharge = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private static String answerHeadingCancel = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private static String answerHeadingMordor = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    private final String nubmaImportantQuestion;
    private final String nubmaImportantAnwser;

    public TestClass(String nubmaImportantQuestion, String nubmaImportantAnwser) {
        this.nubmaImportantQuestion = nubmaImportantQuestion;
        this.nubmaImportantAnwser = nubmaImportantAnwser;
    }

    @Parameterized.Parameters
    public static Object[][] getDescription() {
        return new Object[][]{
                {questionHeadingHow, answerHeadingHow},
                {questionHeadingMany, answerHeadingMany},
                {questionHeadingCost, answerHeadingCost},
                {questionHeadingToday, answerHeadingToday},
                {questionHeadingEarly, answerHeadingEarly},
                {questionHeadingCharge, answerHeadingCharge},
                {questionHeadingCancel, answerHeadingCancel},
                {questionHeadingMordor, answerHeadingMordor},
        };
    }
}
