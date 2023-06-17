package ru.praktikum.scooter.order;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;


public class CheckoutPage {
    private final By inputName = By.xpath(".//input[@placeholder='* Имя']");
    private final By inputSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By inputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By choosingMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By inputPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath(".//button[text()='Далее']");
    Random random = new Random();
    private final int randomNumberStation = random.nextInt(237);
    private final By nameStations = By.xpath("//div[@class='select-search__select']/ul/li[" + (randomNumberStation + 1) + "]/button");
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public AboutRentPage orderPlacing(String name, String surname, String address, String phoneNumber) {

        driver.findElement(inputName).sendKeys(name);
        driver.findElement(inputSurname).sendKeys(surname);
        driver.findElement(inputAddress).sendKeys(address);
        driver.findElement(inputPhoneNumber).sendKeys(phoneNumber);
        driver.findElement(choosingMetroStation).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(nameStations));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(nameStations));
        driver.findElement(nameStations).click();
        driver.findElement(nextButton).click();

        return new AboutRentPage(driver);
    }

}
