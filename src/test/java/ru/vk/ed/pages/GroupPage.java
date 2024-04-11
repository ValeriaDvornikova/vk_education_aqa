package ru.vk.ed.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class GroupPage {
    private final SelenideElement JOIN_GROUP = $x("//button[.//span[contains(text(),'Вступить')]]");
    private final SelenideElement RESULT_TEXT_IN_TAG = $x("//span[contains(text(),'Вы в группе')]");
    private final SelenideElement GROUP_FIRST = $x("//*[@class = 'scroll-slider_item mr-x']//div[@class='section']");
    private final SelenideElement EXIT_GROUP = $x("//*[@data-l = 'outlandertarget,join,t,join']");
    private final SelenideElement EXIT_STEP = $x("//div[@class='dropdown_n']");
    private final SelenideElement OUT = $x("//input[@data-l = 't,confirm']");
    private final SelenideElement GROUP_AREA = $x("//*[@class='loader-container popular-groups-loader']");
    private final SelenideElement SEARCH_GROUP_WINDOW = $x("//*[@type='search']");
    private final SelenideElement CREATE_GROUP_BUTTON = $x("//*[contains(text(),'Создать группу')]");

    // Проверка нахождения на странице с группами
    public void checkGroupPage() {
        GROUP_AREA.shouldBe(visible);
        SEARCH_GROUP_WINDOW.shouldBe(visible);
        CREATE_GROUP_BUTTON.shouldBe(visible);
    }

    // Нажать на кнопку "Вступить" у первой группы
    public void getIntoGroup() {
        Throwable exception = null;
        do {
            JOIN_GROUP.shouldBe(visible).click();
            try {
                getResultText();
                exception = null;
            } catch (Throwable ex) {
                exception = ex;
            }
        } while (exception != null);
    }

    // Получить текст "Вы в группе" из элемента на странице
    public String getResultText() {
        return RESULT_TEXT_IN_TAG.shouldBe(visible).innerText();
    }

    // Выйти из группы
    public void exitMyGroup() {
        Selenide.refresh();
        GROUP_FIRST.shouldBe(visible).click();
        EXIT_GROUP.shouldBe(visible).click();
        EXIT_STEP.shouldBe(visible).click();
        OUT.shouldBe(visible).click();
    }
}
