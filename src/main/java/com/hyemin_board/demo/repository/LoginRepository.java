package com.hyemin_board.demo.repository;

import com.hyemin_board.demo.DTO.LoginDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginRepository {
    public int addInfo(LoginDto loginDto);
    public LoginDto getLoginInfoById(String id);

}
