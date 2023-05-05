package webBlog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyPostsTest extends AbstractTest {
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
    public void page1() throws InterruptedException {
        loginPage.loginIn(username, password);
        myPostsPage.moveToPreviousPage();
        myPostsPage.goToPreviousPage();
    }

    @Test
    public void page2() throws InterruptedException {
        loginPage.loginIn(username,password);
        myPostsPage.toNextPage();
        myPostsPage.nextPage();
    }
}
