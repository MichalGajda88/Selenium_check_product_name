package pl.test.java;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckName {


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "E:\\Selenium test 2\\driver\\chromedriver.exe"); //select Selenium WebDriver for Chrome
        WebDriver driver = new ChromeDriver(); //create WebDriver instance
        Actions action = new Actions(driver);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //enter timeouts value

        driver.manage().deleteAllCookies();
        driver.get("https://allegro.pl/"); //get the page
        driver.manage().window().maximize(); //maximize the browser window

        WebElement goToButton = driver.findElement(By.cssSelector("body > div.main-wrapper > div:nth-child(8) > div > div._1yyhi >" +
                " div > div._9f0v0._jkrtd.mpof_ki_s > button._13q9y._8hkto.munh_56_m.m7er_k4.m7er_56_m"));
        action.moveToElement(goToButton).click().perform(); //close the information window
//        Thread.sleep(2000);

        WebElement category = driver.findElement(By.cssSelector("body > div.main-wrapper > div:nth-child(2) > header > div >" +
                " div > div > div > form > div.mpof_5r.mpof_ki_s.mp7g_oh.m389_6m.mjyo_6x.mse2_40.mp4t_0.mr3m_0.mli2_0.m911_co.mnyp_co.mdwl_co.mx7m_1.mefy_5r.mlkp_ag.msts_9u._d25db_1Qn1q >" +
                " div > select")); // find product category pop-up menu

        Select select = new Select(category); //create Select instance
        select.selectByValue("/kategoria/dom-i-ogrod"); //select a category
//        Thread.sleep(2000);

        WebElement searchField = driver.findElement(By.cssSelector("body > div.main-wrapper > div:nth-child(2) > header > div > " +
                "div > div > div > form > input")); //find search field
        WebElement searchButton = driver.findElement(By.cssSelector("body > div.main-wrapper > div:nth-child(2) > header > div > " +
                "div > div > div > form > button")); // find search button

        action.moveToElement(searchField).click().sendKeys("huśtawka").perform(); //enter searching phrase in the search field
//        Thread.sleep(2000);
        action.moveToElement(searchButton).click().perform(); //hover and click on search button
//        Thread.sleep(2000);

        WebElement newProduct = driver.findElement(By.cssSelector("body > div.main-wrapper > div:nth-child(4) > div > div > div > " +
                "div > div > div._1yyhi._e219d_2fgnH > div._3kk7b._n1rmb._1t6t8._e219d_1YFA5._e219d_2A8fy > div:nth-child(1) > " +
                "div:nth-child(3) > div > div > div > div > div > fieldset:nth-child(3) > div > ul > li:nth-child(1) > label"));
        action.moveToElement(newProduct).click().perform(); //check only new products filter
//        Thread.sleep(2000);

        WebElement sortList = driver.findElement(By.cssSelector("body > div.main-wrapper > div:nth-child(4) > div > div > div > div >" +
                " div > div._1yyhi._e219d_2fgnH > div._3kk7b._otc6c._19orx._e219d_3S9Lf > div._e219d_jjqRf > div._e219d_1LGAZ > " +
                "div > div > div > div > select")); //find list of filters

        Select select1 = new Select(sortList);
        select1.selectByValue("qd"); //select to display products by popularity
//        Thread.sleep(2000);

        WebElement page = driver.findElement(By.cssSelector("body > div.main-wrapper > div:nth-child(4) > div > div > div > " +
                "div > div > div._1yyhi._e219d_2fgnH > div._3kk7b._otc6c._19orx._e219d_3S9Lf > div._e219d_jjqRf > div._e219d_2dKPf > " +
                "div > div > div > div > div > input")); //find page selection field

        action.moveToElement(page).click().sendKeys(Keys.DELETE).sendKeys("23").sendKeys(Keys.ENTER).perform(); //delete and enter new page number
        Thread.sleep(1000);

        WebElement product = driver.findElement(By.cssSelector("body > div.main-wrapper > div:nth-child(4) > div > div > div > div > div > " +
                "div._1yyhi._e219d_2fgnH > div._3kk7b._otc6c._19orx._e219d_3S9Lf > div:nth-child(3) > div:nth-child(1) > div > div > " +
                "div:nth-child(2) > div.opbox-listing > div > section > article:nth-child(4) > div > div.mpof_ki.myre_zn._9c44d_1Hxbq > " +
                "div.m7er_k4._9c44d_3TzmE > h2 > a")); //find the product

        String currentName = product.getText(); //get name of the product
//        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver; //create JS instance
        js.executeScript("window.scrollBy(0,1000)"); //scroll down the page
//        Thread.sleep(2000);

        driver.quit(); //close WebDriver
        System.out.println(currentName); //print current name of the product
        String expectedName = "Uchwyt Hak Mocowanie do huśtawki z karabińczykiem"; //expected name of the product

        if (currentName.equalsIgnoreCase(expectedName)) {
            System.out.println("Product name is correct");
        } else System.out.println("Product name is incorrect"); //check if the name of the product is as expected
    }
}
