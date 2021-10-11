package selenium.search.tests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import selenium.search.webpages.resultsPage;
import selenium.search.webpages.searchPage;
import java.util.concurrent.TimeUnit;


public class testSelen {
    WebDriver driver;
    private static final Logger log = LogManager.getLogger(testSelen.class.getName());


    @Before
    public void setup(){
        //usage of Chrome Driver
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String baseURL = "https://google.com";
        driver.get(baseURL);
        log.info("Google search page opened;");
    }

    @Test
    public void TestPages () {

       searchPage findSel = new searchPage(driver);
       findSel.verifyTitle();
       findSel.searchCriteria("Selenium");

       resultsPage countSel =new resultsPage(driver);
       countSel.results();
    }

    @After
    public void close() {
        driver.close();
        log.info("Browser closed;");
    }
}