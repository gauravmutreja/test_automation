package practice_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class DropDown_RadioButton {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/gauravmutreja/IdeaProjects/chromedriver-mac-arm64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");

        try {
            //Static Dropdown: Currency
            //dropdown with Select tag - Static
            WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
            Select dropdown = new Select(staticDropdown);
            dropdown.selectByIndex(3); // USD
            System.out.println(dropdown.getFirstSelectedOption().getText()); // to check wats selected
            Thread.sleep(1000);
            dropdown.selectByValue("AED");
            System.out.println(dropdown.getFirstSelectedOption().getText()); // to check wats selected
            Thread.sleep(1000);
            dropdown.selectByVisibleText("INR");
            System.out.println(dropdown.getFirstSelectedOption().getText()); // to check wats selected

            //Drop Down - No. of tickets : PASSENGERS
            driver.findElement(By.id("divpaxinfo")).click(); // this will open passenger's list
            Thread.sleep(1000);
            System.out.println(driver.findElement(By.id("divpaxinfo")).getText()); //1 Adult
            //driver.findElement(By.id("hrefIncAdt")).click(); // this leads to 2 Adult as 1 is already there.

        /*int i=1;
        while(i<5){
            driver.findElement(By.id("hrefIncAdt")).click(); // 4 times
            i++;
        }*/
            for (int i = 1; i < 5; i++) {
                driver.findElement(By.id("hrefIncAdt")).click(); // 4 times
            }
            driver.findElement(By.id("btnclosepaxoption")).click(); //"Done"
            Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
            System.out.println(driver.findElement(By.id("divpaxinfo")).getText()); // 5 Adults

            // Roundtrip:

            // Check if Round Trip Enabled
            //System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled()); // is disabled but still shows true
            System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
            driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click(); // round trip click
            System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

            if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
                System.out.println("its enabled");
                Assert.assertTrue(true);
            } else {
                System.out.println("Its disabled");
                Assert.assertTrue(false);
            }

            driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click(); // select round trip

            // Dynamic Dropdown: From & To location:
            driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); // click from
            driver.findElement(By.xpath("//a[@value='BLR']")).click(); // click banglore
            System.out.println(driver.findElement(By.xpath("//a[@value='BLR']")).getText());// print banglore
            Thread.sleep(1000);

            /* Xpath for Chennai :
            //a[@value='MAA'])[2]")) : index
            div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA'] : Parent Child Relationship xpath
            */
            driver.findElement((By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))).click(); //Chennai
            System.out.println(driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).getText()); // print Chennai

            //checkbox
            Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()); // Actual  False
            System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()); // False
            driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
            // to check if selected
            System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()); //True

            Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()); // Actual True

            //count the number of CheckBox
            System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size()); // 6

            // To Date:
            driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
            driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
            Thread.sleep(1000);

            //Auto Suggestive Dropdown: Country
            driver.findElement(By.id("autosuggest")).sendKeys("ind");
            Thread.sleep(1000);
            List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item']")); // Select Country
            for (WebElement option : options) {
                if (option.getText().equalsIgnoreCase("INDIA")) {
                    option.click();
                    break;
                }
            }





            driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
            Thread.sleep(2000);
        } finally {
            driver.quit();
        }

    }
}
