package bdddemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@id=\"auth-block__form-group__email\"]")
    public WebElement tbEmail;
    @FindBy(xpath = "//input[@data-test-login-password]")
    public WebElement tbPassword;
    @FindBy(xpath = "//button[@data-test-login-btn-submit]")
    public WebElement btnSignIn;

    By messageLoc = By.cssSelector("div.my-alert");
    By errorEmailLoc = By.xpath("//label[@id=\"auth-block__form-group__email-error\"]");
    By errorPasswordLoc = By.xpath("//label[@id=\"password-error\"]");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void OpenSignInPage() {
        this.driver.get("https://fado.vn/dang-nhap");
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public String getErrorMessage()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement lbError = wait.until(ExpectedConditions.visibilityOfElementLocated(messageLoc));
        return lbError.getText().split("\n")[1];
    }

    public String getEmailError()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement lbError = wait.until(ExpectedConditions.visibilityOfElementLocated(errorEmailLoc));
        return lbError.getText();
    }

    public String getPasswordError()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement lbError = wait.until(ExpectedConditions.visibilityOfElementLocated(errorPasswordLoc));
        return lbError.getText();
    }
}
