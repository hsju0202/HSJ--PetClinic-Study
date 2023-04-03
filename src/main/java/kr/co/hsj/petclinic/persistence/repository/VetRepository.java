package kr.co.hsj.petclinic.persistence.repository;

import kr.co.hsj.petclinic.persistence.entity.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepository extends JpaRepository<Vet, Long> {
}
