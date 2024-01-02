package vn.techmaster.demostreamapiapplication.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import vn.techmaster.demostreamapiapplication.model.Person;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class CSVFileReader implements IFileReader {

    @Override
    public List<Person> readFile(String fileName) {
        CSVReader csvReader;
        List<Person> listBook = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(fileName);
            csvReader = new CSVReader(fileReader);

            if (csvReader.readNext() != null) {
                String[] line;

                while ((line = csvReader.readNext()) != null) {
                    int id = Integer.parseInt(line[0]);
                    String fullName = line[1];
                    String job = line[2];
                    String gender = line[3];
                    String city = line[4];
                    int salary = Integer.parseInt(line[5]);

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                    LocalDate birthday = LocalDate.parse(line[6], formatter);

                    Person newBook = new Person(id, fullName, job, gender, city, salary, birthday);
                    listBook.add(newBook);
                }
            } else {
                throw new RuntimeException("Empty CSV file");
            }

            csvReader.close();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }

        return listBook;
    }
}
