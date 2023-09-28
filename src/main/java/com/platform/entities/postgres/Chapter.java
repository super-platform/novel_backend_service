package com.platform.entities.postgres;

import com.platform.common.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "chapters")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Chapter extends BaseEntity {
    @Column(name = "title")
    private String title;

    @Column(name = "episode")
    private Long episode;

    @Column(name = "total_word")
    private Long totalWord;

    @Column(name = "total_view")
    private Long totalView;

    @Column(name = "schedule")
    private LocalDateTime schedule;

    @Column(name = "content", columnDefinition = "text")
    private String content;

    // Relational region

    @ManyToOne
    @JoinColumn(name = "novel_id", nullable = false)
    private Novel novel;
}
