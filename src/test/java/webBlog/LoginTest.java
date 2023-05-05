package webBlog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest extends AbstractTest {
    LoginPage loginPage;
    MyPostsPage myPostsPage;
    PostPage postPage;
    protected String username = "active";
    protected String password = "c76a5e84e4";

    @BeforeEach
    void init() {
        loginPage = new LoginPage(getWebDriver());
        myPostsPage = new MyPostsPage(getWebDriver());
        postPage = new PostPage(getWebDriver());
    }

    @Test
    public void loginValid1() throws InterruptedException {
        loginPage.loginIn(username,password);
        myPostsPage.checkChangeUrl();
    }

    @Test
    public void loginInvalid() throws InterruptedException {
        loginPage.loginIn("activ","c76a5e84e4");
        myPostsPage.checkChangeUrl();
    }

    @Test
    public void loginValid2() throws InterruptedException {
        loginPage.loginIn("rol","875b854107");
        myPostsPage.checkChangeUrl();
    }

    @Test
    public void loginNegativ1() throws InterruptedException {
        loginPage.loginIn("Yu","385d04e768");
        myPostsPage.checkChangeUrl();
    }

    @Test
    public void loginNegativ2() throws InterruptedException {
        loginPage.loginIn("qwertyuiopasdfghjkllz","f2ce2d406c");
        myPostsPage.checkChangeUrl();
    }
}
