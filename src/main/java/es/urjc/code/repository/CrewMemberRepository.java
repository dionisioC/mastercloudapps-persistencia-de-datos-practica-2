package es.urjc.code.repository;

import java.util.List;

import es.urjc.code.dtos.CrewMemberAccumulatedFlightTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.urjc.code.dtos.CrewMemberDto;
import es.urjc.code.models.CrewMember;
import org.springframework.data.repository.query.Param;

public interface CrewMemberRepository extends JpaRepository<CrewMember, Long> {

    @Query(value = "SELECT new es.urjc.code.dtos.CrewMemberDto(t.name, t.lastName, a.city, f.departureDate) " +
                   "FROM CrewMember t JOIN CrewMemberFlight tf ON t.id = tf.crewMember.id JOIN Flight f ON f.id = tf.flight.id join Airport a ON a.id = f.originAirport.id " +
                   "WHERE t.code = :crewMember")
    List<CrewMemberDto> getCrewMemberDestinationCitiesAndDatesByCrewMemberCode(@Param("crewMember") String crewMember);

    @Query(value = "SELECT new es.urjc.code.dtos.CrewMemberAccumulatedFlightTime(t.name, t.lastName, COUNT(tf), SUM(f.flightDuration)) " +
                   "FROM CrewMember t join CrewMemberFlight tf ON t.id = tf.crewMember.id JOIN Flight f ON f.id = tf.flight.id " +
                   "GROUP BY t.name, t.lastName")
    List<CrewMemberAccumulatedFlightTime> getCrewMemberFlightsAmountAndTotalFlightTime();

}
