package com.platform.mappers;

import com.platform.common.dto.chapter.ChapterCreateDTO;
import com.platform.common.dto.chapter.ChapterDTO;
import com.platform.entities.postgres.Chapter;
import com.platform.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ChapterMapper extends BaseMapper<Chapter, ChapterDTO, ChapterCreateDTO> {
}
