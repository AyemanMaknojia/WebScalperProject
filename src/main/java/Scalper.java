import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Scalper {
    public static void main(String[] args) throws InterruptedException {
        // initializing the browser which will be launched. in this case chrome
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/home/ayeman/chromedriver.exe");
        //get the amazon link to open on the web driver
        //driver.get("https://www.amazon.com/Keeper-Lost-Cities-Collection-Messenger/dp/9124126144/ref=sr_1_1?crid=3KPNGMUM6VRBS&keywords=keeper+of+the+lost+cities+series&qid=1677516487&s=books&sprefix=keeper+of+lost+ci%2Cstripbooks%2C92&sr=1-1");
        driver.get("https://www.amazon.com/Xbox-X/dp/B08H75RTZ8/ref=sr_1_2?crid=1GCC0N20FNF09&keywords=x%2Bboxes%2Bseries%2Bx&qid=1678372259&s=videogames&sprefix=x%2Bbox%2Cvideogames%2C107&sr=1-2&th=1");
        //stop thread for 1 second
        Thread.sleep(1000);
        // while loop will keep going until it reaches the iof statement
        boolean y = true;
        while (y) {
            //if submit.add-to-cart is present in the page source then press the add to cart button and quit the driver
            if (driver.getPageSource().contains("submit.add-to-cart")) {
                driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                //automates a click to the add to cart button
                driver.findElement(By.id("add-to-cart-button")).click();
                //sleep for 3 seconds, then quit the driver
                Thread.sleep(500);
                driver.quit();
                //break;
            }
            //driver will refresh until there is an add to cart button present, or the user manually switches it off.
            else
            {
                Thread.sleep(500);
                driver.navigate().refresh();
            }
        }
    }
}

