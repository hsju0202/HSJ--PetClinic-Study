package kr.co.hsj.petclinic.service.model.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class VetResponseDTO {

    @Getter
    @AllArgsConstructor
    public static class Read {

        private Long id;
        private String firstName;
        private String lastName;
        private List<String> specialties;
    }

}
