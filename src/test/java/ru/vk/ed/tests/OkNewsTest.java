package ru.vk.ed.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.vk.ed.pages.MainPage;
import ru.vk.ed.pages.NewsPage;

public class OkNewsTest extends BaseTest {
    private String str = "It's a good news!";

    @Test
    @DisplayName("Проверка добавления новости на страницу")
    @Tag("UI")
    // Авторизация прописана в Before для всех тестов
    public void pushRecording() {
        MainPage mainPage = new MainPage();
        mainPage.clickNews();
        NewsPage newspage = new NewsPage();
        newspage.pushNews(str);
        Assertions.assertTrue(mainPage.containsRec().contains(str));
        mainPage.deleteNews();
    }
}
