package tutorialsninja.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CommonUtils;

import java.time.Duration;

public class TC_RF_013
{
    @Test (dataProvider = "EnvironemntSupplying")
    public void VerifyRegisterAccountDifferentEnv (String env)
    {
        String browswerName = env;

        WebDriver driver = null;

        if (browswerName.equals("chrome"))
        {
            driver = new ChromeDriver();
        }
        else if (browswerName.equals("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else if (browswerName.equals("Edge"))
        {
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://tutorialsninja.com/demo/");


        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("Darshan");
        driver.findElement(By.id("input-lastname")).sendKeys("Joshi");
        driver.findElement(By.id("input-email")).sendKeys(CommonUtils.GenerateEmail());
        driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
        driver.findElement(By.id("input-password")).sendKeys("1234567");
        driver.findElement(By.id("input-confirm")).sendKeys("1234567");
        driver.findElement(By.xpath("//input[@name='newsletter'][@value=1]")).click();
        driver.findElement(By.xpath("//input[@name='agree']")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();


        //Verifying breadcrumb on register page
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class = 'breadcrumb']//a[text()='Success']")).isDisplayed());

        //Clicking on continoue button
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        Assert.assertEquals(driver.getTitle(), "My Account");

        driver.quit();
    }

    @DataProvider (name = "EnvironemntSupplying")
    public Object[][] passTestEnvironment ()
    {
        Object [][] envs = {{"chrome"},{"firefox"}, {"Edge"}};
        return envs;

    }
}
