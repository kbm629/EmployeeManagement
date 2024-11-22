package com.employeeData.EmployeeManagement.repositories;

import com.employeeData.EmployeeManagement.entities.employeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employeeRepository extends JpaRepository<employeeEntity,Long> {
}
