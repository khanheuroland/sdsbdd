package bdddemo;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SingInStepsDefinition {
    WebDriver driver;
    @Before
    public void setupTest()
    {
        //Test on chrome
        //this.driver = new ChromeDriver();
        //Neu muon test tren firefox
        this.driver = new FirefoxDriver();
        //safari
        //this.driver = new SafariDriver();

        this.driver.manage().window().maximize();
    }

    @After
    public void finishTest()
    {
        this.driver.quit();
    }
    @Given("The sign in page is showed")
    public void the_sign_in_page_is_showed() {
        this.driver.get("https://fado.vn/dang-nhap");
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); //cho cho page load thanh cong trong 15s
    }
    @When("The user attempt to sign in with invalid email format")
    public void the_user_attempt_to_sign_in_with_invalid_email_format() {
        WebElement tbEmail = this.driver.findElement(By.xpath("//input[@id=\"auth-block__form-group__email\"]"));
        WebElement tbPassword = this.driver.findElement(By.xpath("//input[@data-test-login-password]"));
        WebElement btnSignIn = this.driver.findElement(By.xpath("//button[@data-test-login-btn-submit]"));

        tbEmail.sendKeys("khanh123@5462345");
        tbPassword.sendKeys("abc1234");

        btnSignIn.click();

    }
    @Then("The message {string} will be showed.")
    public void the_message_will_be_showed(String message) throws InterruptedException {
        Thread.sleep(1000); //Should be replaced by explicit wait
        WebElement txtMessage = this.driver.findElement(By.cssSelector("div.my-alert"));
        String errorMsg = txtMessage.getText().split("\n")[1];

        assertThat(errorMsg, equalTo(message));
    }

    @Given("Mở trang Sign In")
    public void mo_trang_sign_in() {
        this.driver.get("https://fado.vn/dang-nhap");
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); //cho cho page load thanh cong trong 15s
    }
    @When("Khi người dùng thực hiện sign in với username và password rỗng")
    public void khi_nguoi_dung_thuc_hien_sign_in_voi_username_va_password_rong() {
        WebElement btnSignIn = this.driver.findElement(By.xpath("//button[@data-test-login-btn-submit]"));
        btnSignIn.click();
    }
    @Then("Thông báo {string} sẽ hiển thị bên dưới.")
    public void thong_bao_se_hien_thi_ben_duoi(String msg) {
        WebElement lbEmailError = this.driver.findElement(By.xpath("//label[@id=\"auth-block__form-group__email-error\"]"));
        WebElement lbPasswordError = this.driver.findElement(By.xpath("//label[@id=\"password-error\"]"));

        assertThat(lbEmailError.getText(), equalTo(msg));
        assertThat(lbPasswordError.getText(), equalTo(msg));
    }


    @When("Người dùng thực hiện sign in với username {string} và mật khẩu {string}")
    public void nguoi_dung_thuc_hien_sign_in_voi_username_va_mat_khau(String username, String password) {
        WebElement tbEmail = this.driver.findElement(By.xpath("//input[@id=\"auth-block__form-group__email\"]"));
        WebElement tbPassword = this.driver.findElement(By.xpath("//input[@data-test-login-password]"));
        WebElement btnSignIn = this.driver.findElement(By.xpath("//button[@data-test-login-btn-submit]"));

        tbEmail.sendKeys(username);
        tbPassword.sendKeys(password);

        btnSignIn.click();
    }
    @Then("Thông báo {string} sẽ hiển thị")
    public void thong_bao_se_hien_thi(String msg) throws InterruptedException {
        Thread.sleep(1000); //Should be replaced by explicit wait
        WebElement txtMessage = this.driver.findElement(By.cssSelector("div.my-alert"));
        String errorMsg = txtMessage.getText().split("\n")[1];

        assertThat(errorMsg, equalTo(msg));
    }
}
