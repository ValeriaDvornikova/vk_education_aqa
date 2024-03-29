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
    private final SelenideElement RECORD = $x("//div[@class = 'media-text_cnt']");
    private final SelenideElement SET_OF_PROFILE = $x("//button[@aria-label='Настройки профиля']");
    private final SelenideElement EXIT_BOX = $x("//div[@role='listitem']");
    private final SelenideElement EXIT_BUTTON = $x("//a[contains(text(),'Выйти')]");
    private final SelenideElement EXIT_BUTTON2 = $x("//input[@data-l='t,logout']");
    private final SelenideElement NODESOFNEWS = $x("//div[@class = 'feed __just-created __header-redesign']//div[@class = 'feed-action']");
    private final ElementsCollection DELETENEWS = $$x("//*[contains(text(),'Удалить заметку')]");




    // Нажать на кнопку группы на главной странице
    public void pressOnGroup() {
        GROUP_BUTTON.shouldBe(visible).click();
    }

    // На главном экране нажать на кнопку Музыка, расположенную на верхней части панели
    public void clickOnMusic(){
        MUSIC_ELEMENT.shouldBe(visible).click();
        sleep(1000L);
    }
    public void clickNews(){
        PUSH_NEWS.shouldBe(visible).click();
    }
    public String containsRec(){
       return RECORD.innerText();
    }
    // Выход со страницы пользователя
    public void exitOk(){
        SET_OF_PROFILE.shouldBe(visible).click();
        EXIT_BOX.shouldBe(visible).click();
        EXIT_BUTTON.isDisplayed();
        EXIT_BUTTON.shouldBe(visible).click();
        EXIT_BUTTON2.isDisplayed();
        EXIT_BUTTON2.shouldBe(visible).click();
    }
    public void deleteNews(){
        NODESOFNEWS.shouldBe(visible).click();
        DELETENEWS.get(1).shouldBe(visible).click();
    }

}
