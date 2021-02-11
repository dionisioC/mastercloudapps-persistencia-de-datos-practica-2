package es.urjc.code.services;

import es.urjc.code.models.*;
import es.urjc.code.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseLoader {
    private AirplaneLoader airplaneLoader;
    private AirportLoader airportLoader;
    private TechnicalReviewLoader technicalReviewLoader;
    private MechanicalEmployeeLoader mechanicalEmployeeLoader;
    private CrewMemberLoader crewMemberLoader;
    private FlightLoader flightLoader;

    public DatabaseLoader(AirplaneLoader airplaneLoader, AirportLoader airportLoader, TechnicalReviewLoader technicalReviewLoader, MechanicalEmployeeLoader mechanicalEmployeeLoader, CrewMemberLoader crewMemberLoader, FlightLoader flightLoader) {
        this.airplaneLoader = airplaneLoader;
        this.airportLoader = airportLoader;
        this.technicalReviewLoader = technicalReviewLoader;
        this.mechanicalEmployeeLoader = mechanicalEmployeeLoader;
        this.crewMemberLoader = crewMemberLoader;
        this.flightLoader = flightLoader;
    }

    public void load() {
        System.out.println("=========================================== LOADING ===========================================");

        List<Airplane> airplanes = airplaneLoader.load();
        List<Airport> airports = airportLoader.load();
        List<MechanicalEmployee> mechanicalEmployees = mechanicalEmployeeLoader.load();
        List<TechnicalReview> technicalReviews = technicalReviewLoader.load(airports, mechanicalEmployees, airplanes);
        List<CrewMember> crewMembers = crewMemberLoader.load();
        List<Flight> flights = flightLoader.load(airplanes, airports, crewMembers);
        System.out.println("========================================= END LOADING =========================================");
    }

}
