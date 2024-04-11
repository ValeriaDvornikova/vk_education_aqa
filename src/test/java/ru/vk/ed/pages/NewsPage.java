package ru.vk.ed.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class NewsPage {
    private final SelenideElement TEXTBOX = $x("//div[@role = 'textbox']");
    private final SelenideElement SUBMIT_NEWS_BUTTON = $x("//button[@data-action = 'submit']");
    private final SelenideElement POSTING_FORM = $x("//*[@data-l= 't,postingForm']");
    private final SelenideElement POSTING_BUTTON_WITH_SETTINGS = $x("//*[@class= 'posting_f_ac']");
    private final SelenideElement ADD_TO_HOBBIES_BUTTON = $x("//*[@class= 'tico__itohv']");

    // Проверяем, что появилась форма с добавлением записи на страницу
    public void checkNewsPage() {
        sleep(2000L);
        POSTING_FORM.shouldBe(visible.because("Проверяем, что появилась форма с добавлением записи"));
        POSTING_BUTTON_WITH_SETTINGS.shouldBe(visible.because("Проверяем, что есть кнопки Фото, Видео, Настройки"));
        ADD_TO_HOBBIES_BUTTON.shouldBe(visible.because("Проверка, что есть кнопка Добавить в увлечения"));
    }

    // Выкладываем запись на странице: нажимаем на кнопку "Опубликовать", в открывающемся окне вводим текст, публикуем новость
    public void pushNews(String str) {
        TEXTBOX.shouldBe(visible.because("Проверяем, что появилась форма с добавлением записи")).click();
        TEXTBOX.setValue(str);
        SUBMIT_NEWS_BUTTON.shouldBe(visible.because("Проверяем, что появилась кнопка Поделиться")).click();
        sleep(2000L);
    }
    // В постусловии выполняется удаление записи
}
