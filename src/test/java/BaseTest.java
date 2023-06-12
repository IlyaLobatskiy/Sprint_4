import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public abstract class BaseTest {

    //Chrome
    WebDriver driver;

    // FireFox
    //WebDriver driver;

    @Before
    public void setUpDriver(){
        // FireFox
        //WebDriverManager.firefoxdriver().setup();

        //Chrome
        WebDriverManager.chromedriver().setup();

        // FireFox
        //driver = new FirefoxDriver();

        //Chrome
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));


    }

    @After
    public void closeBrows(){
        driver.quit();
    }
}
