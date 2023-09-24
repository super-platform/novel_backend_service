package com.platform.mappers;

import com.platform.common.mapper.BaseMapper;
import com.platform.dto.chapter.ChapterCreateDTO;
import com.platform.dto.chapter.ChapterDTO;
import com.platform.entities.postgres.Chapter;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ChapterMapper extends BaseMapper<Chapter, ChapterDTO, ChapterCreateDTO> {
}
