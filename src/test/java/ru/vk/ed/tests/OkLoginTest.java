package ru.vk.ed.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.vk.ed.pages.MainPage;


public class OkLoginTest extends BaseTest {
    @Test
    @DisplayName("Проверка авторизации")
    @Tag("UI")
    // Авторизация прописана в Before для всех тестов
    public void logInSite() {
        // Проверка наличия на главной странице области с фото
        Assertions.assertTrue(new MainPage().isMainPage());
    }


}
