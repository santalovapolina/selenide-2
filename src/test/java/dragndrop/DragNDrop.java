package dragndrop;


import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class DragNDrop {
    @Test
    void dragAndDropTest() {
        open("https://the-internet.herokuapp.com");
        $("#content").$$("a").findBy(text("Drag and Drop")).click();
        $("[id=column-a]").dragAndDropTo("[id=column-b]");
        actions().moveToElement($("[id=column-b]")).clickAndHold().moveByOffset(100,0).release().perform();

    }
}
