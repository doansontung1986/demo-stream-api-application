package vn.techmaster.demostreamapiapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    private int id;
    private String fullName;
    private String job;
    private String gender;
    private String city;
    private int salary;
    private LocalDate birthday;
}
