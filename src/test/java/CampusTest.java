import Utilities.BaseDriver;
import Utilities.Tools;
import com.google.j2objc.annotations.Property;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CampusTest extends BaseDriver {
    @Test
    public void SDET(){
        //
        js.executeScript("window.scrollBy(0, 2000);");
        WebElement detayliBilgiSdet= driver.findElement(By.xpath("(//a[text()='Detaylı bilgi'])[2]"));
        detayliBilgiSdet.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        WebElement yazilimTestUzmani= driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(yazilimTestUzmani.getText().contains("YAZILIM\n" +
                "TEST UZMANI"),"Yazılım Test Uzmanı sayfasına ulaşamadı");
        WebElement resim= driver.findElement(By.xpath("//div[contains(@class,'_leftside')]//img"));
        Assert.assertTrue(resim.isDisplayed());


    }
    @Test
    public void android(){
        driver.navigate().back();
        WebElement detayliBilgiAndroid= driver.findElement(By.xpath("(//a[text()='Detaylı bilgi'])[3]"));
        detayliBilgiAndroid.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@data-elem-type='button'])[1]//a")));
        WebElement detayliBilgiAndroid1= driver.findElement(By.xpath("(//div[@data-elem-type='button'])[1]//a"));
        Actions actions= new Actions(driver);
        actions.click(detayliBilgiAndroid1).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='Android Uygulama Geliştirme']")));
        WebElement android= driver.findElement(By.xpath("//strong[text()='Android Uygulama Geliştirme']"));
        Assert.assertTrue(android.getText().contains("Android Uygulama Geliştirme"),"Andorid uygulama geliştiricisi sayfasına ulaşamadı");
        WebElement resim= driver.findElement(By.xpath("//div[contains(@class,'_leftside')]//img"));
        Assert.assertTrue(resim.isDisplayed());
    }
    @Test
    public void veriBilimi(){
        driver.navigate().back();
        driver.navigate().back();
        WebElement detayliBilgiAndroid= driver.findElement(By.xpath("(//a[text()='Detaylı bilgi'])[1]"));
        detayliBilgiAndroid.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@data-elem-type='button'])[1]//a")));
        WebElement detayliBilgiAndroid1= driver.findElement(By.xpath("(//div[@data-elem-type='button'])[1]//a"));
        Actions actions= new Actions(driver);
        actions.click(detayliBilgiAndroid1).build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h2)[1]")));
        WebElement veriBilimi= driver.findElement(By.xpath("(//h2)[1]"));
        Assert.assertTrue(veriBilimi.getText().contains("Techno Study ile Veri Bilimci Olun"),"Yazılım Test Uzmanı sayfasına ulaşamadı");

        WebElement resim= driver.findElement(By.xpath("//div[contains(@class,'_leftside')]//img"));
        Assert.assertTrue(resim.isDisplayed());


    }
}
