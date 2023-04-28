package com.ecommerce.api.repositories.mongo;

import com.ecommerce.api.entities.Template;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TemplateRepository extends MongoRepository<Template, String> {

    Optional<Template> findTemplateByTest(String test);
}
