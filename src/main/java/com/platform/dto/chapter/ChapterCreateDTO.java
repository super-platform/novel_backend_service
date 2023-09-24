package com.platform.dto.chapter;

import com.platform.common.enums.NovelStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ChapterCreateDTO {
    private String title;
    private Long episode;
    private Long totalWord;
    private Long totalView;
    private String schedule;
    private String content;
    private Long novelId;
}
