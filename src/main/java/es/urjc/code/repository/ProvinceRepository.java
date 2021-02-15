package es.urjc.code.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import es.urjc.code.dtos.AutonomicCommunityAggregateDto;
import es.urjc.code.models.Provincia;

public interface ProvinceRepository extends MongoRepository<Provincia, String> {
    @Aggregation(pipeline = {"{$project: {Nombre: 1, CA: { $ifNull: [ $CA, 'Sin comunidad' ]}}}","{ $group: { _id: $CA, numberOfProvinces:{$sum:1} }}"})
    List<AutonomicCommunityAggregateDto> numberOfProvincesPerAutonomicCommunity();
}
