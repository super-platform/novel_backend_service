package com.platform.entities.postgres;

import com.platform.common.entities.BaseEntity;
import com.platform.common.enums.NovelStatus;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.List;

@Entity
@Table(name = "novels")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Novel extends BaseEntity {
    @Column(name = "title")
    private String title;

    @Column(name = "status")
    private NovelStatus status;

    @Column(name = "cover_image")
    private String coverImage;

    @Column(name = "total_word")
    private Long totalWord;

    @Column(name = "total_chapter")
    private Long totalChapter;

    @Column(name = "total_like")
    private Long totalLike;

    @Column(name = "total_view")
    private Long totalView;

    @Column(name = "total_vote")
    private Long totalVote;

    @Column(name = "overview", columnDefinition = "text")
    private String overview;

    @Type(StringArrayType.class)
    @Column(
            name = "tags",
            columnDefinition = "text[]"
    )
    private String[] tags;

    // Relational region

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @OneToMany(mappedBy = "novel", fetch = FetchType.LAZY)
    private List<Chapter> chapters;
}
