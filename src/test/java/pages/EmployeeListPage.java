package pages;
import org.openqa.selenium.WebDriver;
import utilities.LocatorReader;

public class EmployeeListPage {

    private WebDriver driver;

    public EmployeeListPage(WebDriver driver, String pageJson){
        this.driver = driver;
        LocatorReader.loadLocatorsFromJson(pageJson);
    }

    public void clickCreateNewEmployee(){
        driver.findElement(LocatorReader.findLocatorByPartialName("Create New")).click();
    }
}
