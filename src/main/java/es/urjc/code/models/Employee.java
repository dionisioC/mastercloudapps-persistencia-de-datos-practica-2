package es.urjc.code.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Employee {

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
    private String code;
    private String name;
    private String lastName;

    public Employee(String code, String name, String lastName) {
        this.code = code;
        this.name = name;
        this.lastName = lastName;
    }
}
