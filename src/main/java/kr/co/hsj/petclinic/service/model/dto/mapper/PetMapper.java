package kr.co.hsj.petclinic.service.model.dto.mapper;


import kr.co.hsj.petclinic.persistence.entity.Pet;
import kr.co.hsj.petclinic.persistence.entity.PetType;
import kr.co.hsj.petclinic.service.model.dto.response.PetResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PetMapper {

    @Mapping(target = "ownerFirstName", source = "owner.firstName")
    @Mapping(target = "ownerLastName", source = "owner.lastName")
    @Mapping(target = "type", source = "type", qualifiedByName = "typeToString")
    PetResponseDTO.Read toReadDTO(Pet pet);

    @Named("typeToString")
    default String typeToString(PetType petType) {
        return petType.getPetType();
    }
}
