package es.urjc.code.models;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private String iataCode;
    private String name;
    private String city;
    private String country;

    @OneToMany(mappedBy = "airport")
    private List<TechnicalReview> technicalReviews;
}
