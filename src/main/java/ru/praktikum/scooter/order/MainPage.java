package ru.praktikum.scooter.order;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {

    // Локатор для кнопка принятия куков
    private final By cookiesYesButton = By.id("rcc-confirm-button");
    // Локатор для кнопка заказать
    private final By orderButton = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button");
    // Локатор для аккордеон
    private final By accordion = By.xpath(".//div[@class='accordion']/div");
    // Создаем элемент драйвера
    WebDriver driver;

    // Создаем конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Принимаем куки
    public void clickCookiesYesButton() {
        driver.findElement(cookiesYesButton).click();
    }

    // Нажимаем на кнопку заказать
    public CheckoutPage clickOrderButton() {

        // Скроллим до кнопки заказать
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(orderButton));

        // Ожидаем пока кнопка заказать станет кликабельна
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(orderButton));

        // Нажимаем на кнопку заказать
        driver.findElement(orderButton).click();

        // Возвращаем объект следующей страницы
        return new CheckoutPage(driver);
    }

    // Сравниваем ожидаемый и фактический текст аккордеона
    public int textFaq(String[] expectedTexts) {
        // Создаем список из вопросов и ответов
        List<WebElement> faqElement = driver.findElements(accordion);

        // Скролл до аккордеона
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(accordion));

        // Переменная счетчик считающая кол-во совпадений
        int resalt = 0;

        // Сравниваем фактический результат с ожидаемым и если результат совпадает увеличиваем счетчик на 1
        for (int i = 0; i < faqElement.size(); i++) {

            faqElement.get(i).click();
            new WebDriverWait(driver, Duration.ofSeconds(1))
                    .until(ExpectedConditions.textToBePresentInElement(faqElement.get(i), faqElement.get(i).getText()));

            if (faqElement.get(i).getText().equalsIgnoreCase(expectedTexts[i])) {
                resalt++;
            } else {
                System.out.println(faqElement.get(i).getText());
            }
        }
        return resalt;
    }
}
