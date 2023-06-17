package ru.praktikum.scooter.order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderHasBeenPlacedWindow {
    private final By orderStatusButton = By.xpath(".//button[text()='Посмотреть статус']");
    private final By statusOrder = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");
    WebDriver driver;

    public OrderHasBeenPlacedWindow(WebDriver driver) {
        this.driver = driver;
    }

    public String getStatusOrder() {
        String[] el = driver.findElement(statusOrder).getText().split("\n");

        return el[0];
    }

    public void clickOrderStatusButton() {
        driver.findElement(orderStatusButton).click();
    }
}
