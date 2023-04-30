package kr.co.hsj.petclinic.persistence.repository;

import java.util.List;
import kr.co.hsj.petclinic.persistence.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PetRepository extends JpaRepository<Pet, Long> {

    @Query("select p from Pet p join fetch p.owner o where o.id = ?1")
    List<Pet> findByOwnerId(Long ownerId);

}
