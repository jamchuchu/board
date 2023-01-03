package com.hyemin_board.demo.Service;

import com.hyemin_board.demo.DTO.LoginDto;
import com.hyemin_board.demo.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;

    public void saveInfo(LoginDto loginDto){
        loginRepository.addInfo(loginDto);
    }
    public LoginDto getLoginInfoById(String id){
        return loginRepository.getLoginInfoById(id);
    }
}


