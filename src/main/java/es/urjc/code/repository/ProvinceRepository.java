package es.urjc.code.repository;

import es.urjc.code.models.Provincia;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProvinceRepository extends MongoRepository<Provincia, String> {
}
