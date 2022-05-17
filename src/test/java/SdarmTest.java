import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sdarm.records.content.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SdarmTest {

    @Test
    public void testing() throws IOException {

        // Get the base html page
        Document document = Jsoup.connect("https://sdarm.org/publications/periodicals/sbl/en/2022/2/7").get();
        Assertions.assertNotNull(document);

        // Select which element from the html page we are working on

        int j = 0;
    }

    @Test
    public void javaBehaviourTest(){
        String string = "myString1, myString2, myString3";
        String[] myStringArray = string.split(",");
    }
}
