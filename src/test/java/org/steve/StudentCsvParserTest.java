package org.steve;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentCsvParserTest {

    private StudentCsvParser parser;
    private List<StudentDTO> studentDTO;
    private String fileName;


    @Before
    public void setUp() throws IOException {
        parser = new StudentCsvParserImpl();
        this.fileName = "sample-data.csv";
        this.studentDTO = parser.parseCsv(fileName);
    }

    @Test
    public void testParseCsv() {
        try {
            parser.printCsv(this.studentDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldParseFileToStream() {
        StudentDTO firstElement = this.studentDTO.get(0);
        StudentDTO elementTest = new StudentDTO();
        elementTest.setStudentId(1);
        elementTest.setFirstName("Michael");
        elementTest.setLastName("Fox");
        elementTest.setMiddleName("J");

        assertEquals(Arrays.asList(firstElement.getStudentId(), firstElement.getFirstName(), firstElement.getLastName(),
                firstElement.getMiddleName()),
                Arrays.asList(elementTest.getStudentId(), elementTest.getFirstName(), elementTest.getLastName(),
                        elementTest.getMiddleName()));
    }

    @Test (expected = NullPointerException.class)
    public void shouldThrowExceptionWhenFileNotFound() throws IOException {
        parser.parseCsv( "filenotfound.txt");
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowExceptionEmptyFileName() throws IOException {
        parser.parseCsv(" ");
    }
}