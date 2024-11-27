package practice_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WindowActivities {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/gauravmutreja/IdeaProjects/chromedriver-mac-arm64/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://google.com"); // get is used to open the browser, in this driver wait till compete page is loaded
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        Thread.sleep(1000);

        driver.navigate().to("https://rahulshettyacademy.com");
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        Thread.sleep(1000);

        driver.navigate().back();
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        Thread.sleep(1000);

        driver.navigate().forward();
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        Thread.sleep(1000);

        driver.close();
        /*
        driver.get("https://rahulshettyacademy.com"); // get:  to go to a particular website
        System.out.println(driver.getTitle()); // .getTitle: to get title of the website
        System.out.println(driver.getCurrentUrl()); // .getCurrentUrl : to get url of current page
        driver.close(); // close(): closes the window browser only which got opened.
        // driver.quit(); // quit() : closes not only the current window opened but also all associated windows opened.
        // if code / script opens multiple windows we should use quit(), if it only opens single window then use close()
        // difference between quit () and close () method?
        // Ans:quit() shall quite the driver and close() shall close the current window
        //Method that gives the source of the last page loaded : getPageSource()
        */

    }
}
