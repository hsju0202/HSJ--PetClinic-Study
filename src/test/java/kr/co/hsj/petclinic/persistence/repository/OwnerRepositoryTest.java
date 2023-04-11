package kr.co.hsj.petclinic.persistence.repository;

import static org.junit.jupiter.api.Assertions.*;

import kr.co.hsj.petclinic.persistence.entity.Owner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class OwnerRepositoryTest {

    @Autowired
    OwnerRepository ownerRepository;

    @Test
    void existsByTelephone() {
        //given
        Owner owner = Owner.builder()
                           .telephone("010-1234-5678")
                           .build();

        ownerRepository.save(owner);

        //when
        Boolean isExists = ownerRepository.existsByTelephone("010-1234-5678");

        //then
        assertEquals(Boolean.TRUE, isExists);
    }
}