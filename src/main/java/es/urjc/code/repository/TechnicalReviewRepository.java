package es.urjc.code.repository;

import es.urjc.code.models.TechnicalReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicalReviewRepository extends JpaRepository<TechnicalReview, Long> {
}
