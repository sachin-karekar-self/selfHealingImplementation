package pages;
import org.openqa.selenium.WebDriver;
import utilities.LocatorReader;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver, String pageJson){
        this.driver = driver;
        LocatorReader.loadLocatorsFromJson(pageJson);
    }

    public void clickEmployeeList(){
        driver.findElement(LocatorReader.findLocatorByPartialName("Employee List")).click();
    }

}
