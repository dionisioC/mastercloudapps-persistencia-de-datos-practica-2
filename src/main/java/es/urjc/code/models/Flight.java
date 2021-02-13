package es.urjc.code.models;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Flight {

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
    private String flightCode;
    private String airline;

    @ManyToOne
    private Airplane airplane;

    @ManyToOne
    private Airport originAirport;

    @ManyToOne
    private Airport destinationAirport;

    @Temporal(TemporalType.TIMESTAMP)
    private Date departureDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalDate;

    private Float flightDuration;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flight")
    private List<CrewMemberFlight> crewMembers;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private Long[] crewMembersId;
}
