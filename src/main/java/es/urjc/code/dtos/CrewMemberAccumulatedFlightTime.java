package es.urjc.code.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrewMemberAccumulatedFlightTime {

    private String name;
    private String lastName;
    private Long numberOfFlights;
    private Double totalTime;

    @Override
    public String toString() {
        return
            "------Crew Member accumulated flight time-------" +
                "\n###### Crew Member ######\n" +
                "\tName='" + name + "'\n" +
                "\tLast Name='" + lastName + "'\n" +
                "\tNumber of flights='" + numberOfFlights + "'\n" +
                "\tAccumulated time='" + totalTime + "'\n";
    }
}
