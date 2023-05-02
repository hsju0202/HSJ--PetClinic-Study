package kr.co.hsj.petclinic.service.model.dto.response;

import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class PetResponseDTO {

    @Getter
    @Builder
    @ToString
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Read {

        private Long id;
        private String ownerFirstName;
        private String ownerLastName;
        private LocalDate birthDate;
        private String name;
        private String type;
    }

}
