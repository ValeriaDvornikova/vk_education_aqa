package ru.vk.ed.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class NewsPage {
    private final SelenideElement RECORDING = $x("//span[contains(text(),'Запись')]");
    private final SelenideElement TEXTBOX = $x("//div[@role = 'textbox']");
    private final SelenideElement SUBMIT_NEWS_BUTTON= $x("//button[@data-action = 'submit']");

// Выкладываем запись на странице: нажимаем на кнопку "Опубликовать", в открывающемся окне вводим текст, публикуем новость
    public void pushNews(String str){
        RECORDING.shouldBe(visible).click();
        TEXTBOX.shouldBe(visible).click();
        TEXTBOX.setValue(str);
        SUBMIT_NEWS_BUTTON.shouldBe(visible).click();
        sleep(2000L);
    }
    // В постусловии выполняется удаление записи
}
