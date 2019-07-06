package org.steve;

import java.io.IOException;

public class App
{
    public static void main( String[] args ) throws IOException {
        String fileName = "sample-data.csv";
        StudentCsvParser parser = new StudentCsvParserImpl();
        parser.parseCsv(fileName);
        parser.printCsv(fileName);
    }

}
