package org.junit.mockito;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Employee {
    int employeeId;
    String name;
    double salary;
    int numberOfWorkDays;
}
