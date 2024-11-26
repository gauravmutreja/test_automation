package practice_tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Alert_box {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        try {
            driver.get("https://rahulshettyacademy.com/AutomationPractice");
            driver.findElement(By.cssSelector("#name")).sendKeys("Gaurav M");
            driver.findElement(By.cssSelector("#alertbtn")).click();
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
            driver.findElement(By.xpath("//*[@value='Confirm']")).click();
            System.out.println(alert.getText());
            alert.dismiss();
        } finally {
            driver.quit();
        }


    }
}
