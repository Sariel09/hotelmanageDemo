package com.demo.sariel.service;

import com.demo.sariel.Mapper.InfoMapper;
import com.demo.sariel.pojo.Information;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InfoService {

    @Resource
    InfoMapper infoMapper;

    public List<Information> SelectAll(){
        return infoMapper.SelectAll();
    }

    public Integer SelectByCount(){
        return infoMapper.SelectByCount();
    }

    public Information SelectById(String cno){
        return infoMapper.SelectById(cno);
    }

    public void InsertByInformation(Information information){
        infoMapper.InsertByInformation(information);
    }
}
