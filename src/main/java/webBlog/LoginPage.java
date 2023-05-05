package webBlog;

import Web.MyPostsPage;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@type=\"text\"]")
    private WebElement usernameField;
    @FindBy(xpath = "//input[@type=\"password\"]")
    private WebElement passwordField;
    @FindBy(xpath = "//span[@class=\"mdc-button__label\"]")
    private WebElement loginButton;
    public MyPostsPage loginIn(String login, String password) throws InterruptedException {

        usernameField.click();
        usernameField.sendKeys(login);
        passwordField.click();
        passwordField.sendKeys(password);
        loginButton.click();
        Thread.sleep(3000);

        return new MyPostsPage(driver);
    }

    public void login() {
       Assertions.assertTrue(driver.getCurrentUrl().contains("login"));
    }
}


