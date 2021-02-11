package es.urjc.code.services;

import es.urjc.code.models.*;
import es.urjc.code.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class FlightLoader {

    private FlightRepository flightRepository;

    long MINUTES_IN_MS = 1000 * 60 * 24;
    private Date now = new Date(System.currentTimeMillis());
    private Date twoHoursAndAHalfAgo = new Date(System.currentTimeMillis() - (150 * MINUTES_IN_MS));
    private Date arrivalDate = new Date(1612701233000L); // Sunday, February 7, 2021 12:33:53 PM
    private Date arrivalDate2 = new Date(1612182833000L); // Monday, February 1, 2021 12:33:53 PM

    public FlightLoader(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> load(List<Airplane> airplanes, List<Airport> airports, List<CrewMember> crewMembers) {
        System.out.println("=========================================== LOADING FLIGHTS ===========================================");
        Flight flight1 = Flight.builder().flightCode("UX1094").airline("Iberia").airplane(airplanes.get(0)).originAirport(airports.get(0)).destinationAirport(airports.get(1)).departureDate(twoHoursAndAHalfAgo).arrivalDate(arrivalDate).flightDuration(2.5F).build();
        CrewMemberFlight crewMemberFlight1 = CrewMemberFlight.builder().flight(flight1).crewMember(crewMembers.get(0)).build();
        CrewMemberFlight crewMemberFlight2 = CrewMemberFlight.builder().flight(flight1).crewMember(crewMembers.get(1)).build();
        flight1.setCrewMembers(Arrays.asList(crewMemberFlight1, crewMemberFlight2));


        Flight flight2 = Flight.builder().flightCode("UX1095").airline("Iberia").airplane(airplanes.get(1)).originAirport(airports.get(3)).destinationAirport(airports.get(1)).departureDate(twoHoursAndAHalfAgo).arrivalDate(arrivalDate).flightDuration(2.5F).build();
        CrewMemberFlight crewMemberFlight3 = CrewMemberFlight.builder().flight(flight2).crewMember(crewMembers.get(0)).build();
        CrewMemberFlight crewMemberFlight4 = CrewMemberFlight.builder().flight(flight2).crewMember(crewMembers.get(1)).build();
        flight2.setCrewMembers(Arrays.asList(crewMemberFlight3, crewMemberFlight4));


        Flight flight3 = Flight.builder().flightCode("UX1098").airline("Iberia").airplane(airplanes.get(2)).originAirport(airports.get(1)).destinationAirport(airports.get(3)).departureDate(twoHoursAndAHalfAgo).arrivalDate(arrivalDate2).flightDuration(2.5F).build();
        CrewMemberFlight crewMemberFlight5 = CrewMemberFlight.builder().flight(flight3).crewMember(crewMembers.get(0)).build();
        CrewMemberFlight crewMemberFlight6 = CrewMemberFlight.builder().flight(flight3).crewMember(crewMembers.get(1)).build();
        flight2.setCrewMembers(Arrays.asList(crewMemberFlight5, crewMemberFlight6));

        List<Flight> flights = Arrays.asList(
            flight1,
            flight2
           );
        flightRepository.saveAll(flights);
        System.out.println("=========================================== FINISH LOADING FLIGHTS ===========================================");
        return flights;
    }

}
