package kr.co.hsj.petclinic.persistence.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_owners")
@AttributeOverride(
        name = "id",
        column = @Column(name = "owner_id")
)
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

}
