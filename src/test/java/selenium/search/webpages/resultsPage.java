package selenium.search.webpages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class resultsPage {
    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(searchPage.class.getName());

    @FindBy(xpath="//*[contains (text(),'Selenium')]")
    private List<WebElement> containSelenium;
    //By containSelenium=By.xpath("//*[contains (text(),'Selenium')]");

    public resultsPage(WebDriver driver) {
        this.driver=driver;
       PageFactory.initElements(driver, this);}

         public void results() {
        String pageTitle = driver.getTitle();
            System.out.println("\n"+containSelenium.size() + " Web elements contain text 'Selenium' for page "+ "'"
                    + pageTitle +"'"+"\n"
            );
             log.info("Results printed;");}

    }













