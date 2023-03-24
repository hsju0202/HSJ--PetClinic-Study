package kr.co.hsj.petclinic.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_pets")
@AttributeOverride(
        name = "id",
        column = @Column(name = "pet_id")
)
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
}
