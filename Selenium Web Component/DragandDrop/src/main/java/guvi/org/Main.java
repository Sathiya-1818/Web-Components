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
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe.demo-frame")));

        WebElement target = driver.findElement(By.cssSelector("#droppable"));
        WebElement source = driver.findElement(By.cssSelector("#draggable"));

        Actions action = new Actions(driver);
        action.dragAndDrop(source, target).perform();

        String color =target.getCssValue("background-color");
        System.out.println("Color after Dropped in Target : " +color);

        if(color.equals("rgba(255, 250, 144, 1)")){
            System.out.println("Operation is Successful");
        }else{
            System.out.println("Operatiom is failed");
        }

        String text = target.getText();
        System.out.println(" Text after dropped in target : " +text);

        if(text.equals("Dropped!")){
            System.out.println("Text verification is Successful");
        } else {
            System.out.println("Text verification is not Successful");
        }

    }
}
