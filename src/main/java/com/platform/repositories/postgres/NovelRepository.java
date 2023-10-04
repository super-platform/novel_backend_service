package com.platform.repositories.postgres;

import com.platform.entities.postgres.Novel;
import com.platform.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NovelRepository extends BaseRepository<Novel> {
}