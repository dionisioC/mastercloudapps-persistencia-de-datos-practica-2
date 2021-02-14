package es.urjc.code.repository;

import java.util.List;

import es.urjc.code.dtos.CrewMemberAccumulatedFlightTime;
import es.urjc.code.dtos.CrewMemberFlightsAndTimeInterface;
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

    @Query(value = "SELECT count(*) as totalFlights, sum(f.flight_duration) totalHours, cm.name as name, cm.last_name as lastName " +
                   "FROM flight as f, JSON_TABLE(crew_members_id, '$[*]' COLUMNS( id INT PATH '$')) as cmid " +
                   "join crew_member cm on cm.id = cmid.id group by cm.name, cm.last_name", nativeQuery = true)
    List<CrewMemberFlightsAndTimeInterface> getCrewMemberFlightsAmountAndTotalFlightTimeJson();

}
