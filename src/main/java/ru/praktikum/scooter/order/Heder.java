package ru.praktikum.scooter.order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Heder {
    private final By yandexLogo = By.xpath(".//a[@class='Header_LogoYandex__3TSOI']");
    private final By scooterLogo = By.xpath(".//a[@class='Header_LogoScooter__3lsAR']");
    private final By orderButton = By.xpath("//div[@class='Header_Nav__AGCXC']/button[1]");
    private final By searchOrderButton = By.xpath("//div[@class='Header_Nav__AGCXC']/button[2]");
    private final By inputNumberOrder = By.xpath(".//input[@class='Input_Input__1iN_Z Header_Input__xIoUq']");
    private final By goButton = By.xpath(".//button[text()='Go!']");
    private final WebDriver driver;

    public Heder(WebDriver driver) {
        this.driver = driver;
    }

    public void clickYandexLogo() {
        driver.findElement(yandexLogo).click();
    }

    public void clickScooterLogo() {
        driver.findElement(scooterLogo).click();
    }

    public CheckoutPage clickOrderButton() {

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(orderButton));

        driver.findElement(orderButton).click();

        return new CheckoutPage(driver);
    }

    public void clickSearchOrderButton() {
        driver.findElement(searchOrderButton);
    }

    public void setInputNumberOrder(String numberOrder) {
        driver.findElement(inputNumberOrder).isEnabled();
        driver.findElement(inputNumberOrder).sendKeys(numberOrder);
    }

    public void clickGoButton() {
        driver.findElement(goButton).isEnabled();
        driver.findElement(goButton).click();
    }
}
