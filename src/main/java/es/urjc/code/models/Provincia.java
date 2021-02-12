package es.urjc.code.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Provincia {

    @Id
    private String id;

    @Field("Nombre")
    private String name;

    @Field("CA")
    private String autonomousCommunity;

    @Field("Superficie")
    private int area;

    @Field("Datos")
    private List<ProvinceData> data;


}
