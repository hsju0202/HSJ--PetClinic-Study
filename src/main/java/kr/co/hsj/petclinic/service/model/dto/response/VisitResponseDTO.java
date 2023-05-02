package kr.co.hsj.petclinic.service.model.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class VisitResponseDTO {

    @Getter
    @Builder
    @ToString
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Read {

        private Long id;
        private String petName;
        private LocalDate visitDate;
        private String description;
    }

}
