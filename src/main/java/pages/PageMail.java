package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageMail {
    private WebDriver driver;
    private By buttonNewLetter = By.xpath(".//a[@title='Написать письмо']");
    private By buttonAttachFile = By.xpath(".//button[@type='button'][@tabindex='500']");
    private By fieldRecipient = By.xpath(".//input[@type='text'][@tabindex='100']");
    private By fieldTopic = By.xpath(".//input[@type='text'][@tabindex='400']");
    private By fieldMessage = By.xpath(".//div[@tabindex='505']/div/br");
    private By buttonSendMessage = By.xpath(".//button[@tabindex='570']");
    private By textSuccessSendMail = By.cssSelector("a.layer__link");

    public PageMail(WebDriver driver){
        this.driver = driver;
    }

    public void pushNewMessage(){
        driver.findElement(buttonNewLetter).click();
    }
    public void waitLoadNewMessage(){
        new WebDriverWait(driver , 12)
                .until(ExpectedConditions.elementToBeClickable(buttonAttachFile));
    }
    public void fillingRecipient(){
        driver.findElement(fieldRecipient).sendKeys(Data.email);
    }
    public void fillingTopic(){
        driver.findElement(fieldTopic).sendKeys(Data.topic);
    }
    public void fillingMessage(){
        driver.findElement(fieldMessage).sendKeys(Data.message);
    }
    public void pushSendMessage(){
        driver.findElement(buttonSendMessage).click();
    }
    public void stepsSendMail() throws InterruptedException{
        pushNewMessage();
        waitLoadNewMessage();
        fillingRecipient();
        fillingTopic();
        fillingMessage();
        pushSendMessage();
        Thread.sleep(3000);
    }
    public String getTextSuccessSendMail(){
        return driver.findElement(textSuccessSendMail).getText();
    }
}
