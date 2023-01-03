package com.hyemin_board.demo.repository;

import com.hyemin_board.demo.DTO.CommentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentRepository {
    public int saveComment(CommentDto commentDto);
    public List<CommentDto> getCommentsByBoardNum(int boardNum);
    public CommentDto getCommentByNumber(int number);
    public void goodUpByNumber(int number);
    public void badUpByNumber(int number);
    public void modifyCommentbyNumber(int number, String content);



}
