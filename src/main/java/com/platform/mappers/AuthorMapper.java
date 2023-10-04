package com.platform.mappers;

import com.platform.common.dto.author.AuthorCreateDTO;
import com.platform.common.dto.author.AuthorDTO;
import com.platform.entities.postgres.Author;
import com.platform.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AuthorMapper extends BaseMapper<Author, AuthorDTO, AuthorCreateDTO> {
}
