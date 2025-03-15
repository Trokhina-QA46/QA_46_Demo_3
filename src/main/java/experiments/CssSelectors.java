package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectors {
    WebDriver driver = new ChromeDriver();

    @Test
    public void selectorsHomePage() {
        //driver.navigate().to("https://demoqa.com/");
        //driver.navigate().back();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        hideBanner();
        hideFooter();

        pause(3);
        WebElement imgTools = driver.findElement(By.cssSelector("img[src='/images/Toolsqa.jpg']"));
        System.out.println(imgTools.getTagName());
        System.out.println(imgTools.getAttribute("src"));

        WebElement footer = driver.findElement(By.tagName("footer"));
        pause(5);
        WebElement divElements = driver.findElement(By.cssSelector(".card-up"));
        divElements.click();
        driver.navigate().back();
        pause(5);

        WebElement divWidgets = driver.findElement(By
                .cssSelector("div[class='category-cards'] div[class='card mt-4 top-card']:nth-child(4)"));
        divWidgets.click();
        driver.navigate().back();
        pause(5);
        WebElement divWidgetsText = driver.findElement(By
                .cssSelector("div[class='category-cards'] " +
                        "div[class='card mt-4 top-card']:nth-child(4) div[class='card-body'] h5"));
        System.out.println(divWidgetsText.getText());
        pause(5);
        //driver.close();
        driver.quit();
    }

    @Test
    public void selectorElementsPage() {
        driver.get("https://demoqa.com/elements");
        driver.manage().window().maximize();
        hideBanner();
        hideFooter();

        //WebElement textBox = driver.findElement(By.cssSelector("li[id='item-0']"));
        //WebElement textBox = driver.findElement(By.id("item-0"));
        WebElement textBox = driver.findElement(By.cssSelector("#item-0"));
        System.out.println(textBox.getAttribute("class"));

        //WebElement checkBox = driver.findElement(By.cssSelector("[id='item-1']"));
        //WebElement checkBox = driver.findElement(By.id("item-1"));
        //WebElement checkBox = driver.findElement(By.cssSelector("#item-1"));
        WebElement checkBox = driver.findElement(By.cssSelector("li[id='item-1']"));
        checkBox.click();


        pause(5);

        driver.quit();
    }

    @Test
    public void selectorRadioButtonPage() {
        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();
        hideBanner();
        hideFooter();

        //WebElement radioButtonYes = driver.findElement(By.cssSelector("label[for='yesRadio']"));
        //WebElement radioButtonYes = driver.findElement(By.cssSelector("[for='yesRadio']"));
        //WebElement radioButtonYes = driver.findElement(By.cssSelector(".custom-control-label"));
        //WebElement radioButtonYes = driver.findElement(By.className("custom-control-label"));
        WebElement radioButtonYes = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        radioButtonYes.click();
        pause(5);

        //WebElement impressiveButton = driver.findElement(By.id("impressiveRadio"));
        //WebElement impressiveButton = driver.findElement(By.cssSelector("[for='impressiveRadio']"));
        WebElement impressiveButton = driver.findElement(By.xpath("//*[@for='impressiveRadio']"));
        impressiveButton.click();
        pause(5);

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