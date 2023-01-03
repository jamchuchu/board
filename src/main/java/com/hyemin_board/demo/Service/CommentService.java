package com.hyemin_board.demo.Service;

import com.hyemin_board.demo.DTO.CommentDto;
import com.hyemin_board.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public void addComment(CommentDto commentDto){
        commentRepository.saveComment(commentDto);
    }

    public List<CommentDto> getCommentsByBoardNum(int boardNum){
        return commentRepository.getCommentsByBoardNum(boardNum);
    }

    public CommentDto getCommentByNumber(int number){
        return commentRepository.getCommentByNumber(number);
    }

    public void goodUpByNumber(int number){
        commentRepository.goodUpByNumber(number);
    }

    public void badUpByNumber(int number){
        commentRepository.badUpByNumber(number);
    }

    public void modifyComment(int number, String content){
        commentRepository.modifyCommentbyNumber(number, content);
    }
}
