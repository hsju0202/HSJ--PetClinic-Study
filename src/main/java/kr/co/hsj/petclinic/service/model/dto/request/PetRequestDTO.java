package kr.co.hsj.petclinic.service.model.dto.request;

import java.time.LocalDate;
import java.util.List;
import kr.co.hsj.petclinic.persistence.entity.PetType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class PetRequestDTO {

    @Getter
    @Builder
    @ToString
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Condition {

        private List<Long> ids;
        private Long ownerId;
    }

    @Getter
    @Builder
    @ToString
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Create {

        private Long ownerId;
        private LocalDate birthDate;
        private String name;
        private String petType;
    }

    @Getter
    @Builder
    @ToString
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Update {

        private LocalDate birthDate;
        private String name;
        private PetType petType;
    }

}
