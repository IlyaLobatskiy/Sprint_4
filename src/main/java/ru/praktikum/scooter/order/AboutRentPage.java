package ru.praktikum.scooter.order;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class AboutRentPage {

    Random random = new Random();
    WebDriver driver;
    public AboutRentPage(WebDriver driver){
        this.driver = driver;
    }

    private final int periodNumber = random.nextInt(7);
    private final int chekBoxNumber = random.nextInt(2 );
    private final By deliveryDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By commentForCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By rentalPeriod = By.xpath(".//div[@class='Dropdown-root']");

    private final By period = By.xpath(".//div[@class='Dropdown-menu']/div[" + (periodNumber + 1) + "]");
    private final By chekBox = By.xpath(".//div[@class='Order_Checkboxes__3lWSI']/label[" + (chekBoxNumber + 1) + "]/input");
    private final By nextButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    public OrderConfirmationWindow deliveryInfo(String date, String comment) throws InterruptedException {

        driver.findElement(deliveryDate).sendKeys(date, Keys.ENTER);
        Thread.sleep(500);
        driver.findElement(rentalPeriod).click();
        Thread.sleep(500);
        driver.findElement(period).click();
        Thread.sleep(500);
        driver.findElement(chekBox).click();
        Thread.sleep(500);
        driver.findElement(commentForCourier).sendKeys(comment);
        Thread.sleep(500);
        driver.findElement(nextButton).click();

        return new OrderConfirmationWindow(driver);

    }


}
