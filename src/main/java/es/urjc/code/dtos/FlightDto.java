package es.urjc.code.dtos;

import es.urjc.code.models.Airport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {

    private long id;

    private String flightCode;
    private String airline;
    private Airport originAirport;
    private Airport destinationAirport;
    private Date departureDate;
    private Date arrivalDate;
    private Float flightDuration;

    public String toString(){
      return
        "-----Arrived flights by city and date-----" +
            "\n##### Flight #####" +
            "\nCode='" + flightCode + "'" +
            "\nAirline='" + airline + "'" +
            "\nOrigin airport='" + originAirport.getName()+ "(" + originAirport.getIataCode() + ")" + "'" +
            "\nDeparture date='" + departureDate.toString() + "'" +
            "\nArrival date='" + departureDate.toString() + "'" +
            "\nFlight duration='" + flightDuration.toString() + "\n";
    };
}
