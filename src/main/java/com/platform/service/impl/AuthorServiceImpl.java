package com.platform.service.impl;

import com.platform.common.dto.author.AuthorCreateDTO;
import com.platform.common.dto.author.AuthorDTO;
import com.platform.entities.postgres.Author;
import com.platform.entities.postgres.QAuthor;
import com.platform.mappers.AuthorMapper;
import com.platform.repositories.postgres.AuthorRepository;
import com.platform.service.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl extends BaseCrudServiceImpl<Author, QAuthor, AuthorDTO, AuthorCreateDTO> implements AuthorService {
    public AuthorServiceImpl(AuthorRepository repository, AuthorMapper mapper) {
        super(repository, mapper);
    }


    @Override
    protected Author executeSqlRelationalLogic(AuthorCreateDTO createDTO) {
        // Mapping
        Author entity = mapper.createDTOToEntity(createDTO);

        // Return
        return repository.save(entity);
    }
}
