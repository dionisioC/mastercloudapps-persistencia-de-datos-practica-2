package es.urjc.code.services;

import es.urjc.code.models.Airplane;
import es.urjc.code.repository.AirplaneRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class AirplaneLoader {

    private AirplaneRepository airplaneRepository;

    public AirplaneLoader(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    public List<Airplane> load() {
        System.out.println("=========================================== LOADING AIRPLANES ===========================================");
        List<Airplane> airplanes = Arrays.asList(
            Airplane.builder().flightHours(BigDecimal.valueOf(1000.508)).licensePlate("LP54125").manufacturer("Airbus").model("A380").build(),
            Airplane.builder().flightHours(BigDecimal.valueOf(200)).licensePlate("G-ZBJB").manufacturer("Boeing").model("787-8").build(),
            Airplane.builder().flightHours(BigDecimal.valueOf(288)).licensePlate("H-524964").manufacturer("Airbus").model("A321-1").build(),
            Airplane.builder().flightHours(BigDecimal.valueOf(800)).licensePlate("Q-608909").manufacturer("Airbus").model("777-300ER").build()
        );
        airplaneRepository.saveAll(airplanes);
        System.out.println("=========================================== FINISH LOADING AIRPLANES ===========================================");
        return airplanes;
    }
}
