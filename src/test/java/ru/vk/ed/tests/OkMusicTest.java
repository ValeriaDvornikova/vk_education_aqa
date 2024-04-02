package ru.vk.ed.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vk.ed.pages.MainPage;
import ru.vk.ed.pages.MusicPage;

public class OkMusicTest extends BaseTest{
    @Test
    // Авторизация прописана в Before для всех тестов
    public void playOkMusic(){
       MainPage mainPage = new MainPage();
       mainPage.clickOnMusic();
       MusicPage musicPage = new MusicPage();
       musicPage.checkMusicPage();
       musicPage.playMusic();
       Assertions.assertFalse(musicPage.getTime().equals(0));





    }
}
