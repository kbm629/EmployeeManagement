// employee DTO is which user can add into the post Request

package com.employeeData.EmployeeManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class employeeDTO {

    private Long id;
    private String name;
    private LocalDate doj;
    private boolean isActive;
}
