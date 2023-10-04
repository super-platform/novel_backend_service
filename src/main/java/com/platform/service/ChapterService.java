package com.platform.service;

import com.platform.common.dto.chapter.ChapterCreateDTO;
import com.platform.common.dto.chapter.ChapterDTO;
import com.platform.entities.postgres.Chapter;

public interface ChapterService extends BaseCrudService<Chapter, ChapterDTO, ChapterCreateDTO> {
}
