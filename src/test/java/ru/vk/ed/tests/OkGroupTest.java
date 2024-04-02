package ru.vk.ed.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vk.ed.pages.GroupPage;
import ru.vk.ed.pages.MainPage;

public class OkGroupTest extends BaseTest {
    @Test
    // Авторизация прописана в Before для всех тестов
    public void testGroup(){
        MainPage mainPage = new MainPage();
        mainPage.pressOnGroup();
        GroupPage groupPage = new GroupPage();
        groupPage.checkGroupPage();
        groupPage.getIntoGroup();
        Assertions.assertTrue(groupPage.getResultText().equals("Вы в группе"));

        // Выходим из группы с целью сделать тест идепотентным
        groupPage.exitMyGroup();
    }
}
