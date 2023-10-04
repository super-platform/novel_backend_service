package com.platform.dto.chapter;


import com.platform.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class ChapterDTO extends BaseDTO {
    private String title;
    private Long episode;
    private Long totalWord;
    private Long totalView;
    private String schedule;
    private String content;
}
