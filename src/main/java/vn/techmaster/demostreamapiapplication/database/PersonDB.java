package vn.techmaster.demostreamapiapplication.database;

import org.springframework.stereotype.Repository;
import vn.techmaster.demostreamapiapplication.model.Person;

import java.util.List;

@Repository
public class PersonDB {
    public static List<Person> personList;
}
