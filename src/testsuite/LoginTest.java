package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";
    @Before
    public void openBrowser(){
        setUpBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
// click on the ‘Sign In’ link
        driver.findElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]")).click();
//Verify the text ‘Welcome Back!’
        String expectedText = "Welcome Back!";
        String actualText =driver.findElement(By.xpath("//h1[contains(text(),'Welcome Back!')]")).getText();
        System.out.println(actualText);
        Assert.assertEquals(expectedText,actualText);
    }


@Test
public void verifyTheErrorMessage(){
// click on the ‘Sign In’ link
   driver.findElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]")).click();
// Enter invalid username
    WebElement inValidUserName =driver.findElement(By.id("user[email]"));
    inValidUserName.sendKeys("xyz123@gmail.com");
// Enter invalid password
    WebElement inValidPassword =driver.findElement(By.id("user[password]"));
    inValidPassword.sendKeys("abc");
// Click on Login button
    driver.findElement(By.xpath("//input[@type='submit']")).click();
   // driver.findElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]")).click();
// Verify the error message ‘Invalid email or password.
    String expectedErrorMsg = "Invalid email or password.";
    String actualErrorMsg = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]")).getText();
    System.out.println(actualErrorMsg);
    Assert.assertEquals(expectedErrorMsg,actualErrorMsg);
}
@After
    public void teRDown(){
closeBrowser();
}
}
