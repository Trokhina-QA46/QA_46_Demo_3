package ajaxtests;

import ajax_element.PrimerAjax;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PrimerAjaxTest {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }


    @Test()
    public void searchRepositoryTestUIAjax() {
        PrimerAjax primerAjax = new PrimerAjax(getDriver());
        primerAjax.methodAjax();
    }

    @Test()
    public void searchRepositoryTestUI() {
        PrimerAjax primerAjax = new PrimerAjax(getDriver());
        primerAjax.method();
    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }
}