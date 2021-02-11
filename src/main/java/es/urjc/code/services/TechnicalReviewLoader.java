package es.urjc.code.services;

import es.urjc.code.models.Airplane;
import es.urjc.code.models.Airport;
import es.urjc.code.models.MechanicalEmployee;
import es.urjc.code.models.TechnicalReview;
import es.urjc.code.repository.TechnicalReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class TechnicalReviewLoader {

    private TechnicalReviewRepository technicalReviewRepository;

    public TechnicalReviewLoader(TechnicalReviewRepository technicalReviewRepository) {
        this.technicalReviewRepository = technicalReviewRepository;
    }

    public List<TechnicalReview> load(List<Airport> airports, List<MechanicalEmployee> mechanicalEmployees, List<Airplane> airplanes) {
        System.out.println("=========================================== LOADING TECHNICAL REVIEWS ===========================================");
        List<TechnicalReview> technicalReviews = Arrays.asList(
            TechnicalReview.builder().reviewType("Periodical").spentHoursOnReview(10).startDate(new Date(System.currentTimeMillis() - 50000000)).endDate(new Date(System.currentTimeMillis())).workDescription("Work description OK").checkedAirplane(airplanes.get(0)).mechanicalEmployee(mechanicalEmployees.get(0)).airport(airports.get(0)).build(),
            TechnicalReview.builder().reviewType("Wheels").spentHoursOnReview(10).startDate(new Date(System.currentTimeMillis() - 50000000)).endDate(new Date(System.currentTimeMillis())).workDescription("Work description OK").checkedAirplane(airplanes.get(1)).mechanicalEmployee(mechanicalEmployees.get(0)).airport(airports.get(1)).build(),
            TechnicalReview.builder().reviewType("Engine").spentHoursOnReview(10).startDate(new Date(System.currentTimeMillis() - 50000000)).endDate(new Date(System.currentTimeMillis())).workDescription("Work description OK").checkedAirplane(airplanes.get(0)).mechanicalEmployee(mechanicalEmployees.get(1)).airport(airports.get(3)).build(),
            TechnicalReview.builder().reviewType("TooMany kilometers").spentHoursOnReview(10).startDate(new Date(System.currentTimeMillis() - 50000000)).endDate(new Date(System.currentTimeMillis())).workDescription("Work description OK").checkedAirplane(airplanes.get(2)).mechanicalEmployee(mechanicalEmployees.get(0)).airport(airports.get(2)).build(),
            TechnicalReview.builder().reviewType("Paint and spray").spentHoursOnReview(10).startDate(new Date(System.currentTimeMillis() - 50000000)).endDate(new Date(System.currentTimeMillis())).workDescription("Work description OK").checkedAirplane(airplanes.get(3)).mechanicalEmployee(mechanicalEmployees.get(3)).airport(airports.get(1)).build(),
            TechnicalReview.builder().reviewType("Lights").spentHoursOnReview(10).startDate(new Date(System.currentTimeMillis() - 50000000)).endDate(new Date(System.currentTimeMillis())).workDescription("Work description OK").checkedAirplane(airplanes.get(0)).mechanicalEmployee(mechanicalEmployees.get(2)).airport(airports.get(0)).build()
        );
        technicalReviewRepository.saveAll(technicalReviews);
        System.out.println("=========================================== FINISH LOADING TECHNICAL REVIEWS ===========================================");
        return technicalReviews;
    }

}
