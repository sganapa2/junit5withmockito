package org.junit.mockito;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    int employeeId;
    String name;
    double salary;
    int numberOfWorkDays;
}
