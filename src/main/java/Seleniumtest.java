import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Seleniumtest
{
    static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\darshan.joshi_adit\\IdeaProjects\\E-Commerce\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");

    }
}
