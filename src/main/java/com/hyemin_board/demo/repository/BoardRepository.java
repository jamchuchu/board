package com.hyemin_board.demo.repository;

import com.hyemin_board.demo.DTO.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface BoardRepository{

    public int saveBoard(BoardDto boardDto);
    public List<BoardDto> getBoards();
    public BoardDto getBoardByBoardNum(int boardNum);
    public int addViewNum(int boardNum);
    public int deleteBoard(int boardNum);
    public int modifyTitle(BoardDto boardDto);
    public int modifyContent(BoardDto boardDto);
    public List<BoardDto> searchByTitle(String searchText);
}
