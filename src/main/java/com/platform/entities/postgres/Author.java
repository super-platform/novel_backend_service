package com.platform.entities.postgres;


import com.platform.common.entities.BaseEntity;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.List;


@Entity
@Table(name = "authors")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Author extends BaseEntity {

    @Column(name = "pseudonym")
    private String pseudonym;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "year_of_birth")
    private String yearOfBirth;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "ethnic")
    private String ethnic;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "overview", columnDefinition = "text")
    private String overview;

    @Type(StringArrayType.class)
    @Column(
            name = "tags",
            columnDefinition = "text[]"
    )
    private String[] tags;

    // Relational region

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Novel> novels;
}
