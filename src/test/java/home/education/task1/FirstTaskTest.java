package home.education.task1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class FirstTaskTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void firstTaskTest() throws InterruptedException {
        driver.navigate().to("https://www.google.ru/");
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("capital of GB");
        search.sendKeys(Keys.ESCAPE);
        driver.findElement(By.name("btnK")).click();
        wait.until(titleIs("capital of GB - Поиск в Google"));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}
