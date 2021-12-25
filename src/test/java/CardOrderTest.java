import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardOrderTest {

    @Test
    void shouldTest() {
        open("http://localhost:9999");

        $("[data-test-id=name] input").setValue("Иванова Анна");
        $("[data-test-id=phone] input").setValue("+79291234567");
        $("[data-test-id=agreement]").click();
        $("button").click();
        $("[data-test-id=order-success]").shouldHave(text("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}