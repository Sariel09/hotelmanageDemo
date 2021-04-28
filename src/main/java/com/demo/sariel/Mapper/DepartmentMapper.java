package com.demo.sariel.Mapper;


import com.demo.sariel.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {

    List<Department> queryDepartmentList();

    Department queryDepartmentById(int id);

    Department queryDepartmentName(Department department);


}
