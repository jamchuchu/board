package com.hyemin_board.demo.Controller;

import com.hyemin_board.demo.DTO.LoginDto;
import com.hyemin_board.demo.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    public static String loginId = "qwer";

    @GetMapping("/board/login")
    public String login(){
        return "login/loginPage";
    }

    @GetMapping("/board/logout")
    public String logout(){
        loginId = null;
        return "login/loginPage";
    }

    @PostMapping("/board/login/post")
    public String loginInput(LoginDto loginDto){
        String returnByError = "login/loginPageReturn";
        try{
            LoginDto correctLoginInfo = loginService.getLoginInfoById(loginDto.getId());
            if(loginDto.getPassword().equals(correctLoginInfo.getPassword())){
                loginId = loginDto.getId();
                return "redirect:/board/list";
            }
        }catch(Exception e){
        }
        return returnByError;
    }

    @GetMapping("/board/signup")
    public String signUp(){
        return "login/signUp";
    }

    @PostMapping("/board/signup/post")
    public String saveLoginInfo(LoginDto loginDto){
        loginService.saveInfo(loginDto);
        return "login/signupResult";
    }
}
