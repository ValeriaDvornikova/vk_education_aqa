package ru.vk.ed.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class NewsPage {
    private final SelenideElement RECORDING = $x("//span[contains(text(),'Запись')]");
    private final SelenideElement TEXTBOX = $x("//div[@role = 'textbox']");
    private final SelenideElement SUBMIT_NEWS_BUTTON= $x("//button[@data-action = 'submit']");

// Выкладываем запись на странице: нажимаем на кнопку "Опубликовать", в открывающемся окне вводим текст, публикуем новость
    public void pushNews(String str){
        RECORDING.click();
        TEXTBOX.click();
        TEXTBOX.setValue(str);
        SUBMIT_NEWS_BUTTON.click();
        sleep(2000L);
    }
}
