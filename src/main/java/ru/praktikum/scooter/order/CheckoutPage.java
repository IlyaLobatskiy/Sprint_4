package ru.praktikum.scooter.order;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.util.Random;


public class CheckoutPage {
    Random random = new Random();
    WebDriver driver;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }
    private final int randomNumberStation = random.nextInt(237);
    private final By inputName = By.xpath(".//input[@placeholder='* Имя']");
    private final By inputSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By inputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By choosingMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By inputPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath(".//button[text()='Далее']");
    private final By nameStations = By.xpath("//div[@class='select-search__select']/ul/li["+ (randomNumberStation + 1) +"]/button");

    public AboutRentPage orderPlacing(String name, String surname, String address, String phoneNumber) throws InterruptedException {

        driver.findElement(inputName).sendKeys(name);
        Thread.sleep(500);
        driver.findElement(inputSurname).sendKeys(surname);
        Thread.sleep(500);
        driver.findElement(inputAddress).sendKeys(address);
        Thread.sleep(500);
        driver.findElement(inputPhoneNumber).sendKeys(phoneNumber);
        Thread.sleep(500);
        driver.findElement(choosingMetroStation).click();
        Thread.sleep(500);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(nameStations));
        Thread.sleep(500);
        driver.findElement(nameStations).click();
        Thread.sleep(500);
        driver.findElement(nextButton).click();

        return new AboutRentPage(driver);
    }

}
