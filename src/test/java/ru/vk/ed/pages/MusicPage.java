package ru.vk.ed.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class MusicPage {
    private final SelenideElement MUSIC_BUTTON_PLAY = $x("//wm-icon[@icon = 'play']");
    private final SelenideElement PAUSE_BUTTON = $x("//button[@data-tsid='pause_button']");
    private final SelenideElement WM_PLAYER_DATA = $x("//wm-player-duration[@aria-label = 'Прогресс']");

    // Нажать на воспроизведение в панели сверху и далее остановка воспроизведения
    public void playMusic(){
        MUSIC_BUTTON_PLAY.shouldBe(visible).click();
        sleep(3000L);
        PAUSE_BUTTON.click();
    }
    // Возвращаем время воспроизведения трека для проверки проигрывания
    public String getTime(){
        return WM_PLAYER_DATA.getAttribute("current-time");
    }
}
