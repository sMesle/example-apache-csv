package org.steve;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class StudentCsvParserImpl implements StudentCsvParser {

    public List<StudentDTO> parseCsv(String fileName) throws IOException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        List<StudentDTO> studentList = new ArrayList<>();

        Reader in = new FileReader(file);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);

        for (CSVRecord record : records) {
            StudentDTO dto = new StudentDTO();
            dto.setStudentId(Integer.parseInt(record.get("STUDENT_ID")));
            dto.setFirstName(record.get("FIRST_NAME"));
            dto.setLastName(record.get("LAST_NAME"));
            dto.setMiddleName(record.get("MIDDLE_NAME"));
            studentList.add(dto);
        }

        return studentList;
    }

    public void printCsv(String fileName) throws IOException {

        List<StudentDTO> dtoList = parseCsv(fileName);

        for (StudentDTO dto : dtoList) {
            System.out.println("**********");
            System.out.println("USER_ID:" + dto.getStudentId());
            System.out.println("LAST_NAME:" + dto.getLastName());
            System.out.println("MIDDLE_NAME:" + dto.getMiddleName());
            System.out.println("FIRST_NAME:" + dto.getFirstName());
        }
    }

}