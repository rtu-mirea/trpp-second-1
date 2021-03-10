package ru.mirea.trpp_second_1.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/** Сущность сотрудника. */
@Getter
@Setter
@ToString
public class Employee {

    /** Идентификатор. */
    @JsonProperty("id")
    @CsvBindByName(column = "id")
    private Long id;
    /** email. */
    @JsonProperty("email")
    @CsvBindByName(column = "email")
    private String email;
    /** Имя. */
    @JsonProperty("firstName")
    @CsvBindByName(column = "first_name")
    private String firstName;
    /** Фамилия. */
    @JsonProperty("lastName")
    @CsvBindByName(column = "last_name")
    private String lastName;
    /** Дата рождения. */
    @JsonProperty("birthDate")
    @CsvBindByName(column = "birth_date")
    private String birthDate;
    /** Место работы. */
    @JsonProperty("company")
    @CsvBindByName(column = "company")
    private String company;
    /** Департамент. */
    @JsonProperty("department")
    @CsvBindByName(column = "department")
    private String department;

}
