package pages;

import dto.Student;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement inputName;
    @FindBy(id = "lastName")
    WebElement inputLastName;
    @FindBy(id = "userEmail")
    WebElement inputEmail;
    @FindBy(css = "input[placeholder='Mobile Number']")
    WebElement inputMobile

    public void typePracticeForm(Student student){

        hideBanner();
        hideBanner();
        inputName.sendKeys(student.getName());
        inputName.sendKeys(student.getLastName());
        inputName.sendKeys(student.getEmail());
        inputName.sendKeys(student.getMobile());

    }
}