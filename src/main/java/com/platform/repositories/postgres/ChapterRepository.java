package com.platform.repositories.postgres;

import com.platform.common.repository.BaseRepository;
import com.platform.entities.postgres.Chapter;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterRepository extends BaseRepository<Chapter> {
}
