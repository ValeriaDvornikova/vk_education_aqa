package ru.vk.ed.tests;
import org.apache.commons.logging.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vk.ed.pages.LoginPage;
import ru.vk.ed.pages.MainPage;


public class OkLoginTest extends BaseTest {
    @Test
    // Авторизация прописана в Before для всех тестов
    public void logInSite(){
        // Проверка наличия на главной странице области с фото
        Assertions.assertTrue(new MainPage().PHOTO_ZONE.isDisplayed());
    }



}
