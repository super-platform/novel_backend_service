package com.platform.mappers;

import com.platform.common.mapper.BaseMapper;
import com.platform.dto.novel.NovelCreateDTO;
import com.platform.dto.novel.NovelDTO;
import com.platform.entities.postgres.Novel;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface NovelMapper extends BaseMapper<Novel, NovelDTO, NovelCreateDTO>  {
}
