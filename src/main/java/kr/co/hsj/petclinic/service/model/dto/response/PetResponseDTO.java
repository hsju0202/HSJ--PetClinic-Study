package kr.co.hsj.petclinic.service.model.dto.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class PetResponseDTO {

    @Getter
    @AllArgsConstructor
    public static class Read {

        private Long id;
        private String ownerFirstName;
        private String ownerLastName;
        private LocalDate birthDate;
        private String name;
        private String type;
    }

}
