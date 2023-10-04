package com.platform.service.impl;

import com.platform.common.dto.novel.NovelCreateDTO;
import com.platform.common.dto.novel.NovelDTO;
import com.platform.entities.postgres.Author;
import com.platform.entities.postgres.Novel;
import com.platform.entities.postgres.QNovel;
import com.platform.mappers.NovelMapper;
import com.platform.repositories.postgres.AuthorRepository;
import com.platform.repositories.postgres.NovelRepository;
import com.platform.service.NovelService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NovelServiceImpl extends BaseCrudServiceImpl<Novel, QNovel, NovelDTO, NovelCreateDTO> implements NovelService {

    private final AuthorRepository authorRepository;

    public NovelServiceImpl(NovelRepository repository, NovelMapper mapper, AuthorRepository authorRepository) {
        super(repository, mapper);
        this.authorRepository = authorRepository;
    }


    @Override
    protected Novel executeSqlRelationalLogic(NovelCreateDTO createDTO) {
        // Mapping
        Novel entity = mapper.createDTOToEntity(createDTO);

        // Save relational author to Novel
        if(createDTO.getAuthorId() != null){
            Optional<Author> optionalAuthor = authorRepository.findById(createDTO.getAuthorId());
            if (optionalAuthor.isPresent()){
                entity.setAuthor(optionalAuthor.get());
            }
        }

        // Return
        return repository.save(entity);
    }
}
