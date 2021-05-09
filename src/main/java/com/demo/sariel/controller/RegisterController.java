package com.demo.sariel.controller;

import com.demo.sariel.Mapper.SysUserMapper;
import com.demo.sariel.pojo.SysUser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class RegisterController {
    @Resource
    private SysUserMapper sysUserMapper;

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/register-error")
    public String registerError(Model model) {
        // Model 的作用是往 Web 页面穿数据
        // model 添加一个参数 error 其作用是如果此参数为 true，就显示下面一行 HTML 代码
        // <p th:if="${error}" class="error">注册错误</p>
        model.addAttribute("error", true);
        return "register";
    }

    @RequestMapping("/register-save")
    public String registerSave(@ModelAttribute SysUser sysUser,
                               Model model) {
        // 判断 username password 不能为空
        if (sysUser.getUsername() == null || sysUser.getPassword() == null || sysUser.getUserRole() == null) {
            model.addAttribute("error", true);
            return "register";
        }
        try {
            // 密码加密存储
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String password = bCryptPasswordEncoder.encode(sysUser.getPassword());
            sysUser.setPassword(password);
            // 写入数据库
            sysUserMapper.insert(sysUser);
            //  重定向到 login 页面
            return "redirect=/login.html";
        } catch (Exception e) {
            // 注册错误
            model.addAttribute("error", true);
            return "register";
        }
    }
}


