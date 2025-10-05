package tutorialsninja.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.internal.Debug;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class TC_RF_001
{
    @Test

    static void RegisterPage()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));  //Giving for to make sure attributes should be load.
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");

        driver.findElement(By.xpath("//span[text()='My Account']")).click(); //Xpath
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("Darshan");
        driver.findElement(By.id("input-lastname")).sendKeys("Joshi");
        driver.findElement(By.id("input-email")).sendKeys(GenerateEmail());
        driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
        driver.findElement(By.id("input-password")).sendKeys("Darshan123");
        driver.findElement(By.id("input-confirm")).sendKeys("Darshan123");
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
        String ExpectedHeading = "Your Account Has Been Created!";
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id = 'common-success']//h1")).getText(), ExpectedHeading);

        String actualproperdetailone = "Congratulations! Your new account has been successfully created!";
        String actualproperdetailtwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
        String actualproperdetailsthree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
        String actualproperdetailsfour = "contact us";

        String expectedproperdetails = driver.findElement(By.id("content")).getText();

        Assert.assertTrue(expectedproperdetails.contains(actualproperdetailone));
        Assert.assertTrue(expectedproperdetails.contains(actualproperdetailtwo));
        Assert.assertTrue(expectedproperdetails.contains(actualproperdetailsthree));
        Assert.assertTrue(expectedproperdetails.contains(actualproperdetailsfour));


        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

        driver.quit();

    }

    public static String GenerateEmail ()
    {
        return new Date().toString().replaceAll("\\s", "").replaceAll("\\:" , "")+"@gmail.com";
    }
}

