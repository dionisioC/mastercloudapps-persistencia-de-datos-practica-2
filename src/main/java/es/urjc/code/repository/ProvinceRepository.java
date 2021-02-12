package es.urjc.code.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import es.urjc.code.dtos.AutonomicCommunityAggregateDto;
import es.urjc.code.models.Provincia;

public interface ProvinceRepository extends MongoRepository<Provincia, String> {
    @Aggregation(pipeline = {"{ $group: { _id: $CA }}"})
    List<AutonomicCommunityAggregateDto> aggregationQuery();
}
