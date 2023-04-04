package kr.co.hsj.petclinic.service.model.dto.request;

import kr.co.hsj.petclinic.persistence.entity.PetType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

public class PetRequestDTO {

    @Getter
    @AllArgsConstructor
    public static class Condition {

        private List<Long> ids;
    }

    @Getter
    @AllArgsConstructor
    public static class Create {

        private Long ownerId;
        private LocalDate birthDate;
        private String name;
        private PetType petType;
    }

    @Getter
    @AllArgsConstructor
    public static class Update {

        private Long id;
        private LocalDate birthDate;
        private String name;
        private PetType petType;
    }

}
