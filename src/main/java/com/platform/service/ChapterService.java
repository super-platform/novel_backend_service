package com.platform.service;

import com.platform.common.service.BaseCrudService;
import com.platform.dto.chapter.ChapterCreateDTO;
import com.platform.dto.chapter.ChapterDTO;
import com.platform.entities.postgres.Chapter;

public interface ChapterService extends BaseCrudService<Chapter, ChapterDTO, ChapterCreateDTO> {
}
