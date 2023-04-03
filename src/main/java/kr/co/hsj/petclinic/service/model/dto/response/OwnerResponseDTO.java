package kr.co.hsj.petclinic.service.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class OwnerResponseDTO {

    @Getter
    @AllArgsConstructor
    public static class Read {

        private Long id;
        private String address;
        private String city;
        private String firstName;
        private String lastName;
        private String telephone;
    }
}
