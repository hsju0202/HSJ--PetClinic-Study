package kr.co.hsj.petclinic.service.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public class VisitRequestDTO {

    @Getter
    @AllArgsConstructor
    public static class Condition {

        private List<Long> ids;
    }
    @Getter
    @AllArgsConstructor
    public static class Create {

        private Long petId;
        private String description;
    }

    @Getter
    @AllArgsConstructor
    public static class Update {

        private Long id;
        private String description;
    }

}
