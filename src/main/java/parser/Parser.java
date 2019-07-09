package parser;

import model.ParsedData;

import java.io.IOException;

public interface Parser {

    String BASE_URL = "http://www.rijeltor.ru/";

    ParsedData parse(Long id) throws IOException;

}
