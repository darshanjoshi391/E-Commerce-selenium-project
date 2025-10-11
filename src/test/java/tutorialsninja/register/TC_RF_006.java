package tutorialsninja.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_RF_006
{
    @Test
    public void ExstingEmailAddress ()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        driver.get("https://tutorialsninja.com/demo/");

        driver.findElement(By.xpath("//span[text()='My Account']")).click(); //Xpath
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("Darshan");
        driver.findElement(By.id("input-lastname")).sendKeys("Joshi");
        driver.findElement(By.id("input-email")).sendKeys("darshan123@gmail.com");
        driver.findElement(By.id("input-telephone")).sendKeys("7894561230");
        driver.findElement(By.id("input-password")).sendKeys("1234");
        driver.findElement(By.id("input-confirm")).sendKeys("1234");
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

        String ExpectedwarningMessage = "Warning: E-Mail Address is already registered!";
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(),ExpectedwarningMessage);

        try
        {
            Thread.sleep(3000);
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }

        driver.quit();


    }

}
