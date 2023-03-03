import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Scalper {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/home/ayeman/chromedriver.exe");
        driver.get("https://www.amazon.com/Keeper-Lost-Cities-Collection-Messenger/dp/9124126144/ref=sr_1_1?crid=3KPNGMUM6VRBS&keywords=keeper+of+the+lost+cities+series&qid=1677516487&s=books&sprefix=keeper+of+lost+ci%2Cstripbooks%2C92&sr=1-1");
        Thread.sleep(1000);
        String x = driver.findElement(By.id("submit.add-to-cart")).getText();
        boolean y = true;
        while(y)
        {
            if(x != null && !x.trim().isEmpty())
            {
                driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                driver.findElement(By.id("add-to-cart-button")).click();
                Thread.sleep(3000);
                driver.quit();
                break;
            }
            else
            {
                Thread.sleep(3000);
                driver.navigate().refresh();
            }
        }
    }
}
