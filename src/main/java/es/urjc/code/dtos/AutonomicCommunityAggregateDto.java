package es.urjc.code.dtos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutonomicCommunityAggregateDto {

    @Id
    @Field("name")
    private String name;

    @Field("numberOfProvinces")
    private int numberOfProvinces;
}
