package com.platform.service.impl;

import com.platform.common.dto.chapter.ChapterCreateDTO;
import com.platform.common.dto.chapter.ChapterDTO;
import com.platform.entities.postgres.Chapter;
import com.platform.entities.postgres.Novel;
import com.platform.entities.postgres.QChapter;
import com.platform.mapper.BaseMapper;
import com.platform.repositories.postgres.NovelRepository;
import com.platform.repository.BaseRepository;
import com.platform.service.ChapterService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChapterServiceImpl extends BaseCrudServiceImpl<Chapter, QChapter, ChapterDTO, ChapterCreateDTO> implements ChapterService {
    private final NovelRepository novelRepository;
    public ChapterServiceImpl(BaseRepository<Chapter> repository, BaseMapper<Chapter, ChapterDTO, ChapterCreateDTO> mapper, NovelRepository novelRepository) {
        super(repository, mapper);
        this.novelRepository = novelRepository;
    }

    @Override
    protected Chapter executeSqlRelationalLogic(ChapterCreateDTO createDTO) {
        // Mapping
        Chapter entity = mapper.createDTOToEntity(createDTO);

        // Save relational author to Novel
        if(createDTO.getNovelId() != null){
            Optional<Novel> optionalNovel = novelRepository.findById(createDTO.getNovelId());
            if (optionalNovel.isPresent()){
                entity.setNovel(optionalNovel.get());
            }
        }

        // Return
        return repository.save(entity);
    }
}
