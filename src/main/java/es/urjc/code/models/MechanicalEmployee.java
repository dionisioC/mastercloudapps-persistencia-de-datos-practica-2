package es.urjc.code.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MechanicalEmployee extends Employee {

    private String company;
    private Date startingDate;
    private String education;

    @OneToMany(mappedBy = "mechanicalEmployee")
    private List<TechnicalReview> technicalReview;

    @Builder
    public MechanicalEmployee(String code, String name, String lastName, String companyName, Date startingDate, String education) {
        super(code, name, lastName);
        this.company = companyName;
        this.startingDate = startingDate;
        this.education = education;
    }
}
