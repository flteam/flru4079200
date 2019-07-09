package parser;

import exception.NotFoundException;
import model.ParsedData;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ObjectSutkiParser implements Parser {

    private static final String URL = BASE_URL + "object_sutki.php";

    @Override
    public ParsedData parse(Long id) throws IOException {
        String url = URL + "?id=" + id;
        Connection.Response response = Jsoup.connect(url).ignoreHttpErrors(true).execute();
        if (response.statusCode() != 404) {
            Document document = response.parse();
            ParsedData parsedData = new ParsedData();
            parsedData.setDescription(document.getElementsByClass("object-desc").get(0).text());
            return parsedData;
        } else {
            throw new NotFoundException("Not found!");
        }
    }

}
