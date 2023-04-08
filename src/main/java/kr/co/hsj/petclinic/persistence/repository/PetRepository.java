package kr.co.hsj.petclinic.persistence.repository;

import kr.co.hsj.petclinic.persistence.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
