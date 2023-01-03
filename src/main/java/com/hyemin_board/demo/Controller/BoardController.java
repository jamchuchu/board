package com.hyemin_board.demo.Controller;

import com.hyemin_board.demo.DTO.BoardDto;
import com.hyemin_board.demo.DTO.CommentDto;
import com.hyemin_board.demo.Service.BoardService;
import com.hyemin_board.demo.Service.CommentService;
import com.hyemin_board.demo.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;
    @Autowired
    CommentService commentService;



    @GetMapping("/board/write")
    public String boardWrite(){
        return "boardWrite";
    }

    @PostMapping("/board/save")
    public String articleSave(BoardDto boardDto){
        boardDto.setAuthor(LoginController.loginId);
        boardDto.setDate(LocalDate.now().toString());
        boardService.saveBoard(boardDto);
        return "redirect:/board/list";
    }

    @GetMapping("/board/view/{boardNum}")
    public String boardView(@PathVariable int boardNum, Model model){
        boardService.addViewNum(boardNum);
        model.addAttribute("commentList", commentService.getCommentsByBoardNum(boardNum));
        model.addAttribute("article",boardService.getBoardByBoardNum(boardNum));
        return "boardView";
    }

    @GetMapping("/board/list")
    public String boardListView(Model model){
        model.addAttribute("list", boardService.getBoards());
        model.addAttribute("loginId", LoginController.loginId);
        return "mainList";
    }

    @GetMapping("/board/delete/{boardNum}")
    public String boardDelete(@PathVariable int boardNum){
        boardService.removeBoardbyBoardNum(boardNum);
        return "redirect:/board/list";
    }

    @GetMapping("/board/modify/{boardNum}")
    public String boardModifyInput(@PathVariable int boardNum, Model model){
        model.addAttribute("loginId", LoginController.loginId);
        model.addAttribute("article", boardService.getBoardByBoardNum(boardNum));
        return "boardModify";
    }

    @PostMapping("/board/modify/post/{boardNum}")
    public String boardModifyPost(@PathVariable int boardNum, BoardDto boardDto){
        boardService.modifyBoard(boardDto);
        return "redirect:/board/view/{boardNum}";
    }

    @PostMapping("/board/list/search")
    public String boardSearch(String searchText, Model model){
        if(searchText != null){
            model.addAttribute("list", boardService.searchByTitle(searchText));
        }else{
           model.addAttribute("list", boardService.getBoards());
        }
        return "mainList";
    }

    @GetMapping("/board/view/comment/{boardNum}")
    public String boardcommentView(@PathVariable int boardNum, Model model){
        model.addAttribute("commentList", commentService.getCommentsByBoardNum(boardNum));
        model.addAttribute("article",boardService.getBoardByBoardNum(boardNum));
        return "boardView";
    }

    @PostMapping("/board/comment/{boardNum}")
    public String commentAdd(@PathVariable int boardNum, String commentBox){
        if (commentBox.equals("")){
            return "redirect:/board/view/comment/{boardNum}";
        }
        CommentDto commentDto = new CommentDto();
        commentDto.setArticleNum(boardNum);
        commentDto.setAuthor(LoginController.loginId);
        commentDto.setContent(commentBox);
        commentDto.setDate(LocalDate.now().toString());
        commentService.addComment(commentDto);
        return "redirect:/board/view/comment/{boardNum}";
    }

    @GetMapping("/comment/goodUp")
    public String commentGoodUp(int boardNum, int number){
        commentService.goodUpByNumber(number);
        return "redirect:/board/view/comment/"+ boardNum;
    }

    @GetMapping("/comment/badUp")
    public String commentBadUp(int boardNum, int number){
        commentService.badUpByNumber(number);
        return "redirect:/board/view/comment/"+ boardNum;
    }

    @GetMapping("/comment/modify")
    public String commentBoxInput(int boardNum, int number, Model model){
        model.addAttribute("commentList", commentService.getCommentsByBoardNum(boardNum));
        model.addAttribute("article",boardService.getBoardByBoardNum(boardNum));
        model.addAttribute("modifyComment",commentService.getCommentByNumber(number));
        return "boardViewModifyComment";
    }

    @PostMapping("/board/comment/modify")
    public String modifycomment(int boardNum, int number, String commentBox) {
        commentService.modifyComment(number, commentBox);
        return "redirect:/board/view/comment/"+ boardNum;
    }









}
