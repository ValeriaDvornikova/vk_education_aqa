package ru.vk.ed.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementCondition;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class MusicPage {
    private final SelenideElement MUSIC_BUTTON_PLAY = $x("//wm-icon[@icon = 'play']");
    private final SelenideElement PAUSE_BUTTON = $x("//button[@data-tsid='pause_button']");
    private final SelenideElement WM_PLAYER_DATA = $x("//wm-player-duration[@aria-label = 'Прогресс']");
    private final SelenideElement MUSIC_AREA = $x("//*[@data-tsid='showcase_page']");
    private final SelenideElement MY_MUSIC_BUTTON = $x("//*[@data-l='t,library']");
    private final SelenideElement SEARCH_MUSIC = $x("//input[@placeholder='Поиск музыки']");

    public MusicPage() {
        checkMusicPage();
    }

    // Проверка нахождения на странице с группами
    public void checkMusicPage() {
        MUSIC_AREA.shouldBe(visible.because("Проверка нахождения элементов плеера"));
        MY_MUSIC_BUTTON.shouldBe(visible.because("Проверка нахождения кнопки Моя музыка"));
        SEARCH_MUSIC.shouldBe(visible.because("Проверка нахождения кнопки Поиска музыки"));
    }

    // Нажать на воспроизведение в панели сверху и далее остановка воспроизведения
    public void playMusic() {
        MUSIC_BUTTON_PLAY.shouldBe(visible.because("Проверка нахождения кнопки Воспроизведения")).click();
        sleep(3000L);
        PAUSE_BUTTON.shouldBe(visible.because("Проверка нахождения кнопки Пауза")).click();
    }

    // Возвращаем время воспроизведения трека для проверки проигрывания
    public String getTime() {
        return WM_PLAYER_DATA.shouldBe(visible.because("Должно быть видно время воспроизведения")).getAttribute("current-time");
    }
}
