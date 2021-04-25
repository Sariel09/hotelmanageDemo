package com.demo.sariel.controller;

import com.demo.sariel.Mapper.DepartmentMapper;
import com.demo.sariel.Mapper.EmployeeMapper;
import com.demo.sariel.dao.DepartmentDao;
import com.demo.sariel.pojo.Department;
import com.demo.sariel.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.sql.DataSource;
import java.sql.Date;
import java.text.DateFormat;
import java.util.Collection;
import java.util.List;

@Controller
public class EmployeeControler {


    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    @RequestMapping("/emps")
    public String queryEmployee(Model model){
        Collection<Employee> employeeList = employeeMapper.queryEmployeeList();
        model.addAttribute("emps",employeeList);

        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddpage(Model model){
        Collection<Department> departments = departmentMapper.queryDepartmentList();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("save=>"+employee);
        employeeMapper.addEmployee(employee);
        return "redirect:/emps";

    }

    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id, Model model) {
        Employee employee = employeeMapper.queryEmployeeById(id);
        model.addAttribute("emp", employee);

        Collection<Department> departments = departmentMapper.queryDepartmentList();
        model.addAttribute("departments",departments);

        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeMapper.updateEmployee(employee);
        return "redirect:/emps";
    }
    @GetMapping("/addEmp")
    public String addEmp(){
        employeeMapper.addEmployee(new Employee(1,"AA","123@qq.com",1,"101",new Date(2020,01,01)));
        return "ok";
    }

    @GetMapping("/delEmp/{id}")
    public String deleteEmp(@PathVariable("id") int id){
        employeeMapper.deleteEmployee(id);
        return "redirect:/emps";

    }
    @GetMapping("/queryDepartmentList")
    public List<Department> queryDepartmentList(){
        List<Department> departmentList=departmentMapper.queryDepartmentList();
        for (Department department : departmentList);
            System.out.println(departmentList);
            return departmentList;
    }

}
