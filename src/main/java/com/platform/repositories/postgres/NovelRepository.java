package com.platform.repositories.postgres;

import com.platform.common.repository.BaseRepository;
import com.platform.entities.postgres.Novel;
import org.springframework.stereotype.Repository;

@Repository
public interface NovelRepository extends BaseRepository<Novel> {
}