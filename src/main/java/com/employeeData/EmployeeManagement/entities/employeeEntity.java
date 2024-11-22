//entity is what which directly deals with database

package com.employeeData.EmployeeManagement.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@Table(name="employees")  // Table name
@NoArgsConstructor   // constructor which automatically created with no argument
@AllArgsConstructor
public class employeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDate doj;
    @JsonProperty("isActive")
    private boolean isActive;
}
