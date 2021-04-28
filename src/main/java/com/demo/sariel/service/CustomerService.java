package com.demo.sariel.service;

import com.demo.sariel.Mapper.CustomerMapper;
import com.demo.sariel.pojo.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerService {

    @Resource
    CustomerMapper customerMapper;


    public List<Customer> SelectAll(){
        return customerMapper.SelectAll();
    }

    public Integer SelectByCount(){
        return customerMapper.SelectByCount();
    }

    public Customer SelectById(String cno){
        return customerMapper.SelectById(cno);
    }

    public void InsertByCustomer(Customer customer){
        customerMapper.InsertByCustomer(customer);
    }
}