package ru.mirea.trpp_second_1.controllers;


import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

/** Контроллер для работы с сотрудниками. */
@Controller("/employee")
public class EmployeeController {

    /** Список сотрудников. */
    private final List<Employee> employeeList;

    /** Конструктор. */
    public EmployeeController() {
        employeeList = new CsvToBeanBuilder<Employee>(new InputStreamReader(this.getClass().getResourceAsStream("/MOCK_DATA.csv"))).withType(Employee.class).build().parse();
    }

    /**
     * Получить список сотрудников.
     * @return список сотрудников
     */
    @Get()
    public HttpResponse<List<Employee>> getEmployee() {
        return HttpResponse.ok(employeeList);
    }

    /**
     * Найти сотрудника по идентификатору.
     * @param id идентификатор сотрудника
     * @return Пользователь, если есть, иначе 404 ошибка
     */
    @Get("/{id}")
    public HttpResponse<Employee> findById(Long id) {
        Optional<Employee> result = employeeList.stream().filter(it -> it.getId().equals(id)).findAny();
        if (result.isPresent()) {
            return HttpResponse.ok(result.get());
        } else {
            return HttpResponse.notFound();
        }
    }
}
