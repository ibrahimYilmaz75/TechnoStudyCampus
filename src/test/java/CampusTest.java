import Utilities.BaseDriver;
import Utilities.Tools;
import com.google.j2objc.annotations.Property;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
 1. "Kendi Kursunu Seç" bölümünde her kursun altında "Detaylı Bilgi" veya "More Info" gibi bir
buton veya bağlantı görünmelidir.
2. "Detaylı Bilgi" butonuna tıkladığımda, ilgili kursun ayrıntılı bilgi ve içeriklerinin bulunduğu
kurs sayfasına yönlendirilmelidir.
3. İçeriklerin bulunduğu kursa sayfasında Techno Study logosu olmalıdır
* */
public class CampusTest extends BaseDriver {
    @Test
    public void SDET(){
        // 2000 pixel aşağıya scroll yap
        js.executeScript("window.scrollBy(0, 2000);");

        // Detaylı Bilgi butonuna tıklat
        WebElement detayliBilgiSdet= driver.findElement(By.xpath("(//a[text()='Detaylı bilgi'])[2]"));
        detayliBilgiSdet.click();

        // Sayfaya girince "Yazılım Test Uzmanı" yazısını görünceye kadar bekle ve doğrula
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        WebElement yazilimTestUzmani= driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(yazilimTestUzmani.getText().contains("YAZILIM\n" +
                "TEST UZMANI"),"Yazılım Test Uzmanı sayfasına ulaşamadı");
        // Logo sayfada görünüyor mu kontrol et
        WebElement Logo= driver.findElement(By.xpath("//div[contains(@class,'_leftside')]//img"));
        Assert.assertTrue(Logo.isDisplayed());


    }
    @Test
    public void android(){
        // Geri çık
        driver.navigate().back();

        // Detaylı Bilgi butonuna tıklat
        WebElement detayliBilgiAndroid= driver.findElement(By.xpath("(//a[text()='Detaylı bilgi'])[3]"));
        detayliBilgiAndroid.click();

        // Detaylı bilgi butonu görünene kadar bekle ve tıklat
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@data-elem-type='button'])[1]//a")));
        WebElement detayliBilgiAndroid1= driver.findElement(By.xpath("(//div[@data-elem-type='button'])[1]//a"));
        Actions actions= new Actions(driver);
        actions.click(detayliBilgiAndroid1).build().perform();

        // Sayfaya girince "Android Uygulama Geliştirme" yazısını görünceye kadar bekle ve doğrula
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='Android Uygulama Geliştirme']")));
        WebElement android= driver.findElement(By.xpath("//strong[text()='Android Uygulama Geliştirme']"));
        Assert.assertTrue(android.getText().contains("Android Uygulama Geliştirme"),"Andorid uygulama geliştiricisi sayfasına ulaşamadı");

        // Logo sayfada görünüyor mu kontrol et
        WebElement Logo= driver.findElement(By.xpath("//div[contains(@class,'_leftside')]//img"));
        Assert.assertTrue(Logo.isDisplayed());
    }
    @Test
    public void veriBilimi(){
        // 2 sayfa geri çık
        driver.navigate().back();
        driver.navigate().back();

        // Detaylı Bilgi butonuna tıklat
        WebElement detayliBilgiAndroid= driver.findElement(By.xpath("(//a[text()='Detaylı bilgi'])[1]"));
        detayliBilgiAndroid.click();

        // Detaylı bilgi butonu görünene kadar bekle ve tıklat
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@data-elem-type='button'])[1]//a")));
        WebElement detayliBilgiVeri= driver.findElement(By.xpath("(//div[@data-elem-type='button'])[1]//a"));
        Actions actions= new Actions(driver);
        actions.click(detayliBilgiVeri).build().perform();

        // Sayfaya girince "Android Uygulama Geliştirme" yazısını görünceye kadar bekle ve doğrula
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h2)[1]")));
        WebElement veriBilimi= driver.findElement(By.xpath("(//h2)[1]"));
        Assert.assertTrue(veriBilimi.getText().contains("Techno Study ile Veri Bilimci Olun"),"Yazılım Test Uzmanı sayfasına ulaşamadı");

        // Logo sayfada görünüyor mu kontrol et
        WebElement Logo= driver.findElement(By.xpath("//div[contains(@class,'_leftside')]//img"));
        Assert.assertTrue(Logo.isDisplayed());


    }
}
