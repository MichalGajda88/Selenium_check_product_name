package pl.test.java;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;



public class CheckName {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "E:\\Selenium test 2\\driver\\chromedriver.exe"); //select Selenium WebDriver for Chrome
        WebDriver driver = new ChromeDriver(); //create WebDriver instance

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //enter timeouts value

        driver.manage().deleteAllCookies();
        driver.get("https://allegro.pl/"); //get the page
        driver.manage().window().maximize(); //maximize the browser window

        WebElement goToButton = driver.findElement(By.xpath("//button[@class=\"_13q9y _8hkto munh_56_m m7er_k4 m7er_56_m\"]"));
        clickElement(driver,goToButton,10); //close the information window
//        Thread.sleep(2000);

        WebElement category = driver.findElement(By.xpath("//select[@class=\"mr3m_1 m7er_k4 _k70df mgn2_14 mp0t_0a mqu1_21 mgmw_wo mli8_k4 _d25db_an94v\"]")); // find product category pop-up menu

        Select select = new Select(category); //create Select instance
        select.selectByValue("/kategoria/dom-i-ogrod"); //select a category
//        Thread.sleep(2000);

        WebElement searchField = driver.findElement(By.xpath("//input[@type='search']")); //find search field
        searchInput(driver,searchField,"huśtawka",10);
//        Thread.sleep(2000);

        WebElement newProduct = driver.findElement(By.xpath("//span[text()='nowe']"));
        clickElement(driver,newProduct,10); //check only new products filter
//        Thread.sleep(2000);

        WebElement sortList = driver.findElement(By.xpath("//select[@data-value='m']")); //find list of filters

        Select select1 = new Select(sortList);
        select1.selectByValue("qd"); //select to display products by popularity
//        Thread.sleep(2000);

        WebElement page = driver.findElement(By.xpath("//input[@data-role='page-number-input']")); //find page selection field

        searchInput(driver,page,"23",10); //delete and enter new page number
//        Thread.sleep(10000);

        WebElement product = driver.findElement(By.cssSelector("div.main-wrapper:nth-child(3) div.opbox-sheet-wrapper.m7er_k4.munh_56.m3h2_56._26e29_2AYAm.mjru_k4:nth-child(2)" +
                " div.opbox-sheet._26e29_11PCu div.opbox-listing-layout:nth-child(2) " +
                "div._e219d_2xK5A div._1yyhi._e219d_2fgnH:nth-child(2) div._3kk7b._otc6c._19orx._e219d_3S9Lf:nth-child(1) " +
                "div.opbox-sheet-wrapper.m7er_k4.munh_56.m3h2_56._26e29_2AYAm.mjru_ey:nth-child(2) div.opbox-sheet._26e29_11PCu.card._9f0v0.msts_n7" +
                " div.opbox-listing:nth-child(2) div._9c44d_378hD section._9c44d_3pyzl " +
                "div.mpof_ki.mqen_m6.mp7g_oh.mh36_0.mvrt_0.mg9e_8.mj7a_8.m7er_k4._1y62o._9c44d_1I1gg " +
                "div.mpof_ki.myre_zn._9c44d_1Hxbq:nth-child(2) div.m7er_k4._9c44d_3TzmE:nth-child(1) h2.mgn2_14.m9qz_yp.mqu1_16.mp4t_0.m3h2_0.mryx_0.munh_0.mp4t_0.m3h2_0.mryx_0.munh_0 > " +
                "a._w7z6o._uj8z7.meqh_en.mpof_z0.mqu1_16._9c44d_2vTdY")); //find the third product on the list

        String currentName = product.getText(); //get name of the product
//        Thread.sleep(1000);

        driver.quit(); //close WebDriver
        checkName(currentName,"FOTEL WISZĄCY HUŚTAWKA KRZESŁO BRAZYLIJSKIE BUJAK"); //check if the name of the product is as expected
    }

    public static void checkName (String name1, String name2){
        System.out.println("Current product name: " + name1);
        if (name1.equalsIgnoreCase(name2)) {
            System.out.println("Product name is correct");
        } else System.out.println("Product name is incorrect");
    }

    public static void clickElement(WebDriver driver1, WebElement element1, int timeout){
        new WebDriverWait(driver1,timeout).until(ExpectedConditions.visibilityOf(element1));
        element1.click();
    }

    public static void searchInput (WebDriver driver1, WebElement field, String value, int timeout){
        new WebDriverWait(driver1, timeout).until(ExpectedConditions.visibilityOf(field));
        field.clear();
        field.sendKeys(value, Keys.ENTER);
    }
}
