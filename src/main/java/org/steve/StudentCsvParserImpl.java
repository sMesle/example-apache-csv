package org.steve;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentCsvParserImpl implements StudentCsvParser {

    public List<StudentDTO> parseCsv(String fileName) throws IOException {

        InputStream inputStream = this.getClass().getClassLoader()
                .getResourceAsStream(fileName);
        CSVParser parser = new CSVParser(new InputStreamReader(inputStream), CSVFormat.EXCEL.withHeader());
        List<StudentDTO> studentList = new ArrayList<>();

        for (CSVRecord record : parser) {
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