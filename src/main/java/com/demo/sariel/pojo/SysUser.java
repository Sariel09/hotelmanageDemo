package com.demo.sariel.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser {

    private Long userId;
    private String username;
    private String password;
    private String userRole;
}
