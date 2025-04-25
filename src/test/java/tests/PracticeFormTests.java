package tests;

import dto.Student;
import emums.Gender;
import emums.Hobbies;
import emums.StateCity;
import manager.AppManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends AppManager {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void studentRegFormPositiveTest() {
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.SPORTS);
        hobbies.add(Hobbies.MUSIC);
        Student student = new Student("Vasya", "Vasilev",
                "vasyavasilev@mail.com",
                Gender.MALE, "0123456789", "11 Dec 2020",
                "Maths,Physics,Chemistry",
                hobbies, "", "address 1", StateCity.NCR.getState(), StateCity.NCR.getCity()[2]);
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormPage(getDriver()).typePracticeForm(student);
        // Assert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessageNegative());
        //System.out.println("Test failed");
        Assert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessage(), "Test passed");
    }

    @Test
    public void studentRegFormPositiveTestSoftAssert() {
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.SPORTS);
        hobbies.add(Hobbies.MUSIC);
        Student student = new Student("Vasya", "Vasilev",
                "vasyavasilev@mail.com",
                Gender.MALE, "0123456789", "11 Dec 2020",
                "Maths,Physics,Chemistry",
                hobbies, "", "address 1", StateCity.NCR.getState(), StateCity.NCR.getCity()[2]);
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormPage(getDriver()).typePracticeForm(student);
        softAssert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessageNegative());
        softAssert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessage(), "Test passed");
        softAssert.assertEquals(getDriver().findElement(By.xpath("//tbody/tr[2]/td[last()]"))
                .getText(),student.getEmail(),"message email");
        System.out.println("Test finished");
        softAssert.assertAll();

    }
}