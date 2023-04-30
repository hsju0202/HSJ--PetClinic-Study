package kr.co.hsj.petclinic.service.model.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class OwnerResponseDTO {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Read {

        private Long id;
        private String address;
        private String city;
        private String firstName;
        private String lastName;
        private String telephone;
    }
}
