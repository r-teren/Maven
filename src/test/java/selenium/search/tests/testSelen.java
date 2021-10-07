package selenium.search.tests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import selenium.search.webpages.resultsPage;
import selenium.search.webpages.searchPage;
import java.util.concurrent.TimeUnit;

public class testSelen {
    WebDriver driver;

    @Before
    public void setup(){
        //usage of Chrome Driver
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
               }

    @Test
    public void TestPages () {

       searchPage googleSearch = new searchPage(driver);
       Assert.assertTrue(googleSearch.isTitleOk());
       googleSearch.searchSelenium();

        resultsPage selCount =new resultsPage(driver);
        selCount.countSelenium();
        }

   @After
    public void close() {
        driver.close();
    }
}

