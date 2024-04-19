package ru.vk.ed.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.refresh;

public class GroupPage {
    private final SelenideElement JOIN_GROUP = $x("//button[.//span[contains(text(),'Вступить')]]");
    private final SelenideElement RESULT_TEXT_IN_TAG = $x("//span[contains(text(),'Вы в группе')]");
    private final SelenideElement GROUP_FIRST = $x("//*[@class = 'scroll-slider_item mr-x']//div[@class='section']");
    private final SelenideElement EXIT_GROUP = $x("//*[@data-l = 'outlandertarget,join,t,join']");
    private final SelenideElement EXIT_STEP = $x("//div[@class='dropdown_n']");
    private final SelenideElement OUT = $x("//input[@data-l = 't,confirm']");
    private final SelenideElement RECOMMEND_GROUP = $x("//*[contains(text(),'Рекомендуем')]");
    private final SelenideElement SEARCH_GROUP_WINDOW = $x("//*[@type='search']");
    private final SelenideElement CREATE_GROUP_BUTTON = $x("//*[contains(text(),'Создать группу')]");

    //
    public GroupPage() {
        checkGroupPage();
    }

    // Проверка нахождения на странице с группами
    public void checkGroupPage() {
        RECOMMEND_GROUP.shouldBe(visible.because("Проверка нахождения поля с группами на странице"));
        SEARCH_GROUP_WINDOW.shouldBe(visible.because("Проверка нахождения поиска на странице c группами"));
        CREATE_GROUP_BUTTON.shouldBe(visible.because("Проверка нахождения кнопки Создания группы"));
    }

    // Нажать на кнопку "Вступить" у первой группы
    public void joinGroup() {
        // Сделала ретрай, так как не прожимается с первого раза кнопка "Вступить"
        Throwable exception = null;
        do {
            JOIN_GROUP.shouldBe(visible.because("Проверка нахождения кнопки Вступить")).click();
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
        return RESULT_TEXT_IN_TAG.shouldBe(visible.because("Проверка нахождения кнопки Вы в группе")).innerText();
    }

    // Выйти из группы
    public void exitMyGroup() {
        GROUP_FIRST.shouldBe(visible.because("Проверка нахождения группы, в которую вступили")).click();
        EXIT_GROUP.shouldBe(visible.because("Проверка нахождения кнопки Выхода из группы")).click();
        EXIT_STEP.shouldBe(visible.because("Проверка нахождения кнопки выйти из группы во всплывающем окне")).click();
        OUT.shouldBe(visible.because("Проверка нахождения кнопки Выхода из группы")).click();
    }
}
