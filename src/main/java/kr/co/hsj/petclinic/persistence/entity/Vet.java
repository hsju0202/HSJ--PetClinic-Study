package kr.co.hsj.petclinic.persistence.entity;

import jakarta.persistence.*;
import kr.co.hsj.petclinic.service.model.dto.request.VetRequestDTO;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_vets")
@AttributeOverride(
        name = "id",
        column = @Column(name = "vet_id")
)
@NoArgsConstructor
public class Vet extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tbl_vet_specialities", joinColumns = @JoinColumn(name = "vet_id"))
    private Set<VetSpeciality> specialties = new HashSet<>();

    public Vet(VetRequestDTO.Create createDTO) {
        this.firstName = createDTO.getFirstName();
        this.lastName = createDTO.getLastName();
        this.specialties = createDTO.getSpecialties();
    }

    public void update(VetRequestDTO.Update updateDTO) {
        this.firstName = updateDTO.getFirstName();
        this.lastName = updateDTO.getLastName();
        this.specialties = updateDTO.getSpecialties();
    }

}
