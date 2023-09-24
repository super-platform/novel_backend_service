package com.platform.service;

import com.platform.common.service.BaseCrudService;
import com.platform.dto.author.AuthorCreateDTO;
import com.platform.dto.author.AuthorDTO;
import com.platform.entities.postgres.Author;

public interface AuthorService extends BaseCrudService<Author, AuthorDTO, AuthorCreateDTO> {
}
