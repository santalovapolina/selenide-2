package demoqa_tests;

import org.junit.jupiter.api.Test;

import java.io.File;

public class RegistrationFormTestWithPageObjects extends TestBase {


    @Test
    void successfulRegistrationTest() {

        String firstName = "Test";
        String lastName = "Test";
        String userEmail = "test@test.com";
        String userGender = "Other";
        String userNumber = "1234567890";
        String birthMonth = "January";
        String birthYear = "1993";
        String birthDay = "06";
        String userSubject1 = "Maths";
        String userSubject2 = "Computer Science";
        String userHobby1 = "Sports";
        String userHobby2 = "Music";
        String userPicture = "pol.jpg";
        String userAddress = "Some address";
        String userState = "NCR";
        String userCity = "Delhi";


        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(userGender)
                .setPhoneNumber(userNumber)
                .setBirthDate(birthDay, birthMonth, birthYear)
                .setSubjects(userSubject1, userSubject2)
                .setHobbies(userHobby1, userHobby2)
                .uploadPicture(userPicture)
                .setAddress(userAddress)
                .setStateAndCity(userState, userCity)
                .submitForm()
                .verifyResultModalAppears()
                .verifyResults("Student Name", firstName + " " + lastName)
                .verifyResults("Student Email", userEmail)
                .verifyResults("Gender", userGender)
                .verifyResults("Mobile", userNumber)
                .verifyResults("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .verifyResults("Subjects", userSubject1 + ",  " + userSubject2)
                .verifyResults("Hobbies", userHobby1 + ", " + userHobby2)
                .verifyResults("Picture", userPicture)
                .verifyResults("Address", userAddress)
                .verifyResults("State and City", userState + " " + userCity);



    }

}