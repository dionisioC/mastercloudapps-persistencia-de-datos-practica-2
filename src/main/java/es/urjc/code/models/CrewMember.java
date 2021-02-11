package es.urjc.code.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CrewMember extends Employee {

    private String role;
    private String companyName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crewMember")
    private List<CrewMemberFlight> flights = new ArrayList<>();

    @Builder
    public CrewMember(String code, String name, String lastName, String role, String companyName) {
        super(code, name, lastName);
        this.role = role;
        this.companyName = companyName;
    }
}
