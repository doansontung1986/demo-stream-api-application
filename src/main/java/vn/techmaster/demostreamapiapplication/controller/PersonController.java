package vn.techmaster.demostreamapiapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.techmaster.demostreamapiapplication.model.Person;
import vn.techmaster.demostreamapiapplication.service.PersonService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("")
    public void printListPeople() {
        personService.printListPeople();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Person>> getAll() {
        return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/sortPeopleByFullName")
    public ResponseEntity<List<Person>> sortPeopleByFullName() {
        return new ResponseEntity<>(personService.sortPeopleByFullName(), HttpStatus.OK);
    }

    @GetMapping("/sortPeopleByFullNameReversed")
    public ResponseEntity<List<Person>> sortPeopleByFullNameReversed() {
        return new ResponseEntity<>(personService.sortPeopleByFullNameReversed(), HttpStatus.OK);
    }

    @GetMapping("/getSortedJobs")
    public ResponseEntity<List<String>> getSortedJobs() {
        return new ResponseEntity<>(personService.getSortedJobs(), HttpStatus.OK);
    }

    @GetMapping("/getSortedCities")
    public ResponseEntity<List<String>> getSortedCities() {
        return new ResponseEntity<>(personService.getSortedCities(), HttpStatus.OK);
    }

    @GetMapping("/femaleNames")
    public ResponseEntity<List<String>> femaleNames() {
        return new ResponseEntity<>(personService.femaleNames(), HttpStatus.OK);
    }

    @GetMapping("/highestEarner")
    public ResponseEntity<Person> highestEarner() {
        return new ResponseEntity<>(personService.highestEarner(), HttpStatus.OK);
    }

    @GetMapping("/bornAfter1990")
    public ResponseEntity<List<Person>> bornAfter1990() {
        return new ResponseEntity<>(personService.bornAfter1990(), HttpStatus.OK);
    }

    @GetMapping("/averageSalary")
    public ResponseEntity<Double> averageSalary() {
        return new ResponseEntity<>(personService.averageSalary(), HttpStatus.OK);
    }

    @GetMapping("/averageAge")
    public ResponseEntity<Double> averageAge() {
        return new ResponseEntity<>(personService.averageAge(), HttpStatus.OK);
    }

    @GetMapping("/nameContains/{keyword}")
    public ResponseEntity<List<Person>> nameContains(@PathVariable String keyword) {
        return new ResponseEntity<>(personService.nameContains(keyword), HttpStatus.OK);
    }

    @GetMapping("/sortedByAgeForMale")
    public ResponseEntity<List<Person>> sortedByAgeForMale() {
        return new ResponseEntity<>(personService.sortedByAgeForMale(), HttpStatus.OK);
    }

    @GetMapping("/longestName")
    public ResponseEntity<Person> longestName() {
        return new ResponseEntity<>(personService.longestName(), HttpStatus.OK);
    }

    @GetMapping("/aboveAverageSalary")
    public ResponseEntity<List<Person>> aboveAverageSalary() {
        return new ResponseEntity<>(personService.aboveAverageSalary(), HttpStatus.OK);
    }

    @GetMapping("/groupPeopleByCity")
    public ResponseEntity<Map<String, List<Person>>> groupPeopleByCity() {
        return new ResponseEntity<>(personService.groupPeopleByCity(), HttpStatus.OK);
    }

    @GetMapping("/groupJobByCount")
    public ResponseEntity<Map<String, Long>> groupJobByCount() {
        return new ResponseEntity<>(personService.groupJobByCount(), HttpStatus.OK);
    }

    @GetMapping("/inSalaryRange")
    public ResponseEntity<List<Person>> inSalaryRange(@RequestParam int start, @RequestParam int end) {
        return new ResponseEntity<>(personService.inSalaryRange(start, end), HttpStatus.OK);
    }

    @GetMapping("/startsWith/{prefix}")
    public ResponseEntity<List<Person>> startsWith(@PathVariable String prefix) {
        return new ResponseEntity<>(personService.startsWith(prefix), HttpStatus.OK);
    }

    @GetMapping("/sortByBirthYearDescending")
    public ResponseEntity<List<Person>> sortByBirthYearDescending() {
        return new ResponseEntity<>(personService.sortByBirthYearDescending(), HttpStatus.OK);
    }

    @GetMapping("/top5HighestPaid")
    public ResponseEntity<List<Person>> top5HighestPaid() {
        return new ResponseEntity<>(personService.top5HighestPaid(), HttpStatus.OK);
    }

    @GetMapping("/inAgeRange")
    public ResponseEntity<List<Person>> inAgeRange(@RequestParam int start, @RequestParam int end) {
        return new ResponseEntity<>(personService.inAgeRange(start, end), HttpStatus.OK);
    }
}
