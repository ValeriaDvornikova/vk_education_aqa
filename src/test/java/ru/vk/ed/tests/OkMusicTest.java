package ru.vk.ed.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.vk.ed.pages.MainPage;
import ru.vk.ed.pages.MusicPage;

public class OkMusicTest extends BaseTest {
    @Test
    @DisplayName("Проверка проигрывания музыки")
    @Tag("UI")
    // Авторизация прописана в Before для всех тестов
    public void playOkMusic() {
        MainPage mainPage = new MainPage();
        mainPage.clickOnMusic();
        MusicPage musicPage = new MusicPage();
        musicPage.playMusic();
        Assertions.assertNotEquals("0", musicPage.getTime());


    }
}
