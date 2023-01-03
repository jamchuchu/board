package com.hyemin_board.demo.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {
    private int number;
    private int articleNum;
    private String author;
    private String content;
    private String date;
    private int good;
    private int bad;
}
