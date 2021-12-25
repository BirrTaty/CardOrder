import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class CardOrderTest {

    @Test
    void shouldSendCorrectMessage(){
        open("http://localhost:9999/");
        SelenideElement form = $("form");
        form.$("[data-test-id=name] input").setValue("Татьяна");
        form.$("[data-test-id=phone] input").setValue("+79218671153");
        form.$("[data-test-id=agreement]").click();
        form.$("button").click();
        $("[data-test-id=order-success]").shouldHave(text("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время!"));
    }
}
