import Utilities.BaseDriver;
import Utilities.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class US8 extends BaseDriver {
    @Test
    public void US8(){
        js.executeScript("window.scrollBy(0, 6000);");

        WebElement checkBox= driver.findElement(By.xpath("//label[contains(@class,'checkbox')]//span"));
        Actions action= new Actions(driver);
        action.click(checkBox).build().perform();

        WebElement kullanimSartlari1= driver.findElement(By.xpath("//div[@field='text']"));
        Assert.assertTrue(kullanimSartlari1.isDisplayed());

    }
}
