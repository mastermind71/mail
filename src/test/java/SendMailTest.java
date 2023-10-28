import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import pages.Data;
import pages.PageAutorizationMail;
import pages.PageMail;

public class SendMailTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get(Data.deployUrl);
    }

    @Test
    public void sendMailTest() throws InterruptedException{
        PageAutorizationMail pageAutorizationMail = new PageAutorizationMail(driver);
        PageMail pageMail = new PageMail(driver);
        pageAutorizationMail.stepsForAutorization();
        pageMail.stepsSendMail();
        String actualText = pageMail.getTextSuccessSendMail();
        String expectedText = "Письмо отправлено";
        Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void quit(){
        driver.quit();
    }
}
