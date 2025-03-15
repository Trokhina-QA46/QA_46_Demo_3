package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XpathSelectors {
    WebDriver driver = new ChromeDriver();

    @Test
    public void selectorsTextBox() {
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        hideBanner();
        hideFooter();
        WebElement inputFullName = driver.findElement(By
                .xpath("//input[@placeholder='Full Name']"));
        inputFullName.sendKeys("Monkey");
        WebElement inputEmail = driver.findElement(By
                .xpath("//*[@id='userEmail']"));
        inputEmail.sendKeys("monkey@gmail.com");

        WebElement labelTextCurAdd = driver.findElement(By
                .xpath("//*[text()='Current Address']"));
        System.out.println(labelTextCurAdd.getTagName());
        WebElement inputCurAdd = driver.findElement(By
                .xpath("//textarea[@id='currentAddress']"));
        inputCurAdd.sendKeys("Monkey street 5");
        WebElement inputPerAdd = driver.findElement(By
                .xpath("//div[@id='permanentAddress-wrapper']//textarea"));
        inputPerAdd.sendKeys("Monkey avenue 6");
        WebElement btnSubmit = driver.findElement(By
                .xpath("//button[text()='Submit']"));
        btnSubmit.click();
        WebElement output = driver.findElement(By
                .xpath("//div[@id='output']"));

        pause(5);
        System.out.println(output.getText());

        driver.quit();
    }


    public void pause(int time) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void hideBanner() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#fixedban').style.display='none'");
    }

    public void hideFooter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display='none'");
    }
}