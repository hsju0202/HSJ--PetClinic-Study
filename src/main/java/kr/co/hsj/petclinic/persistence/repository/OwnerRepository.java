package kr.co.hsj.petclinic.persistence.repository;

import kr.co.hsj.petclinic.persistence.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    boolean existsByTelephone(String telephone);
}
