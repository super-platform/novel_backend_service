package com.platform.dto.novel;

import com.platform.common.enums.NovelStatus;
import com.platform.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class NovelDTO extends BaseDTO {
    private String title;
    private NovelStatus status;
    private String coverImage;
    private Long totalWord;
    private Long totalChapter;
    private Long totalLike;
    private Long totalView;
    private Long totalVote;
    private String overview;
    private Boolean crawling;
    private String[] tags;
}
