package kr.co.hsj.petclinic.service.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class OwnerRequestDTO {

    @Getter
    @AllArgsConstructor
    public static class Condition {

        private List<Long> ids;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Create {

        private String address;
        private String city;
        private String firstName;
        private String lastName;
        private String telephone;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Update {

        private String address;
        private String city;
        private String firstName;
        private String lastName;
        private String telephone;
    }
}
