package es.urjc.code.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
}
