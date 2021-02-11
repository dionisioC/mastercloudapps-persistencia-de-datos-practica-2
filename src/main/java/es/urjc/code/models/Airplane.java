package es.urjc.code.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private String licensePlate;
    private String manufacturer;
    private String model;
    private BigDecimal flightHours;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="checkedAirplane", orphanRemoval = true)
    private List<TechnicalReview> technicalReviews;
}
