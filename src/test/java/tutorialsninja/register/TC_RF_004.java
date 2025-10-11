package tutorialsninja.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_RF_004
{
    @Test
    public void VerifyWarningMessage ()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://tutorialsninja.com/demo/");

        driver.findElement(By.xpath("//span[text()='My Account']")).click(); //Xpath
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

        String ExpectedFirstNameWarningMessage = "First Name must be between 1 and 32 characters!";
        String ExpectedSecondNameWarningMessage = "Last Name must be between 1 and 32 characters!";
        String ExpectedEmailWaringMessage = "E-Mail Address does not appear to be valid!";
        String ExpctedTelephoneWarningMessage = "Telephone must be between 3 and 32 characters!";
        String ExpectedPasswordWarningMessage = "Password must be between 4 and 20 characters!";
        String PrivacyPolicyWarningMessage = "Warning: You must agree to the Privacy Policy!";

        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(),ExpectedFirstNameWarningMessage);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(),ExpectedSecondNameWarningMessage);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText(),ExpectedEmailWaringMessage);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(),ExpctedTelephoneWarningMessage);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(),ExpectedPasswordWarningMessage);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(),PrivacyPolicyWarningMessage);

        driver.quit();
    }

}
