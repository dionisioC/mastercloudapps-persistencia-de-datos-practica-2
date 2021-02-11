package es.urjc.code.repository;

import es.urjc.code.models.MechanicalEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MechanicalEmployeeRepository extends JpaRepository<MechanicalEmployee, Long> {
}
