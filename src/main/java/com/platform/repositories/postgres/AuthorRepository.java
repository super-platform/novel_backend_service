package com.platform.repositories.postgres;

import com.platform.entities.postgres.Author;
import com.platform.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends BaseRepository<Author> {
}
