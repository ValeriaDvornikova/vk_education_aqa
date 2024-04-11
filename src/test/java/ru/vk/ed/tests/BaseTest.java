package ru.vk.ed.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.vk.ed.pages.LoginPage;
import ru.vk.ed.pages.MainPage;

public abstract class BaseTest {

    private final static String BASE_URL = "https://ok.ru/";
    private final static String LOGIN = "technopol49";
    private final static String PASS = "technopolisPassword";


    // Настройка веб-драйвера
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    // Авторизация и настройка веб-драйвера для тестов
    public void init() {
        setUp();
        authorized();
    }

    // Авторизация на странице ok.ru
    public void authorized() {
        LoginPage loginPage = new LoginPage(BASE_URL);
        // Проверяем, что это действительно страница авторизации пользователя
        loginPage.checkLogPage();
        // Введение логина, пароля и нажатие на кнопку для авторизации пользователя
        loginPage.clickOnLogForm(LOGIN);
        loginPage.clickOnPassForm(PASS);
        loginPage.pressOnButton();

    }

    // Постусловие для тестов: выход из учетной записи и закрытие веб-драйвера
    @AfterEach
    public void tearDown() {
        new MainPage().exitOk();
        Selenide.closeWebDriver();
    }


}
