import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.scooter.order.*;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String phoneNumber;
    private final String date;
    private final String comment;

    public OrderTest(String name, String surname, String address, String phoneNumber,
                     String date, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.comment = comment;
    }

    @Parameterized.Parameters(name = "Имя {0}, Фамилия {1}, Адрес доставки {2}, Номер телефона {3}, дата доставки {4}, Комментарий {5} ")
    public static Object[][] getSumData() {
        return new Object[][]{
                {"Василий", "Петрович", "ул.Советов, д.8, кв. 65", "79239232323",
                        "04.02.2023", "Код домофона #777*"},
                {"Петр", "Васильев", "ул.Ленина, д.13, кв. 3", "79139131313",
                        "06.04.2023", "Комментарий"}
        };
    }

    @Test
    public void isMainPageOrder() throws InterruptedException {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPage = new MainPage(driver);
        mainPage.clickCookiesYesButton();
        CheckoutPage checkoutPage;
        checkoutPage = mainPage.clickOrderButton();

        AboutRentPage aboutRentPage;
        aboutRentPage = checkoutPage.orderPlacing(name, surname, address, phoneNumber);

        OrderConfirmationWindow orderConfirmationWindow;
        orderConfirmationWindow = aboutRentPage.deliveryInfo(date, comment);

        OrderHasBeenPlacedWindow orderHasBeenPlacedWindow;
        orderHasBeenPlacedWindow = orderConfirmationWindow.clickYes();

        Assert.assertEquals("Заказ не оформлен", "Заказ оформлен", orderHasBeenPlacedWindow.getStatusOrder());
    }

    @Test
    public void isHederOrder() throws InterruptedException {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        Heder heder = new Heder(driver);
        CheckoutPage checkoutPage;
        checkoutPage = heder.clickOrderButton();

        AboutRentPage aboutRentPage;
        aboutRentPage = checkoutPage.orderPlacing(name, surname, address, phoneNumber);

        OrderConfirmationWindow orderConfirmationWindow;
        orderConfirmationWindow = aboutRentPage.deliveryInfo(date, comment);

        OrderHasBeenPlacedWindow orderHasBeenPlacedWindow;
        orderHasBeenPlacedWindow = orderConfirmationWindow.clickYes();

        Assert.assertEquals("Заказ не оформлен", "Заказ оформлен", orderHasBeenPlacedWindow.getStatusOrder());
    }
}
