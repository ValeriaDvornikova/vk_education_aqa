package ru.vk.ed.pages;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

/**
 * Главная страница одноклассников
 */
public class MainPage {
    // Нахождение элемента на странице одноклассников после входа
    public final SelenideElement PHOTO_ZONE = Selenide.$(By.id("hook_Block_Avatar"));
    private final SelenideElement GROUP_BUTTON = $x("//a[@data-l = 't,userAltGroup']");

    private final SelenideElement MUSIC_ELEMENT = $x("//button[@aria-label='Музыка']");
    private final SelenideElement PUSH_NEWS = $x("//span[contains(text(),'Опубликовать')]");
    private final SelenideElement CLICK_ON_RECORD = $x("//span[contains(text(),'Запись')]");
    private final SelenideElement RECORD = $x("//div[@class = 'media-text_cnt']");
    private final SelenideElement SET_OF_PROFILE = $x("//button[@aria-label='Настройки профиля']");
    private final SelenideElement EXIT_BOX = $x("//div[@role='listitem']");
    private final SelenideElement EXIT_BUTTON = $x("//a[contains(text(),'Выйти')]");
    private final SelenideElement EXIT_BUTTON2 = $x("//input[@data-l='t,logout']");
    private final SelenideElement NODES_OF_NEWS = $x("//div[@class = 'feed __just-created __header-redesign']//div[@class = 'feed-action']");
    private final ElementsCollection DELETE_NEWS = $$x("//*[contains(text(),'Удалить заметку')]");
    private final SelenideElement ENTERTAINMENTS_AREA = $x("//*[@class='alternative-content-block__hcz2a']");
    private final SelenideElement USER_PAGE_ELEMENT = $x("//*[@data-l='t,userPage']");

    // Проверка наахождения на главной странице
    public void checkMainPage() {
        PHOTO_ZONE.shouldBe(visible.because("Проверка нахождения фотографии на главной странице"));
        ENTERTAINMENTS_AREA.shouldBe(visible.because("Проверка нахождения блока на главной странице"));
        USER_PAGE_ELEMENT.shouldBe(visible.because("Проверка нахождения Фамилии и имени на странице"));
    }

    // Нажать на кнопку группы на главной странице
    public void pressOnGroup() {
        GROUP_BUTTON.shouldBe(visible.because("Проверка нахождения кнопки Группы")).click();
    }

    // На главном экране нажать на кнопку Музыка, расположенную на верхней части панели
    public void clickOnMusic() {
        MUSIC_ELEMENT.shouldBe(visible.because("Проверка нахождения кнопки Музыка")).click();
        sleep(1000L);
    }

    public void clickNews() {
        PUSH_NEWS.shouldBe(visible.because("Проверка нахождения кнопки Опубликовать")).click();
        CLICK_ON_RECORD.shouldBe(visible.because("Проверка нахождения кнопки Запись во всплывающем окне")).click();


    }

    public String containsRec() {
        return RECORD.innerText();
    }

    // Выход со страницы пользователя
    public void exitOk() {
        SET_OF_PROFILE.shouldBe(visible.because("Проверка нахождения кнопки Настройки профиля")).click();
        EXIT_BOX.shouldBe(visible.because("Проверка нахождения бокса с кнопкой Выйти")).click();
        EXIT_BUTTON.shouldBe(visible.because("Проверка нахождения кнопки Выйти")).click();
        EXIT_BUTTON2.shouldBe(visible.because("Проверка нахождения кнопки Выйти во всплывающем окне")).click();
    }

    public void deleteNews() {
        NODES_OF_NEWS.shouldBe(visible.because("Проверка нахождения кнопки Функции добавленной новости")).click();
        DELETE_NEWS.get(1).shouldBe(visible.because("Проверка нахождения кнопки Удалать запись")).click();
    }

}
