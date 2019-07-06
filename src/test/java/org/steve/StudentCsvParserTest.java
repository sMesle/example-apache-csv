package org.steve;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StudentCsvParserTest {

    private StudentCsvParser parser;
    private List<StudentDTO> studentDTO;
    private String fileName;

    @Before
    public void setUp() {
        parser = new StudentCsvParserImpl();
        this.fileName = "sample-data.csv";
    }

    @Test
    public void testParseCsv() {
        try {
            this.studentDTO = parser.parseCsv(fileName);
            parser.printCsv(this.studentDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}