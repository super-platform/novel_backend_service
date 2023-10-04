package com.platform.service;

import com.platform.dto.novel.NovelCreateDTO;
import com.platform.dto.novel.NovelDTO;
import com.platform.entities.postgres.Novel;

public interface NovelService extends BaseCrudService<Novel, NovelDTO, NovelCreateDTO> {
}
