package tests;

import dto.Student;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

public class PracticeFormTests extends AppManager {

    @Test
    public void studentRegFormPositiveTest(){
        Student student = new Student("Petya", "Petrov", "petya@gmail.com",
                "male", "0123456789", "01 Dec 2000",
                "Maths,Physics,Chemistry", "music","",
                "address 1", "NCR", "Delhi");
       new HomePage(getDriver()).clickBtnForms();
       new FormsPage(getDriver()).clickBtnPracticeForm();
       new PracticeFormPage(getDriver()).typePracticeForm(student);
    }
}
