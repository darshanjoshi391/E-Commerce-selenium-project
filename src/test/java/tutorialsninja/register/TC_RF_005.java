package tutorialsninja.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class TC_RF_005
{
    @Test
    public  void PasswordConfirmation ()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://tutorialsninja.com/demo/");

        driver.findElement(By.xpath("//span[text()='My Account']")).click(); //Xpath
        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.id("input-firstname")).sendKeys("Darshan");
        driver.findElement(By.id("input-lastname")).sendKeys("Joshi");
        driver.findElement(By.id("input-email")).sendKeys(GenerateEmail());
        driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
        driver.findElement(By.id("input-password")).sendKeys("Darshan123");
        driver.findElement(By.id("input-confirm")).sendKeys("Darshan");
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

        //Verifying Password warning message.
        String ExpectedWarningPass = "Password confirmation does not match password!";
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-confirm']/following-sibling::div")).getText(), ExpectedWarningPass);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }

    public static String GenerateEmail()
    {
        return new Date().toString().replaceAll("\\s" , "").replaceAll("\\:" , "")+ "@gmail.com";
    }

}
