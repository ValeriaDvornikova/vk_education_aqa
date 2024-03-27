package ru.vk.ed.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class GroupPage {
    private final SelenideElement JOIN_GROUP = $x("//button[.//span[contains(text(),'Вступить')]]");
    private final SelenideElement RESULT_TEXT_IN_TAG = $x("//span[contains(text(),'Вы в группе')]");
    private final SelenideElement GROUP_FIRST = $x("//img[@class='photo_img'][1]");
    private final SelenideElement EXIT_GROUP = $x("//*[@id='hook_Block_AltGroupMainMenu']/ul/div/div");
    private final SelenideElement EXIT_STEP = $x("//div[@class='dropdown_n']");
    private final SelenideElement OUT = $x("//input[@data-l = 't,confirm']");

    // Нажать на кнопку "Вступить" у первой группы
    public void getIntoGroup() {
        Throwable exception = null;
        do {
            JOIN_GROUP.shouldBe(visible).click();
            try {
                getResultText();
                exception = null;
            } catch (Throwable ex){
                exception = ex;
            }
        } while(exception!=null);
    }

    // Получить текст "Вы в группе" из элемента на странице
    public String getResultText() {
        return RESULT_TEXT_IN_TAG.shouldBe(visible).innerText();
    }

    // Выйти из группы
    public void exitMyGroup() {
        Selenide.refresh();
        GROUP_FIRST.click();
        EXIT_GROUP.click();
        EXIT_STEP.click();
        OUT.click();
    }
}
