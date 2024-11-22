/* Service class which has a BUSSINESS LOGIC of main code
   Service layer take data as a DTO and then apply bussiness logic on it
   and then it convert it into entity which is compatible with given
   data-base like mySql and Mongodb
 */
package com.employeeData.EmployeeManagement.services;

import com.employeeData.EmployeeManagement.dto.employeeDTO;
import com.employeeData.EmployeeManagement.entities.employeeEntity;
import com.employeeData.EmployeeManagement.repositories.employeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class employeeService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    employeeRepository employeeDatabase;

    public employeeDTO getEmployeeById(Long Id)
    {
        // search entity data with database
        employeeEntity empEntity = employeeDatabase.getById(Id);

        // convert into DTO because DTO has only required field using modelmapper
        employeeDTO empDTO = modelMapper.map(empEntity,employeeDTO.class);
        return empDTO;
    }

    public List<employeeDTO> getAllEmployee()
    {
        // it used map and stream to doing same stuff on all the data
       return employeeDatabase.findAll().stream().map(empEntity -> modelMapper
               .map(empEntity,employeeDTO.class)).
               collect(Collectors.toList());
    }

    public employeeDTO createEmployee(employeeDTO empDTO)
    {
        employeeEntity empEntity=modelMapper.map(empDTO, employeeEntity.class);
        employeeEntity saveEntity = employeeDatabase.save(empEntity);
        return modelMapper.map(saveEntity,employeeDTO.class);
    }

    public String deleteEmployee(Long id)
    {
        employeeDatabase.deleteById(id);
        return "Done";
    }
}