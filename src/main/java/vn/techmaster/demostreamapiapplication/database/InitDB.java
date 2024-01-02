package vn.techmaster.demostreamapiapplication.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import vn.techmaster.demostreamapiapplication.model.Person;
import vn.techmaster.demostreamapiapplication.utils.IFileReader;

import java.util.List;

@Configuration
public class InitDB implements CommandLineRunner {

    @Autowired
    private IFileReader fileReader;

    private final String PERSON_DATA_FILE = "src/main/resources/personsmall.csv";

    @Override
    public void run(String... args) {
        PersonDB.personList = loadDataFromCSV(PERSON_DATA_FILE);
    }

    private List<Person> loadDataFromCSV(String fileName) {
        return fileReader.readFile(fileName);
    }
}
