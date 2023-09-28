package com.platform.dto.author;

import com.platform.common.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class AuthorDTO extends BaseDTO {
    private String pseudonym;

    private String fullName;

    private String avatar;

    private String yearOfBirth;

    private Double rating;

    private String nationality;

    private String ethnic;

    private String birthPlace;

    private String occupation;
    private String overview;
    private String[] tags;
}
