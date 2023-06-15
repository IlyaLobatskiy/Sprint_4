package ru.praktikum.scooter.order;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class AboutRentPage {

    private final By deliveryDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By commentForCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By rentalPeriod = By.xpath(".//div[@class='Dropdown-root']");
    private final By nextButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    Random random = new Random();
    private final int periodNumber = random.nextInt(7);
    private final By period = By.xpath(".//div[@class='Dropdown-menu']/div[" + (periodNumber + 1) + "]");
    private final int chekBoxNumber = random.nextInt(2);
    private final By chekBox = By.xpath(".//div[@class='Order_Checkboxes__3lWSI']/label[" + (chekBoxNumber + 1) + "]/input");
    WebDriver driver;

    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderConfirmationWindow deliveryInfo(String date, String comment) {

        driver.findElement(deliveryDate).sendKeys(date, Keys.ENTER);
        driver.findElement(rentalPeriod).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(period));
        driver.findElement(period).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(chekBox));
        driver.findElement(chekBox).click();
        driver.findElement(commentForCourier).sendKeys(comment);
        driver.findElement(nextButton).click();

        return new OrderConfirmationWindow(driver);
    }
}
