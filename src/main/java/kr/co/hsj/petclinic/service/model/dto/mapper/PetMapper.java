package kr.co.hsj.petclinic.service.model.dto.mapper;


import kr.co.hsj.petclinic.persistence.entity.Pet;
import kr.co.hsj.petclinic.service.model.dto.response.PetResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PetMapper {

    @Mapping(target = "ownerFirstName", source = "owner.firstName")
    @Mapping(target = "ownerLastName", source = "owner.lastName")
    PetResponseDTO.Read toReadDTO(Pet pet);

}
