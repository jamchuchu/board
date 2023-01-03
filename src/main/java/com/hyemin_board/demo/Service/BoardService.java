package com.hyemin_board.demo.Service;

import com.hyemin_board.demo.DTO.BoardDto;
import com.hyemin_board.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public int saveBoard(BoardDto boardDto){
        int num = 0;
        num = boardRepository.saveBoard(boardDto);
        return num;
    }

    public List<BoardDto> getBoards(){
        return boardRepository.getBoards();
    }

    public BoardDto getBoardByBoardNum(int boardNum){
        return boardRepository.getBoardByBoardNum(boardNum);
    }

    public void addViewNum(int boardNum){
        boardRepository.addViewNum(boardNum);
    }

    public void removeBoardbyBoardNum(int boardNum){
        boardRepository.deleteBoard(boardNum);
    }

    public void modifyBoard(BoardDto boardDtopost){
        boardRepository.modifyTitle(boardDtopost);
        boardRepository.modifyContent(boardDtopost);
    }

    public List<BoardDto> searchByTitle(String searchText){
        return boardRepository.searchByTitle(searchText);
    }

}
