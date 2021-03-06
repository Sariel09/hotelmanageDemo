package com.demo.sariel.dao;

import com.demo.sariel.pojo.Employee;
import com.demo.sariel.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Repository
public class EmployeeDao {

    private static Map<Integer,Employee> employees=null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees=new HashMap<Integer, Employee>();

        employees.put(1001,new Employee(1001,"AA","A1223356737@qq.com",1,new Department(101,"后勤部")));
        employees.put(1002,new Employee(1002,"BB","B1223356737@qq.com",1,new Department(101,"后勤部")));
        employees.put(1003,new Employee(1003,"CC","C1223356737@qq.com",0,new Department(101,"后勤部")));
        employees.put(1004,new Employee(1004,"DD","D1223356737@qq.com",1,new Department(101,"后勤部")));
        employees.put(1005,new Employee(1005,"EE","E1223356737@qq.com",0,new Department(101,"后勤部")));
    }

    public static Integer initId=1006;

    public void save(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }

    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    public void delete(Integer id){
        employees.remove(id);
    }
}

