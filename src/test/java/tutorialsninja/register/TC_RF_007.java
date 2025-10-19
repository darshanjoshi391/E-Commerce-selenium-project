package tutorialsninja.register;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CommonUtils;

import java.time.Duration;
import java.util.Date;

public class TC_RF_007
{
    @Test
    public void KeyboardKeys ()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        driver.get("https://tutorialsninja.com/demo/");

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        //Pressing tab key for moving on first name field.
        Actions actions = new Actions(driver);

        for (int i=1; i<=23; i++)
        {
            actions.sendKeys(Keys.TAB).perform();
        }

        actions.sendKeys("Darsh").pause(Duration.ofSeconds(1));
        actions.sendKeys(Keys.TAB).perform();

        actions.sendKeys("New").pause(Duration.ofSeconds(1));
        actions.sendKeys(Keys.TAB).perform();

        actions.sendKeys(CommonUtils.GenerateEmail()).pause(Duration.ofSeconds(1));
        actions.sendKeys(Keys.TAB).perform();

        actions.sendKeys("1234657890").pause(Duration.ofSeconds(1));
        actions.sendKeys(Keys.TAB).perform();

        actions.sendKeys("ABCDEF").pause(Duration.ofSeconds(1));
        actions.sendKeys(Keys.TAB).perform();

        actions.sendKeys("ABCDEF").pause(Duration.ofSeconds(1));

        actions.sendKeys(Keys.TAB).perform();

        //actions.sendKeys(Keys.TAB).perform();

        actions.sendKeys(Keys.ARROW_LEFT).perform();

        actions.sendKeys(Keys.TAB).perform();

        actions.sendKeys(Keys.TAB).perform();

        actions.sendKeys(Keys.SPACE).perform();

        actions.sendKeys(Keys.TAB).perform();

        actions.sendKeys(Keys.ENTER).perform();

        String ExpectedText = "Success";
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='column-right']//a[text()='Logout']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());

        driver.quit();





    }

}
