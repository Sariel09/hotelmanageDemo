package com.demo.sariel.Mapper;

import com.demo.sariel.pojo.Information;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InfoMapper {

    List<Information> SelectAll();

    Integer SelectByCount();

    Information SelectById(String cno);

    void InsertByInformation(Information information);
}
