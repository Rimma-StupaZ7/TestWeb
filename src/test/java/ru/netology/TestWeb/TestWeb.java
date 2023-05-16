package ru.netology.TestWeb;
//import org.jsoup.helper.W3CDom;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

//import static java.lang.System.setProperty;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestWeb {
    private WebDriver driver;


    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }
     @Test
     void shouldTest1(){
         driver.get("http://localhost:9999/");
         driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Вилкин Павел");
         driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79215553366");
         driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
         driver.findElement(By.cssSelector("button")).click();
         String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
         String actual = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText().trim();
         assertEquals(expected, actual);

     }




}