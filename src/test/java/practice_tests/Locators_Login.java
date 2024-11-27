package practice_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators_Login {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/gauravmutreja/IdeaProjects/chromedriver-mac-arm64/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String name = "Gaurav";

       /*driver.get("https://rahulshettyacademy.com"); // get:  to go to a particular website
        System.out.println(driver.getTitle()); // .getTitle: to get title of the website
        System.out.println(driver.getCurrentUrl()); // .getCurrentUrl : to get url of current page
        driver.close(); // close(): closes the window browser only which got opened.
        // driver.quit(); // quit() : closes not only the current window opened but also all associated windows opened.
        // if code / script opens multiple windows we should use quit(), if it only opens single window then use close()
        // difference between quit () and close () method?
        // Ans:quit() shall quite the driver and close() shall close the current window
        //Method that gives the source of the last page loaded : getPageSource()
        */

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys("password123");
        driver.findElement((By.className("signInBtn"))).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText()); // tagname.classname
        String password = getPassword(driver);

        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click(); //Go to Login by tags only
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        Thread.sleep(2000);
        //driver.close();
        driver.quit();

    }

    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000); // i.e. 1 second wait ()
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Gaurav");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Sahil@gmail.com");
        driver.findElement(By.xpath(("//input[@placeholder='Email']"))).clear();
        driver.findElement(By.xpath("//input[@type='text'][2] ")).sendKeys("Gaurav@gmail.com");
        //driver.findElement(By.cssSelector(("input[type='text']:nth-child(3)"))).sendKeys("sahil@gmail.com");
        //driver.findElement(By.xpath("//form/h2")).getText(); //to get text: Forgot Password
        //cssSelector("form h2")
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("9999999999");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        //identify element from Partial Value: xpath: "//button[contains(@class,'pwd')]", css: "button[class*='pwd']" : for "Reset Login" button
        System.out.println(driver.findElement(By.cssSelector("form p")).getText()); // Please use temporary password 'rahulshettyacademy' to Login.

        String passwordText = driver.findElement(By.cssSelector("form p")).getText();
        //Please use temporary password 'rahulshettyacademy' to Login.
        String passwordArray[] = passwordText.split("'");
        // String passwordArray2[]=passwordArray[1].split("'");
        // then String Password = passwordArray2[0];

        String password = passwordArray[1].split("'")[0];

        //0th index - Please use temporary password
        //1st index - rahulshettyacademy' to Login.

        //0th index - rahulshettyacademy
        //1st index - to Login
        return password;
    }
}
