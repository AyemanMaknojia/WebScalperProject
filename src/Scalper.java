import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Scalper {
    public static void main(String[] args) throws InterruptedException {
        // initializing the browser which will be launched. in this case chrome
        WebDriver driver=new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/home/ayeman/chromedriver.exe");
        //get the amazon link to open on the web driver
        driver.get("https://www.amazon.com/Keeper-Lost-Cities-Collection-Messenger/dp/9124126144/ref=sr_1_1?crid=3KPNGMUM6VRBS&keywords=keeper+of+the+lost+cities+series&qid=1677516487&s=books&sprefix=keeper+of+lost+ci%2Cstripbooks%2C92&sr=1-1");
        //stop thread for 1 second
        Thread.sleep(1000);
        // store html id 'submit.add-to-cart' as text, lets the code know wether there is an add to cart button or not.
        String x = driver.findElement(By.id("submit.add-to-cart")).getText();
        boolean y = true;
        while(y)
        {
            //if the string x is not null, as in there is an add to cart button, the code inside the for loop will run
            if(x != null && !x.trim().isEmpty())
            {
                driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                //automates a click to the add to cart button
                driver.findElement(By.id("add-to-cart-button")).click();
                //sleep for 3 seconds, then quit the driver
                Thread.sleep(3000);
                driver.quit();
                break;
            }
            else
            {
                Thread.sleep(3000);
                //driver will refresh until there is an add to cart button present, or the user manually switches it off.
                driver.navigate().refresh();
            }
        }
    }
}
