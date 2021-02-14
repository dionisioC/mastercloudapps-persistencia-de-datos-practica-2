package es.urjc.code.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Airplane {

    @Id
    @GeneratedValue(
        strategy = GenerationType.AUTO,
        generator = "native"
    )
    @GenericGenerator(
        name = "native",
        strategy = "native"
    )
    private long id;
    @Column(unique = true)
    private String licensePlate;
    private String manufacturer;
    private String model;
    private BigDecimal flightHours;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "checkedAirplane", orphanRemoval = true)
    private List<TechnicalReview> technicalReviews;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private String revisionSummary;
}
