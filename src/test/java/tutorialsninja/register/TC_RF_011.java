package tutorialsninja.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_RF_011 {
    @Test
    public void verifyRegisterAccountPageElements() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        //Verifying breadcrumb on page
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class = 'breadcrumb']//a[text()='Account']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class = 'breadcrumb']//a[text()='Register']")).isDisplayed());

        //Verifying page header
        String expectedHeading = "Register Account";
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id = 'content']/h1")).getText(), expectedHeading);

        //Verifying page URL
        String expectedURL = "https://tutorialsninja.com/demo/index.php?route=account/register";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        //Verifying Chrome Tab title
        String TabHeader = "Register Account";
        Assert.assertEquals(driver.getTitle(), TabHeader);

        driver.quit();

    }
}
