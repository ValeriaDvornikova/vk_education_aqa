package ru.vk.ed.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
/**
 * Страница для входа в ok.ru
 */
    public class LoginPage {
        private final SelenideElement LOG_FORM = $x("//input[@name='st.email']");
        private final SelenideElement PASS_FORM = $x("//input[@name='st.password']");
        private final SelenideElement SUBMIT_BUTTON = $x("//input[@type = 'submit']");

    /** Загрузка странциы для входа
     * @param url - Адрес страницы сайта
     */
    public LoginPage(String url){
            Selenide.open(url);
        }
        public void checkLogPage(){
        LOG_FORM.shouldBe(clickable);
        PASS_FORM.shouldBe(clickable);
        SUBMIT_BUTTON.shouldBe(clickable);
        }
        // Ввод данных в формы для логина и пароля
        public void clickOnLogForm(String logInfo) {
            LOG_FORM.setValue(logInfo);
        }
        public void clickOnPassForm(String passInfo){
            PASS_FORM.setValue(passInfo);
        }
        // Клик по кпопке "Войти в одноклассники"
        public void pressOnButton(){
            SUBMIT_BUTTON.shouldBe(visible).click();
        }
    }
