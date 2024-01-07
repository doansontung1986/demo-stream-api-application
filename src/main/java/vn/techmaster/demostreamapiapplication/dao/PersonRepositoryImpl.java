package vn.techmaster.demostreamapiapplication.dao;

import org.springframework.stereotype.Repository;
import vn.techmaster.demostreamapiapplication.database.PersonDB;
import vn.techmaster.demostreamapiapplication.model.Person;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PersonRepositoryImpl implements PersonRepositoryInterface {

    @Override
    public void printListPeople(List<Person> persons) {
        persons.forEach(System.out::println);
    }

    @Override
    public List<Person> getAll() {
        return PersonDB.personList.stream().toList();
    }

    @Override
    public List<Person> sortPeopleByFullName() {
        return PersonDB.personList.stream().sorted((person1, person2) -> person1.getFullName().compareToIgnoreCase(person2.getFullName())).collect(Collectors.toList());
    }

    @Override
    public List<Person> sortPeopleByFullNameReversed() {
        return PersonDB.personList.stream().sorted((person1, person2) -> person2.getFullName().compareToIgnoreCase(person1.getFullName())).collect(Collectors.toList());
    }

    @Override
    public List<String> getSortedJobs() {
        return PersonDB.personList.stream().map(person -> person.getJob()).distinct().sorted().collect(Collectors.toList());
    }

    @Override
    public List<String> getSortedCities() {
        return PersonDB.personList.stream().map(person -> person.getCity()).distinct().sorted().collect(Collectors.toList());
    }

    @Override
    public List<String> femaleNames() {
        return PersonDB.personList.stream().filter(person -> person.getGender().equalsIgnoreCase("Female")).map(person -> person.getFullName()).collect(Collectors.toList());
    }

    @Override
    public Person highestEarner() {
        return PersonDB.personList.stream().max(Comparator.comparingInt(Person::getSalary)).orElse(null);
    }

    @Override
    public List<Person> bornAfter1990() {
        return PersonDB.personList.stream().filter(person -> person.getBirthday().getYear() < 1990).collect(Collectors.toList());
    }

    @Override
    public double averageSalary() {
        return (double) PersonDB.personList.stream().map(person -> person.getSalary()).reduce(0, (sum, salary) -> sum + salary, Integer::sum) / PersonDB.personList.size();
    }

    @Override
    public double averageAge() {
        return (double) PersonDB.personList.stream().map(person -> LocalDate.now().getYear() - person.getBirthday().getYear()).reduce(0, (sum, age) -> sum + age, Integer::sum) / PersonDB.personList.size();
    }

    @Override
    public List<Person> nameContains(String keyword) {
        return PersonDB.personList.stream().filter(person -> person.getFullName().contains(keyword)).collect(Collectors.toList());
    }

    @Override
    public List<Person> sortedByAgeForMale() {
        return PersonDB.personList.stream().filter(person -> person.getGender().equalsIgnoreCase("Male")).sorted(Comparator.comparingInt(person -> person.getBirthday().getYear())).collect(Collectors.toList());
    }

    @Override
    public Person longestName() {
        return PersonDB.personList.stream().max(Comparator.comparing(person -> person.getFullName().length())).orElse(null);
    }

    @Override
    public List<Person> aboveAverageSalary() {
        double averageSalary = averageSalary();
        return PersonDB.personList.stream().filter(person -> person.getSalary() > averageSalary).collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Person>> groupPeopleByCity() {
        return PersonDB.personList.stream().collect(Collectors.groupingBy(Person::getCity));
    }

    @Override
    public Map<String, Long> groupJobByCount() {
        return PersonDB.personList.stream().collect(Collectors.groupingBy(Person::getJob, Collectors.counting()));
    }

    @Override
    public List<Person> inSalaryRange(int start, int end) {
        return PersonDB.personList.stream().filter(person -> person.getSalary() >= start && person.getSalary() <= end).collect(Collectors.toList());
    }

    @Override
    public List<Person> startsWith(String prefix) {
        return PersonDB.personList.stream().filter(person -> person.getFullName().startsWith(prefix)).collect(Collectors.toList());
    }

    @Override
    public List<Person> sortByBirthYearDescending() {
        return PersonDB.personList.stream().sorted((Comparator.comparingInt(person -> person.getBirthday().getYear()))).collect(Collectors.toList());
    }

    @Override
    public List<Person> top5HighestPaid() {
        return PersonDB.personList.stream().sorted((Comparator.comparingInt(Person::getSalary).reversed())).limit(5).collect(Collectors.toList());
    }

    @Override
    public List<Person> inAgeRange(int start, int end) {
        return PersonDB.personList.stream().filter(person -> LocalDate.now().getYear() - person.getBirthday().getYear() >= start && LocalDate.now().getYear() - person.getBirthday().getYear() <= end).collect(Collectors.toList());
    }
}
