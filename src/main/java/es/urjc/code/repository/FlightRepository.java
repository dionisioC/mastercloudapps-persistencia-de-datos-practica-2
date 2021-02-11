package es.urjc.code.repository;

import es.urjc.code.dtos.FlightDto;
import es.urjc.code.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query(value = "SELECT new es.urjc.code.dtos.FlightDto(a.id, f.flightCode, f.airline, f.originAirport, f.destinationAirport, f.departureDate, f.arrivalDate, f.flightDuration) " +
                   "FROM Flight f JOIN Airport a ON a.id = f.destinationAirport.id " +
                   "WHERE a.city = :city " +
                   "AND FUNCTION('DATE', f.arrivalDate) = FUNCTION('DATE', :date) " +
                   "ORDER BY f.arrivalDate DESC")
    List<FlightDto> findFlightsByCityAndDateOrderedByTime(@Param("city") String city, @Param("date") String date);

}
