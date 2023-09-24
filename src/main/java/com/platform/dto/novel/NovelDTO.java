package com.platform.dto.novel;

import com.platform.common.dto.response.BaseDTO;
import com.platform.common.enums.NovelStatus;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

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
    private String[] tags;
}
