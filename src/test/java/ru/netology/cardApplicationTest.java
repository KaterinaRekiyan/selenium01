
package ru.netology;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.w3c.dom.Text;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class cardApplicationTest {
    private WebDriver driver;
    ChromeOptions options = new ChromeOptions();

    @BeforeAll
    static void setUpAll() {
//        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:9999");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldTestv1() {
        List<WebElement> elements = driver.findElements(By.className("input__control"));
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Васильев Василий");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79998887766");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();
        assertEquals (expected, actual);
    }

//    @Test
//    void shouldTestv2() {
//        List<WebElement> elements = driver.findElements(By.className("input__control"));
//        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Кулёчкина Алёна");
//        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79998887766");
//        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
//        driver.findElement(By.className("button")).click();
//        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
//        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();
//        assertEquals (expected, actual);
//    }
//    буква "Ё" не валидируется

    @Test
    void shouldTestv3() {
        List<WebElement> elements = driver.findElements(By.className("input__control"));
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Мамин-Сибиряк Василий");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79998887766");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();
        assertEquals (expected, actual);
    }

    @Test
    void shouldTestv4() {
        List<WebElement> elements = driver.findElements(By.className("input__control"));
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Я");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79998887766");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();
        assertEquals (expected, actual);
    }

    @Test
    void shouldTestv5() {
        List<WebElement> elements = driver.findElements(By.className("input__control"));
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("James Ivanovich");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79998887766");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
        String actual = driver.findElement(By.className("input__sub")).getText().trim();
        assertEquals (expected, actual);
    }

    @Test
    void shouldTestv6() {
        List<WebElement> elements = driver.findElements(By.className("input__control"));
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Лук'янов Д’Артаньян");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79998887766");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
        String actual = driver.findElement(By.className("input__sub")).getText().trim();
        assertEquals (expected, actual);
    }

    @Test
    void shouldTestv7() {
        List<WebElement> elements = driver.findElements(By.className("input__control"));
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Васильева Ан@стасия");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79998887766");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
        String actual = driver.findElement(By.className("input__sub")).getText().trim();
        assertEquals (expected, actual);
    }

    @Test
    void shouldTestv8() {
        List<WebElement> elements = driver.findElements(By.className("input__control"));
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Почтальон Пе4кин");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79998887766");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
        String actual = driver.findElement(By.className("input__sub")).getText().trim();
        assertEquals (expected, actual);
    }

    @Test
    void shouldTestv9() {
        List<WebElement> elements = driver.findElements(By.className("input__control"));
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79998887766");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Поле обязательно для заполнения";
        String actual = driver.findElement(By.className("input__sub")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    void shouldTestv10() {
        List<WebElement> elements = driver.findElements(By.className("input__control"));
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Васильев Василий");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Поле обязательно для заполнения";
        String actual = driver.findElement(By.cssSelector("[data-test-id='phone'].input_invalid .input__sub")).getText();
        assertEquals(expected, actual);
    }

    @Test
    void shouldTestv11() {
        List<WebElement> elements = driver.findElements(By.className("input__control"));
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Васильев Василий");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+7999888776");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.";
        String actual = driver.findElement(By.cssSelector("[data-test-id='phone'].input_invalid .input__sub")).getText();
        assertEquals(expected, actual);
    }

    @Test
    void shouldTestv12() {
        List<WebElement> elements = driver.findElements(By.className("input__control"));
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Васильев Василий");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+799988877665");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.";
        String actual = driver.findElement(By.cssSelector("[data-test-id='phone'].input_invalid .input__sub")).getText();
        assertEquals(expected, actual);
    }
}
