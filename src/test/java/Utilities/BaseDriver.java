package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseDriver {
    public  WebDriver driver;
    public  WebDriverWait wait;
    public  JavascriptExecutor js;

    @BeforeClass
    @Parameters("browserTipi")
    public void BaslangicIslemleri(String browserTipi){

        switch (browserTipi.toLowerCase())
        {
            case "firefox": driver=new FirefoxDriver();break;
            default: driver=new ChromeDriver();
        }


        System.out.println("Başlangıç işlemleri yapılıyor");
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        js=(JavascriptExecutor)driver;

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        login();

    }

    @AfterClass
    public void KapanisIslemleri(){
        System.out.println("Kapanış işlemleri yapılıyor");
        Tools.Bekle(2);
        driver.quit();
    }

    public void login(){
        driver.get("https://techno.study/tr/");
        Tools.Bekle(2);
    }
}
