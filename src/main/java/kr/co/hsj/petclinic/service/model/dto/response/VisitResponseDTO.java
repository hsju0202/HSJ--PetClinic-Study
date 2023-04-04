package kr.co.hsj.petclinic.service.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

public class VisitResponseDTO {

    @Getter
    @AllArgsConstructor
    public static class Read {

        private Long id;
        private String petName;
        private LocalDate visitDate;
        private String description;
    }

}
