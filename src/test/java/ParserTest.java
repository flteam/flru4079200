import exception.NotFoundException;
import model.ParsedData;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parser.ObjectSutkiParser;
import parser.Parser;

import java.io.IOException;

class ParserTest {

    private static final Logger LOGGER = Logger.getLogger(ParserTest.class);

    @Test
    void apartmentParserTest() {

    }

    @Test
    void objectDolgoParserTest() {

    }

    @Test
    void objectSutkiStressTest() {
        Parser parser = new ObjectSutkiParser();
        int i = 0;
        int maxId = 4_000;
        for (long j = 3_000; j <= maxId; j++) {
            try {
                ParsedData parsedData = parser.parse(j);
                LOGGER.info("For id = " + j + " exist data!");
            } catch (NotFoundException e) {
                LOGGER.warn("For id = " + j + " not found!");
            } catch (IOException e) {
                Assertions.fail(e);
            }
        }
    }

}
