package com.platform.service;

import com.platform.common.dto.novel.NovelCreateDTO;
import com.platform.common.dto.novel.NovelDTO;
import com.platform.entities.postgres.Novel;

public interface NovelService extends BaseCrudService<Novel, NovelDTO, NovelCreateDTO> {
}
