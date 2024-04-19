package ru.vk.ed.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.vk.ed.pages.GroupPage;
import ru.vk.ed.pages.MainPage;

public class OkGroupTest extends BaseTest {
    @Test
    @DisplayName("Проверка вступления в группу")
    @Tag("UI")
    // Авторизация прописана в Before для всех тестов
    public void testGroup() {
        MainPage mainPage = new MainPage();
        mainPage.pressOnGroup();
        GroupPage groupPage = new GroupPage();
        groupPage.joinGroup();
        Assertions.assertEquals("Вы в группе", groupPage.getResultText());

        // Выходим из группы с целью сделать тест идепотентным
        Selenide.refresh();
        groupPage.exitMyGroup();
    }
}
