package demoqa_tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;


public class RegistrationFormTestWithPageObjects extends TestBase {
    Faker faker = new Faker();


    @Test
    void successfulRegistrationTest() {

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                userAddress = faker.address().streetAddress(),
                userNumber = faker.number().digits(10),
                userSubject1 = "Computer science",
                userSubject2 = "Maths",
                userGender = "Other",
                birthMonth = "January",
                birthYear = "1993",
                birthDay = "06",
                userHobby1 = "Sports",
                userHobby2 = "Music",
                userPicture = "pol.jpg",
                userState = "NCR",
                userCity = "Delhi";


        registrationPage.openPage()

                .setGender(userGender)
                .setBirthDate(birthDay, birthMonth, birthYear)
                .setSubjects(userSubject1, userSubject2)
                .setHobbies(userHobby1, userHobby2)
                .uploadPicture(userPicture)
                .setStateAndCity(userState, userCity)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setPhoneNumber(userNumber)
                .setAddress(userAddress)
                .submitForm()


                .verifyResultModalAppears()
                .verifyResults("Student Name", firstName + " " + lastName)
                .verifyResults("Student Email", userEmail)
                .verifyResults("Gender", userGender)
                .verifyResults("Mobile", userNumber)
                .verifyResults("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .verifyResults("Subjects", userSubject1 + ", " + userSubject2)
                .verifyResults("Hobbies", userHobby1 + ", " + userHobby2)
                .verifyResults("Picture", userPicture)
                .verifyResults("Address", userAddress)
                .verifyResults("State and City", userState + " " + userCity);


    }

}
