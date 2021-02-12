package es.urjc.code.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProvinceData {

    @Field("Anyo")
    private int year;

    @Field("Valor")
    private int value;

}
