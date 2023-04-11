package kr.co.hsj.petclinic.persistence.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import kr.co.hsj.petclinic.service.model.dto.request.OwnerRequestDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_owners")
@AttributeOverride(
    name = "id",
    column = @Column(name = "owner_id")
)
@Getter
@NoArgsConstructor
public class Owner extends BaseEntity {

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "telephone")
    private String telephone;

    @Builder
    public Owner(String address, String city, String firstName, String lastName, String telephone) {
        this.address = address;
        this.city = city;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
    }

    public void update(OwnerRequestDTO.Update updateDTO) {
        this.address = updateDTO.getAddress();
        this.city = updateDTO.getCity();
        this.firstName = updateDTO.getFirstName();
        this.lastName = updateDTO.getLastName();
        this.telephone = updateDTO.getTelephone();
    }
}
