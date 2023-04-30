package kr.co.hsj.petclinic.persistence.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.stream.Collectors;
import kr.co.hsj.petclinic.service.model.dto.request.VetRequestDTO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_vets")
@AttributeOverride(
    name = "id",
    column = @Column(name = "vet_id")
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Vet extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tbl_vet_specialities", joinColumns = @JoinColumn(name = "vet_id"))
    private Set<VetSpeciality> specialties = new HashSet<>();

    @Builder
    public Vet(String firstName, String lastName, List<String> specialties) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialties = specialties.stream()
                                      .map(VetSpeciality::of)
                                      .collect(Collectors.toSet());
    }

    public void update(VetRequestDTO.Update updateDTO) {
        this.firstName = updateDTO.getFirstName();
        this.lastName = updateDTO.getLastName();
        this.specialties = updateDTO.getSpecialties()
                                    .stream()
                                    .map(VetSpeciality::of)
                                    .collect(Collectors.toSet());
    }

}
