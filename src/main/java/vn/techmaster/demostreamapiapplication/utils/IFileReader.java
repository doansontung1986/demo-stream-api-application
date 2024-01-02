package vn.techmaster.demostreamapiapplication.utils;

import vn.techmaster.demostreamapiapplication.model.Person;

import java.util.List;

public interface IFileReader {
    List<Person> readFile(String fileName);
}
