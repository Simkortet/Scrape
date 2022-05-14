import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class SdarmTest {

    @Test
    public void testing() throws IOException {

        Document document = Jsoup.connect("https://sdarm.org/publications/periodicals/sbl/en/2022/2/7").get();

        Assertions.assertNotNull(document);

        Element first = document.select("span.sbl_sabbath").first();

        assert first != null;
        String[] dateElements = first.text().split(",");

        String year = dateElements[2].trim();
        String day = dateElements[1].split(" ")[2].trim();
        String month = dateElements[1].split(" ")[1].trim();

        Assertions.assertEquals("Sabbath, May 14, 2022", first.text());
        Assertions.assertEquals("May", month);
        Assertions.assertEquals("14", day);
        Assertions.assertEquals("2022", year);


    }
}
