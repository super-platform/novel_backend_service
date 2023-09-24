package com.platform.repositories.postgres;

import com.platform.common.repository.BaseRepository;
import com.platform.entities.postgres.Author;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends BaseRepository<Author> {
}
