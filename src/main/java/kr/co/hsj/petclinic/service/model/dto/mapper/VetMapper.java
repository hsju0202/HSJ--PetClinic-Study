package kr.co.hsj.petclinic.service.model.dto.mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import kr.co.hsj.petclinic.persistence.entity.Vet;
import kr.co.hsj.petclinic.persistence.entity.VetSpeciality;
import kr.co.hsj.petclinic.service.model.dto.response.VetResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface VetMapper {

    @Mapping(target = "specialties", source = "specialties", qualifiedByName = "specialtiesToString")
    VetResponseDTO.Read toReadDTO(Vet vet);

    @Named("specialtiesToString")
    default List<String> specialtiesToString(Set<VetSpeciality> specialities) {
        return specialities.stream()
                           .map(VetSpeciality::getVetSpecialty)
                           .collect(Collectors.toList());
    }

}
