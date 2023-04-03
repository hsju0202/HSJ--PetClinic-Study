package kr.co.hsj.petclinic.persistence.entity;

import jakarta.persistence.*;
import kr.co.hsj.petclinic.service.model.dto.request.VisitRequestDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_visits")
@AttributeOverride(
        name = "id",
        column = @Column(name = "visit_id")
)
@Getter
@NoArgsConstructor
public class Visit extends BaseEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "visit_date")
    private LocalDate visitDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Builder
    public Visit(String description, Pet pet) {
        this.description = description;
        this.pet = pet;
        this.visitDate = LocalDate.now();
    }

    public void update(VisitRequestDTO.Update updateDTO) {
        this.description = updateDTO.getDescription();
    }

}
