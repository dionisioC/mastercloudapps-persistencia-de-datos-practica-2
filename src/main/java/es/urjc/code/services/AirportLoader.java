package es.urjc.code.services;

import es.urjc.code.models.Airport;
import es.urjc.code.repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AirportLoader {

    private AirportRepository airportRepository;

    public AirportLoader(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> load() {
        System.out.println("=========================================== LOADING AIRPORTS ===========================================");
        List<Airport> airports = Arrays.asList(
            Airport.builder().city("Madrid").country("Spain").iataCode("MAD").name("Barajas").build(),
            Airport.builder().city("Amsterdam").country("Netherlands").iataCode("AMS").name("Schiphol").build(),
            Airport.builder().city("Ada").country("United states of america").iataCode("ADT").name("Ada Municipal Airport").build(),
            Airport.builder().city("Altenrhein").country("United states of america").iataCode("ACH").name("St. Gallen–Altenrhein Airport").build()
        );
        airportRepository.saveAll(airports);
        System.out.println("=========================================== FINISH LOADING AIRPORTS ===========================================");
        return airports;
    }

}
