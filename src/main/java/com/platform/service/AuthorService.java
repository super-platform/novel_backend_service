package com.platform.service;

import com.platform.common.dto.author.AuthorCreateDTO;
import com.platform.common.dto.author.AuthorDTO;
import com.platform.entities.postgres.Author;

public interface AuthorService extends BaseCrudService<Author, AuthorDTO, AuthorCreateDTO> {
}
