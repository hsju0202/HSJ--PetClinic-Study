package kr.co.hsj.petclinic.persistence.entity;

import jakarta.persistence.*;
import kr.co.hsj.petclinic.service.model.dto.request.PetRequestDTO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_pets")
@AttributeOverride(
    name = "id",
    column = @Column(name = "pet_id")
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Pet extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "name")
    private String name;

    @Column(name = "pet_type")
    @Enumerated(value = EnumType.STRING)
    private PetType type;

    @Builder
    public Pet(Owner owner, LocalDate birthDate, String name, PetType petType) {
        this.owner = owner;
        this.birthDate = birthDate;
        this.name = name;
        this.type = petType;
    }

    public void update(PetRequestDTO.Update updateDTO) {
        this.birthDate = updateDTO.getBirthDate();
        this.name = updateDTO.getName();
        this.type = updateDTO.getPetType();
    }
}
