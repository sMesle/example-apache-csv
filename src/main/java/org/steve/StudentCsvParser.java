package org.steve;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface StudentCsvParser {

    List<StudentDTO> parseCsv(String fileName) throws IOException;
    void printCsv(List<StudentDTO> StudentDTO) throws IOException;

}
