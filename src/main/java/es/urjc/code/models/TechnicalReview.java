package es.urjc.code.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TechnicalReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date startDate;
    private Date endDate;
    private Integer spentHoursOnReview;
    private String reviewType;
    private String workDescription;

    @ManyToOne
    private Airplane checkedAirplane;

    @ManyToOne
    private Airport airport;

    @ManyToOne
    private MechanicalEmployee mechanicalEmployee;

}
