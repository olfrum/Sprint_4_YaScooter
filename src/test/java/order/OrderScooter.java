package order;

import main.BrowserRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pom.MainPage;
import pom.OrderPage;

@RunWith(Parameterized.class)
public class OrderScooter {

    private final boolean orderButton;
    private final String name;
    private final String surname;
    private final String metro;
    private final String address;
    private final String phone;
    private final String date;
    private final String period;
    private final String colour;
    private final String text;

    public OrderScooter(boolean orderButton, String name, String surname, String metro, String address, String phone, String date, String period, String colour, String text){
        this.orderButton = orderButton;
        this.name = name;
        this.surname = surname;
        this.metro = metro;
        this.address = address;
        this.phone = phone;
        this.date = date;
        this.period = period;
        this.colour = colour;
        this.text = text;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData(){
        return new Object[][]{
                {true, "Бубба", "Грязнопилов", "Спартак", "Москва", "89135325396", "07.11.2022", "сутки", "grey", "Доставка до офиса"},
                {false, "Вячеслав", "Ячсмит", "Орехово", "Красноярск", "89962285944", "12.12.2023", "пятеро суток", "black", "Я передумал"},
        };
    }

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void tryToOrderFirstButton(){
        OrderPage orderPage = new OrderPage(browserRule.getDriver());
        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage
            .open()
            .clickOrderButton(orderButton);
        orderPage
            .inputSurename(surname)
            .inputAddress(address)
            .inputMetro(metro)
            .inputPhoneNumber(phone)
            .clickNext()
            .inputWhereDate(date)
            .inputTimeToHold(period)
            .inputScootaColor(colour)
            .inputComment(text)
            .clickFinalOrderHeaderButton()
            .clickOrderHeaderYesButton()
            .checkOrderIsAccepted();
    }
}
