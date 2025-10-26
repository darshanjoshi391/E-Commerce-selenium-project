package tutorialsninja.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.*;
import java.time.Duration;

public class TC_RF_009
{
    private static final String URL = "jdbc:mysql://localhost:3306/opencart_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";


    @Test
    public void VerifyDataTestRegistration ()
    {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("http://localhost/opencart/");

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        //Passing account information.
        String FirstNameInputData = "Darshan";
        driver.findElement(By.id("input-firstname")).sendKeys(FirstNameInputData);

        String LastNameInputData = "Joshi";
        driver.findElement(By.id("input-lastname")).sendKeys(LastNameInputData);

        String EmailInputData = "darshan007@gmail.com";
        driver.findElement(By.id("input-email")).sendKeys(EmailInputData);

        String PasswordInput = "Darshan@123";
        driver.findElement(By.id("input-password")).sendKeys(PasswordInput);

        driver.findElement(By.id("input-newsletter")).click(); //Enable newsletter toggle button
        driver.findElement(By.name("agree")).click(); // Enable agree toggle buttom.
        driver.findElement(By.xpath("//button[text()='Continue']")).click(); //Clicking on continue button

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String firstNameStoredInDatabase = null;
        String lastNameStoredInDatabase = null;
        String emailStoredInDatabase = null;

        try {
            // Step 1: Establish the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database!");

            // Step 2: Create a statement
            statement = connection.createStatement();

            // Step 3: Execute a query
            String sql = "SELECT * FROM oc_customer";
            resultSet = statement.executeQuery(sql);

            // Step 4: Process the result set
            while (resultSet.next()) {
                firstNameStoredInDatabase = resultSet.getString("firstname");
                lastNameStoredInDatabase = resultSet.getString("lastname");
                emailStoredInDatabase = resultSet.getString("email");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Clean up the resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        Assert.assertEquals(firstNameStoredInDatabase, FirstNameInputData);
        Assert.assertEquals(lastNameStoredInDatabase, LastNameInputData);
        Assert.assertEquals(emailStoredInDatabase, EmailInputData);

        driver.quit();




    }
}
