package kr.co.hsj.petclinic.service.model.dto.request;

import kr.co.hsj.petclinic.persistence.entity.VetSpeciality;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Set;

public class VetRequestDTO {

    @Getter
    @AllArgsConstructor
    public static class Condition {

        private List<Long> ids;
    }

    @Getter
    @AllArgsConstructor
    public static class Create {

        private String firstName;
        private String lastName;
        private Set<VetSpeciality> specialties;
    }

    @Getter
    @AllArgsConstructor
    public static class Update {

        private Long id;
        private String firstName;
        private String lastName;
        private Set<VetSpeciality> specialties;
    }
}
