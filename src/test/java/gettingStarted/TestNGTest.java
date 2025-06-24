package gettingStarted;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ai.LoginPage;
import pages.EmployeeListPage;
import pages.CreateEmployeePage;
import pages.HomePage;
import utilities.LocatorReader;
import utilities.OpenAIHelper;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestNGTest
{
    private OpenAIClient client;
    private WebDriver driver;

    @BeforeTest
    public void Setup()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.navigate().to("http://eaapp.somee.com/Account/Login");
    }

  /*
    @Test
    public void testLogin() {

        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .addUserMessage("Get the page source from http://eaapp.somee.com and get all the locators like ID, Name, XPath and CSS")
                .model(ChatModel.GPT_4_1)
                .build();
        ChatCompletion chatCompletion = client.chat().completions().create(params);

        String message = chatCompletion.choices().get(0).message()._content().toString();

        System.out.println("Response from GPT:" + message);
    }
*/
    @Test
    public void testLoginForUserFromAI() {
        System.out.println("Testing User Login from AI Locators");
        var jsonResponse = OpenAIHelper.GetLocatorsForPageAsJson(driver.getPageSource());
        LoginPage loginPage = new LoginPage(driver, jsonResponse);
        loginPage.performLogin("admin", "password");
    }

    @Test
    public void testEmployeeListNavigation() {
        System.out.println("Testing the employee list operation");
        var jsonResponse = OpenAIHelper.GetLocatorsForPageAsJson(driver.getPageSource());
        HomePage homePage = new HomePage(driver, jsonResponse);
        homePage.clickEmployeeList();
    }

    @Test
    public void testCreateNewEmployee() {
        System.out.println("Testing the create new employee operation");
        var jsonResponse = OpenAIHelper.GetLocatorsForPageAsJson(driver.getPageSource());
        EmployeeListPage employeeListPage = new EmployeeListPage(driver, jsonResponse);
        employeeListPage.clickCreateNewEmployee();
    }

    @Test
    public void testFillEmployeeDetails() {
        System.out.println("Testing the fill employee details operation");
        var jsonResponse = OpenAIHelper.GetLocatorsForPageAsJson(driver.getPageSource());
        CreateEmployeePage createEmployeePage = new CreateEmployeePage(driver, jsonResponse);
        createEmployeePage.fillEmployeeDetails("AutoUser2", "22222", "autotestuser2@gmail.com", "20000", "Middle");
        createEmployeePage.clickLogoff();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

}
