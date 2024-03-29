import org.junit.Assert;
import org.junit.Test;
import ru.praktikum.scooter.order.MainPage;


public class FaqTest extends BaseTest {

    // Массив с вопросами и ответами (Ожидаемый результат)
    private final String[] expectedTexts = {

            "Сколько это стоит? И как оплатить?\nСутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Хочу сразу несколько самокатов! Так можно?\nПока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Как рассчитывается время аренды?\nДопустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Можно ли заказать самокат прямо на сегодня?\nТолько начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Можно ли продлить заказ или вернуть самокат раньше?\nПока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Вы привозите зарядку вместе с самокатом?\nСамокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Можно ли отменить заказ?\nДа, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Я жизу за МКАДом, привезёте?\nДа, обязательно. Всем самокатов! И Москве, и Московской области."

    };

    // Текст ошибки
    private final String errorText = "Должно быть " + expectedTexts.length + " вопросов и ответов. Текст указанный выше содержит ошибку";

    @Test
    public void getTextAccordionElementsTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);

        mainPage.clickCookiesYesButton();

        Assert.assertEquals(errorText, expectedTexts.length, mainPage.textFaq(expectedTexts));
    }


}
