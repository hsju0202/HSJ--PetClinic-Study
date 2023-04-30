package kr.co.hsj.petclinic.persistence.entity;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VetSpeciality {

    RADIOLOGY("방사선학"),
    SURGERY("외과"),
    DENTISTRY("치과학");

    final String vetSpecialty;

    public static VetSpeciality of(String vetSpecialty) {

        return Arrays.stream(VetSpeciality.values())
                     .filter(specialty -> specialty.vetSpecialty.equalsIgnoreCase(vetSpecialty))
                     .findAny().orElseThrow(() -> new RuntimeException("Not Found Vet Specialty"));
    }

}
