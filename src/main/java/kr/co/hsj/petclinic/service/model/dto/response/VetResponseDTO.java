package kr.co.hsj.petclinic.service.model.dto.response;

import kr.co.hsj.petclinic.persistence.entity.PetType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

public class VetResponseDTO {

    @Getter
    @AllArgsConstructor
    public static class Read {

        private Long id;
        private String ownerName;
        private LocalDate birthDate;
        private String name;
        private PetType petType;
    }

}
