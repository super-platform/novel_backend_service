package com.platform.repositories.postgres;

import com.platform.entities.postgres.Chapter;
import com.platform.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterRepository extends BaseRepository<Chapter> {
}
