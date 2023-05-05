package webBlog;



import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyPostsPage extends AbstractPage {
    public MyPostsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[@class='svelte-1rc85o5']")// Раздел Home  в хедере
    private WebElement homeHeader;
    @FindBy(xpath = "//a[@href and text() = 'Next Page']")//next page
    private WebElement NextPage;
    @FindBy(xpath = "//a[@href and text() = 'Previous Page']")//Previous Page
    private WebElement PreviousPage;
    @FindBy(xpath = "//div[@class = 'content']/div/a[1]/div")//предыдущая страница
    private WebElement disabledPreviousPage;
    public void checkChangeUrl() throws InterruptedException {
        ExpectedConditions.visibilityOf(homeHeader);
//      ExpectedConditions.visibilityOf(InHerders);
        Assertions.assertFalse(driver.getCurrentUrl().contains("login"));
    }
    public MyPostsPage toNextPage() {
        NextPage.click();
        return this;
    }
    public void nextPage() throws InterruptedException {
        Thread.sleep(2000);
        ExpectedConditions.elementToBeClickable(PreviousPage);
        Assertions.assertTrue(PreviousPage.isEnabled());
    }
    public MyPostsPage moveToPreviousPage() throws InterruptedException {
        NextPage.click();
        Thread.sleep(2000);
        ExpectedConditions.elementToBeClickable(PreviousPage);
        PreviousPage.click();
        return this;
    }
    public MyPostsPage goToPreviousPage() {
        Assertions.assertTrue(disabledPreviousPage.isEnabled());
        return this;
    }
}
