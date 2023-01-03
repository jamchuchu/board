package com.hyemin_board.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BoardDto {
    private int boardNum;
    private String title;
    private String content;
    private String author;
    private String date;
    private int viewNum;

}