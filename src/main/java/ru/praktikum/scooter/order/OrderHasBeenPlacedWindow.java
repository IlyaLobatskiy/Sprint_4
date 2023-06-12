package ru.praktikum.scooter.order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderHasBeenPlacedWindow {
    WebDriver driver;
    public OrderHasBeenPlacedWindow(WebDriver driver){
        this.driver = driver;
    }

    private final By orderStatusButton = By.xpath(".//button[text()='Посмотреть статус']");
    private final By numberOrder = By.xpath("//*[@id='root']/div/div[2]/div[5]/div[1]/div/text()[2]");

    public void clickOrderStatusButton(){
        driver.findElement(orderStatusButton).click();
    }

}
