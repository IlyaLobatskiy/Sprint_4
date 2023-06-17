package ru.praktikum.scooter.order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationWindow {
    private final By yesButton = By.xpath(".//button[text()='Да']");
    private final By noButton = By.xpath(".//button[text()='Нет']");
    WebDriver driver;

    public OrderConfirmationWindow(WebDriver driver) {
        this.driver = driver;
    }

    public OrderHasBeenPlacedWindow clickYes() {
        driver.findElement(yesButton).click();
        return new OrderHasBeenPlacedWindow(driver);
    }

    public void clickNo() {
        driver.findElement(noButton).click();
    }
}
