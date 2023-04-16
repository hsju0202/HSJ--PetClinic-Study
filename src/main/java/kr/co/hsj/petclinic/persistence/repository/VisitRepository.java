package kr.co.hsj.petclinic.persistence.repository;

import java.util.List;
import kr.co.hsj.petclinic.persistence.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VisitRepository extends JpaRepository<Visit, Long> {

    @Query("select v from Visit v join fetch v.pet p where p.owner.id = ?1")
    List<Visit> findByOwnerId(Long ownerId);

}
