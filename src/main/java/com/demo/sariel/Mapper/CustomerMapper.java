package com.demo.sariel.Mapper;

import com.demo.sariel.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {

    List<Customer> SelectAll();

    Integer SelectByCount();

    Customer SelectById(String cno);

    void InsertByCustomer(Customer customer);
}