import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {

    WebDriver driver;

    @Before
    public void setUpDriver() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

    }

    @After
    public void closeBrows() {
        driver.quit();
    }
}
