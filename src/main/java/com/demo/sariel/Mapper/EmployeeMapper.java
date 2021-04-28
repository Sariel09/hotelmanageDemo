package com.demo.sariel.Mapper;


import com.demo.sariel.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {

    List<Employee> queryEmployeeList();

    Employee queryEmployeeById(int id);

    int addEmployee(Employee employee);

    int updateEmployee(Employee employee);

    int deleteEmployee(int id);
}
