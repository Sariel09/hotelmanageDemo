package com.demo.sariel.service;

import com.demo.sariel.Mapper.RoomMapper;
import com.demo.sariel.pojo.Room;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoomService {

    @Resource
    RoomMapper roomMapper;

    @Autowired
    AmqpTemplate rabbitTemplate;

    public List<Room> SelectAll(){
        return roomMapper.SelectAll();
    }

    public Integer SelectByCount(){
        return roomMapper.SelectByCount();
    }
    @Cacheable(value = "room" , key = "#query")
    public Room SelectById(String query){
        return roomMapper.SelectById(query);
    }

    @RabbitListener(queues = "addroom")
    public void InsertByRoom(Room room){
        roomMapper.InsertByRoom(room);
    }

    public List<Room> SelectByEmpty(){
        return roomMapper.SelectByEmpty();
    }
    public void UpdateByRno(String rno){
        roomMapper.UpdateByRno(rno);
    }

}
