package kr.co.hsj.petclinic.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_vets")
@AttributeOverride(
        name = "id",
        column = @Column(name = "vet_id")
)
public class Vet extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "vet_specialty")
    @Enumerated(value = EnumType.STRING)
    private VetSpeciality specialty;
}
