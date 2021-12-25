import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardOrderTest {

    @Test
    void shouldPathWithSpaceInName() {
        open("http://localhost:9999");

        $("[data-test-id=name] input").setValue("Бирюкова Татьяна");
        $("[data-test-id=phone] input").setValue("+79218671153");
        $("[data-test-id=agreement]").click();
        $("button").click();
        $("[data-test-id=order-success]").shouldHave(text("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
    @Test
    void shouldPathWithHyphenAndSpaceInName() {
        open("http://localhost:9999");

        $("[data-test-id=name] input").setValue("Бирюкова Татьяна-Виктория");
        $("[data-test-id=phone] input").setValue("+79218671153");
        $("[data-test-id=agreement]").click();
        $("button").click();
        $("[data-test-id=order-success]").shouldHave(text("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
    @Test
    void shouldPathWithOneLetter() {
        open("http://localhost:9999");

        $("[data-test-id=name] input").setValue("Б");
        $("[data-test-id=phone] input").setValue("+79218671153");
        $("[data-test-id=agreement]").click();
        $("button").click();
        $("[data-test-id=order-success]").shouldHave(text("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
