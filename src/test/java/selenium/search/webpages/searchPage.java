package selenium.search.webpages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class searchPage {
    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(searchPage.class.getName());

    @FindBy (name = "q")
    private WebElement searchField;
    @FindBy (name = "btnK")
    private WebElement searchButton;

    public searchPage (WebDriver driver) {
       this.driver=driver;
       driver.getTitle();
       PageFactory.initElements(driver, this);}

    public  boolean isTitleOk () {
        return driver.getTitle().toString().contentEquals("Google");
    }

    public void searchSelenium (){
        searchPage googleSearch = new searchPage(driver);
        Assert.assertTrue(googleSearch.isTitleOk());
        log.info("Title Checked.Its Google;");
        searchField.sendKeys("Selenium");
        searchButton.click();
        log.info("Searching for Selenium;");
    }
}


