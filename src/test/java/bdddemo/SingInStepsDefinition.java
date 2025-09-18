package bdddemo;

import bdddemo.pageobjects.SignInPage;
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
    SignInPage signInPage;

    @Before
    public void setupTest() {
        //Test on chrome
        //this.driver = new ChromeDriver();
        //Neu muon test tren firefox
        this.driver = new FirefoxDriver();
        //safari
        //this.driver = new SafariDriver();
        this.signInPage = new SignInPage(driver);

        this.driver.manage().window().maximize();
    }

    @After
    public void finishTest() {
        this.driver.quit();
    }

    @Given("The sign in page is showed")
    public void the_sign_in_page_is_showed() {
        this.signInPage.OpenSignInPage();
    }

    @When("The user attempt to sign in with invalid email format")
    public void the_user_attempt_to_sign_in_with_invalid_email_format() {
        this.signInPage.tbEmail.sendKeys("khanh123@5462345");
        this.signInPage.tbPassword.sendKeys("abc1234");
        this.signInPage.btnSignIn.click();
    }

    @Then("The message {string} will be showed.")
    public void the_message_will_be_showed(String message) {
        assertThat(this.signInPage.getErrorMessage(), equalTo(message));
    }

    @Given("Mở trang Sign In")
    public void mo_trang_sign_in() {
        this.signInPage.OpenSignInPage();
    }

    @When("Khi người dùng thực hiện sign in với username và password rỗng")
    public void khi_nguoi_dung_thuc_hien_sign_in_voi_username_va_password_rong() {
        this.signInPage.btnSignIn.click();
    }

    @Then("Thông báo {string} sẽ hiển thị bên dưới.")
    public void thong_bao_se_hien_thi_ben_duoi(String msg) {
        assertThat(this.signInPage.getEmailError(), equalTo(msg));
        assertThat(this.signInPage.getPasswordError(), equalTo(msg));
    }


    @When("Người dùng thực hiện sign in với username {string} và mật khẩu {string}")
    public void nguoi_dung_thuc_hien_sign_in_voi_username_va_mat_khau(String username, String password) {
        this.signInPage.tbEmail.sendKeys(username);
        this.signInPage.tbPassword.sendKeys(password);

        this.signInPage.btnSignIn.click();
    }

    @Then("Thông báo {string} sẽ hiển thị")
    public void thong_bao_se_hien_thi(String msg) throws InterruptedException {
        assertThat(this.signInPage.getErrorMessage(), equalTo(msg));
    }
}
