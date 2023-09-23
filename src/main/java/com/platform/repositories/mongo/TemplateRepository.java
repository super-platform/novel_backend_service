package com.platform.repositories.mongo;

import com.platform.entities.Template;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TemplateRepository extends MongoRepository<Template, String> {

    Optional<Template> findTemplateByTest(String test);
}
