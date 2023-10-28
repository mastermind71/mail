package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageAutorizationMail {
    private WebDriver driver;
    private By fieldEmailForAutorization = By.xpath("//input[@name='username']");
    private By buttonFillingPasswordOnAutorizationPage = By.xpath("//button[@type='submit']");
    private By fieldPasswordForAutorization = By.xpath("//input[@name='password']");
    private By filtersOnMainPageMail = By.cssSelector("span.filters-control__filter-text.js-promo-id_octavius-tooltip-mailbox-sort");

    public PageAutorizationMail(WebDriver driver){
        this.driver = driver;
    }
    public void fillingEmailForAutorization(){
        driver.findElement(fieldEmailForAutorization).sendKeys(Data.email);
    }
    public void submitEmail(){
        driver.findElement(buttonFillingPasswordOnAutorizationPage).click();
    }
    public void fillingPasswordForAutorization(){
        driver.findElement(fieldPasswordForAutorization).sendKeys(Data.passwordForEmail);
    }
    public void waitFilter(){
        new WebDriverWait(driver, 12)
                .until(ExpectedConditions.elementToBeClickable(filtersOnMainPageMail));
    }
    public void waitFieldPassword(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(fieldPasswordForAutorization));
    }
    public void stepsForAutorization(){
        fillingEmailForAutorization();
        submitEmail();
        waitFieldPassword();
        fillingPasswordForAutorization();
        submitEmail();
        waitFilter();
    }
}
