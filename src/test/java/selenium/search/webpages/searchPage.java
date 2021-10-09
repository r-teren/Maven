package selenium.search.webpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;


public class searchPage {
    private WebDriver driver;

    //URL
    //private static String searchURL = "https://google.com";


    @FindBy (name = "q")
    private WebElement searchField;
    @FindBy (name = "btnK")
    private WebElement searchButton;

    //Constructor
    public searchPage (WebDriver driver) {
        this.driver=driver;
        //driver.get(searchURL);
        driver.getTitle();
       PageFactory.initElements(driver, this);}

    public  boolean isTitleOk () {
        return driver.getTitle().toString().contentEquals("Google");


    }
    public void searchSelenium (){
        searchField.sendKeys("Selenium");
        searchButton.click();
    }

}


