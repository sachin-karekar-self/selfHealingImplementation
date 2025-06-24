package pages;
import org.openqa.selenium.WebDriver;
import utilities.LocatorReader;

public class CreateEmployeePage {

    private WebDriver driver;

    public CreateEmployeePage(WebDriver driver, String pageJson){
        this.driver = driver;
        LocatorReader.loadLocatorsFromJson(pageJson);
    }

    public void fillEmployeeDetails(String name, String lastName, String email, String phone, String department){
        driver.findElement(LocatorReader.findLocatorByPartialName("Name")).sendKeys(name);
        driver.findElement(LocatorReader.findLocatorByPartialName("Last Name")).sendKeys(lastName);
        driver.findElement(LocatorReader.findLocatorByPartialName("Email")).sendKeys(email);
        driver.findElement(LocatorReader.findLocatorByPartialName("Phone")).sendKeys(phone);
        driver.findElement(LocatorReader.findLocatorByPartialName("Department")).sendKeys(department);
    }   

    public void clickLogoff(){
        driver.findElement(LocatorReader.findLocatorByPartialName("Log off")).click();
    }

}
