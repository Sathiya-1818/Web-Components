package guvi.org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.guvi.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div/div[2]/a")).click();

        driver.findElement(By.id("name")).sendKeys("Sakthi");
        driver.findElement(By.id("email")).sendKeys("meh412523@gmail.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("password")).sendKeys("Sakthi86");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@id=\"mobileNumber\"]")).sendKeys("9489642890");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mouse = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"signup-btn\"]")));

        Actions action = new Actions(driver);
        action.moveToElement(mouse).click().perform();

        String text = driver.getTitle();
        System.out.println(text);

        //driver.quit();

    }
}