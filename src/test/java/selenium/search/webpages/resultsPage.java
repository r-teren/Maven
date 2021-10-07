package selenium.search.webpages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class resultsPage {
    private WebDriver driver;

    By containSelenium=By.xpath("//*[contains (text(),'Selenium')]");

    public resultsPage(WebDriver driver) {
       this.driver=driver;
       WebDriverWait loadWait = new WebDriverWait(driver,3);
               }

     public void countSelenium () {
            List<WebElement> countSelenium = driver.findElements(containSelenium);
        }
        }










