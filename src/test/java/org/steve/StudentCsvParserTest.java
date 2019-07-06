package org.steve;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class StudentCsvParserTest {

    private StudentCsvParser parser;

    @Before
    public void setUp() {
        parser = new StudentCsvParserImpl();
    }

    @Test
    public void testParseCsv() {
        try {
            parser.parseCsv("sample-data.csv");
            parser.printCsv("sample-data.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}