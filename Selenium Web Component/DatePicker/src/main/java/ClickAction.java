import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ClickAction {

    public void Main(String[] args){
        WebDriver driver =  new ChromeDriver();
        driver.get("https://jqueryui.com/datepicker/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebElement leftClick = driver.findElement(By.id("datepicker"));
        Actions mouse = new Actions(driver);
        mouse.contextClick(leftClick).perform();

        WebElement date = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]"));
        mouse.click(date).perform();

    }
}
