package guvi.org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {

        WebDriver driver =  new ChromeDriver();
        driver.get("https://jqueryui.com/datepicker/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);

        WebElement date = driver.findElement(By.id("datepicker"));
        date.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ui-datepicker-next")));
        nextButton.click();

        WebElement select = driver.findElement(By.xpath("//a[text()='22']"));
        select.click();

        String selectedDate = date.getAttribute("value");
        System.out.println("Selected date: " + selectedDate);
        driver.quit();


    }
}