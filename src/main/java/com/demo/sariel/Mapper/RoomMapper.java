package com.demo.sariel.Mapper;

import com.demo.sariel.pojo.Room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoomMapper {

    List<Room> SelectAll();

    Integer SelectByCount();

    Room SelectById(String rno);

    void InsertByRoom(Room room);
    List<Room> SelectByEmpty();

    void UpdateByRno(String rno);
}