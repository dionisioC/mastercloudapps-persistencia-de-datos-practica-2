package es.urjc.code.services;

import es.urjc.code.dtos.AirplaneDto;
import es.urjc.code.dtos.FlightDto;
import es.urjc.code.dtos.CrewMemberAccumulatedFlightTime;
import es.urjc.code.dtos.CrewMemberDto;
import es.urjc.code.repository.AirplaneRepository;
import es.urjc.code.repository.FlightRepository;
import es.urjc.code.repository.CrewMemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class DatabaseQueryRunner {
    private AirplaneRepository airplaneRepository;
    private FlightRepository flightRepository;
    private CrewMemberRepository crewMemberRepository;

    long MINUTES_IN_MS = 1000 * 60 * 24;

    public DatabaseQueryRunner(AirplaneRepository airplaneRepository, FlightRepository flightRepository, CrewMemberRepository crewMemberRepository) {
        this.airplaneRepository = airplaneRepository;
        this.flightRepository = flightRepository;
        this.crewMemberRepository = crewMemberRepository;
    }

    public void run() {
        System.out.println("=========================================== QUERING ===========================================");

        this.query1();
        this.query2();
        this.query3();
        this.query4();

        System.out.println("=========================================== STOP QUERING ===========================================");
    }

    private void query1() {
        System.out.println("=========================================== QUERY 1 ===========================================");
        System.out.println("Para cada avión, mostrar el nombre y apellidos de los mecánicos responsables de sus revisiones.");
        System.out.println("\n");

        List<AirplaneDto> airplaneDtos = airplaneRepository.findAirplaneMechanicalReviewer();
        for (AirplaneDto airplaneDto : airplaneDtos) {
            System.out.println(airplaneDto);
        }
    }

    private void query2() {
        System.out.println("=========================================== QUERY 2 ===========================================");
        System.out.println("Dado el nombre de una ciudad y una fecha, listado de los vuelos que han aterrizado (destino) en los aeropuertos de esa ciudad en esa fecha, ordenados por hora.");
        System.out.println("\n");

        LocalDate flightDtoDate = LocalDate.parse(
            "2021-02-07" ,
            DateTimeFormatter.ofPattern( "yyyy-MM-dd" )
            );

        String city = "Amsterdam";
        String date = flightDtoDate.toString();

        System.out.println("-----Query parameters: ");
        System.out.println("-----1. - City: " + city);
        System.out.println("-----2. - Date: " + date);
        System.out.println("\n");

        List<FlightDto> flightDtos = flightRepository.findFlightsByCityAndDateOrderedByTime(city, date);
        for (FlightDto flightDto : flightDtos) {
            System.out.println(flightDto);
        }
    }

    private void query3() {
        System.out.println("=========================================== QUERY 3 ===========================================");
        System.out.println("Dado el código de empleado de un tripulante, mostrar su nombre y apellidos y las ciudades desde las que ha despegado junto con la fecha en que despegó.");
        System.out.println("\n");

        String code = "code01";

        System.out.println("-----Query parameters: ");
        System.out.println("-----1. - Code: " + code);
        System.out.println("\n");

        List<CrewMemberDto> crewMemberDtos = crewMemberRepository.getCrewMemberDestinationCitiesAndDatesByCrewMemberCode(code);
        for (CrewMemberDto crewMemberDto : crewMemberDtos) {
            System.out.println(crewMemberDto);
        }
    }

    private void query4() {
        System.out.println("=========================================== QUERY 4 ===========================================");
        System.out.println("Para cada tripulante, mostrar su nombre y apellidos junto con su número total de vuelos y la suma de horas de estos.");
        System.out.println("\n");

        List<CrewMemberAccumulatedFlightTime> crewMemberAccumulatedFlightTime = crewMemberRepository.getCrewMemberFlightsAmountAndTotalFlightTime();
        for (CrewMemberAccumulatedFlightTime info : crewMemberAccumulatedFlightTime) {
            System.out.println(info);
        }
    }
}
