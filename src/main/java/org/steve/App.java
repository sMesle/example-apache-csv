package org.steve;

import java.io.IOException;
import java.util.List;

public class App
{
    public static void main( String[] args ) throws IOException {
        String fileName = "sample-data.csv";
        StudentCsvParser parser = new StudentCsvParserImpl();
        List<StudentDTO> dtoList = parser.parseCsv(fileName);
        parser.printCsv(dtoList);
    }

}
