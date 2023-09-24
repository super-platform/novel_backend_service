package com.platform.mappers;

import com.platform.common.mapper.BaseMapper;
import com.platform.dto.author.AuthorCreateDTO;
import com.platform.dto.author.AuthorDTO;
import com.platform.entities.postgres.Author;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AuthorMapper extends BaseMapper<Author, AuthorDTO, AuthorCreateDTO> {
}
